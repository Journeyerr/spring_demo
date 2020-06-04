package com.zayan.www.netty.client;

import com.zayan.www.netty.server.NettyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * 客户端初始化需执行
 * @author AnYuan
 *
 */

public class NettyClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        ch.pipeline().addLast("encode", new StringEncoder(CharsetUtil.UTF_8));
        ch.pipeline().addLast(new NettyClientHandler());

        System.out.println("NettyClientChannelInitializer------->>>>>>   " + ch.id().toString());
    }
}
