package com.zayan.www.config.netty.server;


import com.alibaba.fastjson.JSONObject;
import com.zayan.www.config.websocket.WebsocketMsgDTO;
import com.zayan.www.util.DateUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * server handler
 *
 * @author AnYuan
 */

public class NettyServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static final ChannelGroup CHANNELS = new DefaultChannelGroup("rooms", GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        CHANNELS.add(ctx.channel());
        System.out.println("NettyServerHandler 加入连接：" + ctx.channel().id()
                + "；房间在线人数: " + CHANNELS.size());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        CHANNELS.remove(ctx.channel());
        System.out.println("NettyServerHandler 断开连接：" + ctx.channel().id()
                + "；房间在线人数: " + CHANNELS.size());
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("NettyServerHandler 活动用户：" + ctx.channel().id());
        WebsocketMsgDTO msgDTO = new WebsocketMsgDTO("机器人", ctx.channel().id() + "加入房间");
        ctx.channel().writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(msgDTO)));
        CHANNELS.forEach(channel -> {
            channel.writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(msgDTO)));
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        System.out.println("NettyServerHandler 异常用户：" + ctx.channel().id());
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame textWebSocketFrame) {
        System.out.println("NettyServerHandler 接收消息：" + ctx.channel().id());
        WebsocketMsgDTO msgDTO = JSONObject.parseObject(textWebSocketFrame.text(), WebsocketMsgDTO.class);
        msgDTO.setDateTime(DateUtil.nowDateTimeString());
        System.out.println("NettyServerHandler 消息内容：" + textWebSocketFrame.text());
        CHANNELS.forEach(channel -> {
            channel.writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(msgDTO)));
        });
    }
}
