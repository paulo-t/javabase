package com.paulo.javabase.module4.task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.javabase.module4.task4
 * @date:2020/7/31
 */
public class UserServer {
    //程序端口号
    private static final int PORT = 9001;

    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket accept = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            //1.创建服务区
            ss = new ServerSocket(PORT);
            System.out.println("用户服务器启动成功");

            //2.客户端连接
            accept = ss.accept();
            System.out.println("客户端 " + accept.getLocalAddress().getHostName() + "连接成功");

            //3.接收消息
            objectInputStream = new ObjectInputStream(accept.getInputStream());
            Object obj = objectInputStream.readObject();


            //4.消息判断
            UserMessage userMessage = null == obj ? new UserMessage() : (UserMessage)obj;
            String userName = null == userMessage.getUser() ? "" : userMessage.getUser().getUserName();
            String password = null == userMessage.getUser() ? "" : userMessage.getUser().getPassword();

            if ("admin".equals(userName) && "123456".equals(password)) {
                userMessage.setType("success");
            } else {
                userMessage.setType("fail");
            }

            //5.回复消息
            objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
            objectOutputStream.writeObject(userMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != objectOutputStream){
                    objectOutputStream.close();
                }
                if(null != objectInputStream){
                    objectInputStream.close();
                }
                if(null != accept){
                    accept.close();
                }
                if(null != ss){
                    ss.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
