package com.paulo.javabase.module4.task5.client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReceiveThread extends Thread {
    /**
     * 连接
     */
    private Socket socket;

    public ClientReceiveThread(Socket socket) {
        this.socket = socket;
    }

    private static final int FILE_MAX_SIZE = 1024 * 1024;

    @Override
    public void run() {
        System.out.println("接收线程启动完毕...");

        BufferedInputStream bif = null;

        try {
            while (true) {
                if(socket.isClosed()){
                    System.out.println("socket已经关闭");
                    break;
                }

                bif = new BufferedInputStream(socket.getInputStream());

                byte[] buffer = new byte[FILE_MAX_SIZE];

                int len;

                while (-1 != (len = bif.read(buffer))) {
                    System.out.println(socket.getLocalAddress().getHostName() + "接收到的消息为：" + new String(buffer, 0, len));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != bif){
                try {
                    bif.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

