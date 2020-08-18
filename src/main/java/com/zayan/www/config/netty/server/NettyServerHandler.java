package com.zayan.www.config.netty.server;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * server handler
 * @author AnYuan
 */

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    private static ChannelGroup channels = new DefaultChannelGroup("rooms", GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channels.add(ctx.channel());
        System.out.println("NettyServerHandler handlerAdded --->>> "
                + ctx.channel().id()
                + " Join Room  --->>> Online:" +channels.size());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channels.remove(ctx.channel());
        System.out.println("NettyServerHandler handlerRemoved --->>> "
                + ctx.channel().id()
                + " left Room  --->>> Online:" +channels.size());
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("NettyServerHandler channelActive --->>> " + ctx.channel().id());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("NettyServerHandler exceptionCaught --->>> " + ctx.channel().id());
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("NettyServerHandler ChannelRead --->>> " + ctx.channel().id());
        System.out.println("Server: " + ctx.channel().remoteAddress() + " --->>> " + msg.toString());

        channels.forEach( v -> {
            System.out.println("push------>> " + v.id());

            v.writeAndFlush("NettyServerHandler " + ctx.channel().id() +" say: " + msg.toString());
        });
//
//        // 将消息写入返回ctx
//        ctx.write("NettyServerHandler " + ctx.channel().id() +" say: " + msg.toString());
//        // 属性缓存区
//        ctx.channel().flush();
    }


}
