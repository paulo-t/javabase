package com.paulo.javabase.module4.task5.client;

import com.paulo.javabase.module4.task5.server.MessageEntity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;

public class ClientReceiveThread extends Thread {
    /**
     * 连接
     */
    private Socket socket;

    public ClientReceiveThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("接收线程启动完毕...");

        ObjectInputStream ois = null;

        try {
            while (true) {
                if(socket.isClosed()){
                    System.out.println("socket已经关闭");
                    break;
                }

                ois = new ObjectInputStream(socket.getInputStream());

                Object obj = ois.readObject();

                if(null != obj){
                    MessageEntity messageEntity = (MessageEntity)obj;

                    if(messageEntity.getType() == 0){
                        System.out.println(socket.getInetAddress().getHostName() + "接收到的群发消息为: " + new String(messageEntity.getMessage()));
                    }else if(messageEntity.getType() == 1){
                        System.out.println(socket.getInetAddress().getHostName() + "接收到的群发消息为图片: " + messageEntity.getFileName());
                    }else if(messageEntity.getType() == 2){
                        System.out.println(socket.getInetAddress().getHostName() + "接收到的群发消息为txt文档: " + messageEntity.getFileName());
                    }else {
                        System.out.println(socket.getInetAddress().getHostName() + "接收到的群发消息为文件: " + messageEntity.getFileName());
                    }

                }
            }
        }catch (SocketException e){
            System.out.println("socket断开连接");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(null != ois){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

