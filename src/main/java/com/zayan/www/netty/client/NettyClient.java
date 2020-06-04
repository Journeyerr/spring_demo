package com.zayan.www.netty.client;

import cn.hutool.socket.nio.NioClient;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

/**
 * netty client
 * @author AnYuan
 */

public class NettyClient {

    static final String HOST = "127.0.0.1";
    static final Integer PORT = 7000;
    static final Integer SIZE = 256;

    public static void main(String[] args) {
        sendMsg("Hello World ------11111----");
    }


    public static void sendMsg(String content) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new NettyClientChannelInitializer());

            ChannelFuture future = bootstrap.connect(HOST, PORT).sync();

            future.channel().writeAndFlush(content);
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
            group.shutdownGracefully();
        }finally {
            group.shutdownGracefully();
        }
    }
}
