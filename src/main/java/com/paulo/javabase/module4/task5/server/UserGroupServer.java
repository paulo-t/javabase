package com.paulo.javabase.module4.task5.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: 服务器入口程序 使用基于 tcp 协议的编程模型实现多人同时在线聊天和传输文件，要求每个客户端将发 送的聊天内容和文件发送到服务器，服务器接收到后转发给当前所有在线的客户端。
 * @date:2020/7/31
 */
public class UserGroupServer {
    //存放数据的消息队列
    private static MessageQueue messageQueue = new MessageQueue();

    //socket名称前缀
    private static final String SOCKET_NAME_PREFIX = "SOCKET";

    /**
     * 连接计数器
     */
    private static int socketCounter = 0;

    /**
     *程序启动端口
     */
    private static final int PORT = 9001;


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("服务器启动成功");
            //群发消息的线程
            new UserSendThread(messageQueue).start();

            while (true) {
                Socket accept = serverSocket.accept();
                System.out.println("服务器启动成功");

                //建立连接信息
                ConnectInfo connectInfo = establishConnect(accept);

                //保存连接信息
                ConnectInfoMgr.addConnectInfo(connectInfo);

                System.out.println(connectInfo.getName() + "连接成功");

                //新开一个线程处理接受到的消息
                new UserReceiveThread(connectInfo, messageQueue).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接id
     */
    private synchronized static int getSocketId() {
        return ++socketCounter;
    }

    /**
     * 建立连接
     */
    private static ConnectInfo establishConnect(Socket socket) {
        int socketId = getSocketId();

        ConnectInfo connectInfo = new ConnectInfo(socketId, SOCKET_NAME_PREFIX + socketId, socket);

        return connectInfo;
    }
}
