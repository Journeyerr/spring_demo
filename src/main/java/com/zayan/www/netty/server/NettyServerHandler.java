package com.zayan.www.netty.server;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * server handler
 * @author AnYuan
 */

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String channelId = ctx.channel().id().toString();
        System.out.println("NettyServerHandler channelActive --->>> " + channelId);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("NettyServerHandler exceptionCaught --->>> " + ctx.channel().id().toString());
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("NettyServerHandler ChannelRead --->>> " + ctx.channel().id().toString());
        System.out.println("Server: " + ctx.channel().remoteAddress() + " --->>> " + msg.toString());
        // 将消息写入返回ctx
        ctx.write("NettyServerHandler " + ctx.channel().id().toString() +" say: " + msg.toString());
        // 属性缓存区
        ctx.channel().flush();
    }


}
