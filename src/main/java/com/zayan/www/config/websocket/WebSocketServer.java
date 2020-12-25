package com.zayan.www.config.websocket;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.zayan.www.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/webSocket/{uid}")
@Component
@Slf4j
public class WebSocketServer {

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的Session对象
     */
    private static final ConcurrentHashMap<String, Session> SESSION_POOLS = new ConcurrentHashMap<>();

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static final AtomicInteger ONLINE_NUM = new AtomicInteger();

    private String buildMsg(String uid, String message) {
        HashMap<String, Object> maps = Maps.newHashMapWithExpectedSize(3);
        maps.put("sendUserId", uid);
        maps.put("content", message);
        maps.put("dateTime", DateUtil.localDateTimeStr());
        return JSONObject.toJSONString(maps);
    }

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
        sendToAll(buildMsg(uid, "欢迎：" + uid + " 加入连接！"));
        System.out.println(uid + "加入webSocket！当前人数为" + ONLINE_NUM);
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
        sendToAll(buildMsg(uid, uid + " 断开连接"));
        System.out.println(uid + " 断开webSocket连接！当前人数为：" + ONLINE_NUM);
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

        JSONObject jsonObject = JSONObject.parseObject(message);
        Object toUserId = jsonObject.get("toUserId");

        if (Objects.isNull(toUserId)) {
            sendToAll(buildMsg(uid, jsonObject.get("content").toString()));
        } else {
            sendMsgByUid(toUserId.toString(), buildMsg(uid, jsonObject.get("content").toString()));
        }
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
     *
     * @param message msg
     */
    public void sendToAll(String message) {
        for (Session session : SESSION_POOLS.values()) {
            try {
                sendMessage(session, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给指定用户发送信息
     *
     * @param uid     用户标志
     * @param message 消息
     */
    public void sendMsgByUid(String uid, String message) {
        Session session = SESSION_POOLS.get(uid);
        try {
            sendMessage(session, message);
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
