package com.zayan.www.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostUtil {
    private static String host;

    static {
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            host = "127.0.0.1";
        }
    }

    public static String getHost() {
        return host;
    }
}
