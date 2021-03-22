package com.base.jvm.method;

import java.lang.management.ManagementFactory;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @Description 获取JVM信息的一些方法
 * @Author Monster
 * @Date 2021/3/22 17:05
 * @Version 1.0
 */
public class JvmInfo {

    public static void main(String[] args) throws SocketException {
        // 返回数据： jvm pid@计算机名称
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // 获取机器mac地址
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        String macHex = null;
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            byte[] mac = nextElement.getHardwareAddress();
            // 第一个不为空的mac地址即为本机mac, 后面的包括虚拟机的地址、WIFI的地址等
            if (mac != null) {
                // 将mac地址转换为十六进制
                macHex = bytesToHexMac(mac);
                break;
            }
        }
        System.out.println(macHex);
    }

    public static String bytesToHexMac(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            buf.append(String.format("%02x", new Integer(bytes[i] & 0xff)));
            if (i != bytes.length - 1) {
                buf.append(":");
            }
        }
        return buf.toString();
    }
}
