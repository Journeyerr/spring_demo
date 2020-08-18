package com.zayan.www.config.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * 服务端初始化需执行
 * @author AnYuan
 *
 */

public class NettyChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
        ch.pipeline().addLast("encode", new StringEncoder(CharsetUtil.UTF_8));
        ch.pipeline().addLast(new NettyServerHandler());

        System.out.println("NettyChannelInit --->>> " + ch.id().toString());
    }
}
