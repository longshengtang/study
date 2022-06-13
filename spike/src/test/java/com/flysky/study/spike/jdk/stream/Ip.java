package com.flysky.study.spike.jdk.stream;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ip {

    @Test
    public void test() {
        System.out.println("serviceIp() = " + serviceIp());
    }
    public static String serviceIp() {
        String result = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            result = address.getHostAddress();
        } catch (UnknownHostException e) {
//            logger.error("------>调用 IpUtil.servicerIp，错误信息如下");
//            logger.error(e.getMessage(), e);
        }
        return result;
    }

}
