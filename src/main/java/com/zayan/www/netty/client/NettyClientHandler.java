package com.zayan.www.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * netty client
 * @author AnYuan
 */


public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyClientHandler channelActive --->>>> " + ctx.channel().id());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("NettyClientHandler channelRead --->>> " + ctx.channel().id());
        System.out.println("Message: " + msg.toString());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("NettyClientHandler exceptionCaught --->>> " + ctx.channel().id());
        cause.printStackTrace();
        ctx.channel().close();
    }
}
