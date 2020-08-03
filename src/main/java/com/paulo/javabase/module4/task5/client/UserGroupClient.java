package com.paulo.javabase.module4.task5.client;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端入口程序
 */
public class UserGroupClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9001);


        System.out.println("服务器连接成功");

        new ClientReceiveThread(socket).start();

        new ClientSendThread(socket).start();
    }
}
