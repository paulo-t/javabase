package com.paulo.javabase.module4.task4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.javabase.module4.task4
 * @date:2020/7/31
 */
public class UserClient {
    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        Scanner sc = null;
        ObjectInputStream objectInputStream = null;

        try {
            //1.连接服务器
            socket = new Socket("127.0.0.1",9001);

            //2.写信息
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

            sc = new Scanner(System.in);
            System.out.println("请输入用户名和密码");
            String userName = sc.next();
            String password = sc.next();
            UserMessage tum = new UserMessage("check", new UserMessage.User(userName, password));

            objectOutputStream.writeObject(tum);

            //3.读取返回消息
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object obj = objectInputStream.readObject();

            UserMessage userMessage = (UserMessage) obj;
            if(null != userMessage && null != userMessage.getType() && "success".equalsIgnoreCase(userMessage.getType())){
                System.out.println("登录成功");
                return;
            }

            System.out.println("登录失败!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(null != sc){
                sc.close();
            }

            try {
                if(null != objectInputStream){
                    objectInputStream.close();
                }

                if(null != objectOutputStream){
                    objectOutputStream.close();
                }

                if(null != socket){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
