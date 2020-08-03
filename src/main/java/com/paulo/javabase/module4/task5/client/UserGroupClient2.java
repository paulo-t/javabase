package com.paulo.javabase.module4.task5.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 客户端
 */
public class UserGroupClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9001);

        PrintStream ps = new PrintStream(socket.getOutputStream());


        System.out.println("服务器连接成功");

        new ClientReceiveThread(socket).start();

        new ClientSendThread(socket).start();
    }
}
