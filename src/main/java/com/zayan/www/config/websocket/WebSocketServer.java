package com.zayan.www.config.websocket;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/webSocket/{uid}")
@Component
@Slf4j
public class WebSocketServer {

    /**
     * 管理员发言名称
     */
    private static final String SPOKESMAN_ADMIN = "机器人";

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的Session对象
     */
    private static final ConcurrentHashMap<String, Session> SESSION_POOLS = new ConcurrentHashMap<>();

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static final AtomicInteger ONLINE_NUM = new AtomicInteger();

    /**
     * 建立连接成功调用
     *
     * @param session 用户集合
     * @param uid     用户标志
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "uid") String uid) {
        SESSION_POOLS.put(uid, session);
        ONLINE_NUM.incrementAndGet();
        sendToAll(null, uid + " 加入连接！");
    }

    /**
     * 关闭连接时调用
     *
     * @param uid 用户标志
     */
    @OnClose
    public void onClose(@PathParam(value = "uid") String uid) {
        SESSION_POOLS.remove(uid);
        ONLINE_NUM.decrementAndGet();
        sendToAll(null, uid + " 断开连接！");
    }

    /**
     * 收到客户端信息
     *
     * @param message 客户端发来的string
     * @param uid     uid 用户标志
     */
    @OnMessage
    public void onMessage(String message, @PathParam(value = "uid") String uid) {
        log.info("Client:[{}]， Message: [{}]", uid, message);
        WebsocketMsgDTO msgDTO = JSONObject.parseObject(message, WebsocketMsgDTO.class);
        if (Strings.isNotBlank(msgDTO.getToUId())) {
            sendMsgByUid(uid, msgDTO.getToUId(), msgDTO.getContent());
            sendMsgByUid(uid, uid, msgDTO.getContent());
            return;
        }
        sendToAll(uid, msgDTO.getContent());
    }

    /**
     * 错误时调用
     *
     * @param session   用户标志
     * @param throwable throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        log.info("WebSocket_OnError:{}", session);
        throwable.printStackTrace();
    }

    /**
     * 给所有人发送消息
     * @param content content
     */
    public void sendToAll(String uid, String content) {
        String msg = JSONObject.toJSONString(new WebsocketMsgDTO(Objects.isNull(uid) ? SPOKESMAN_ADMIN : uid, content));
        for (Session session : SESSION_POOLS.values()) {
            try {
                sendMessage(session, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给指定用户发送信息
     *
     * @param uid     发送消息用户
     * @param toUId   接收消息用户
     * @param content 消息
     */
    public void sendMsgByUid(String uid, String toUId, String content) {
        String msg = JSONObject.toJSONString(new WebsocketMsgDTO(uid, toUId, content));
        try {
            sendMessage(SESSION_POOLS.get(toUId), msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息
     *
     * @param session 用户
     * @param message 消息
     * @throws IOException
     */
    public void sendMessage(Session session, String message) throws IOException {
        if (Objects.nonNull(session)) {
            synchronized (session) {
                session.getBasicRemote().sendText(message);
            }
        }
    }
}
