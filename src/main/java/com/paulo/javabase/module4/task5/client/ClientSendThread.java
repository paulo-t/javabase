package com.paulo.javabase.module4.task5.client;

import com.paulo.javabase.module4.task5.server.MessageEntity;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendThread extends Thread {
    /**
     * 连接
     */
    private Socket socket;

    public ClientSendThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectOutputStream oos = null;
        Scanner sc = null;

        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            sc = new Scanner(System.in);

            while (true) {
                System.out.println("请输入你要发送的消息或者文件路径");

                String str = sc.next();

                MessageEntity messageEntity = extractMsg(str);

                if(null == messageEntity){
                    continue;
                }

                oos.writeObject(messageEntity);

                if("bye".equalsIgnoreCase(str)){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(null != socket){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != sc) {
                sc.close();
            }
        }
    }

    /**
     * 解析消息
     */
    private MessageEntity extractMsg(String str) {
        try {
            if (null == str || "".equalsIgnoreCase(str)) {
                return null;
            }

            MessageEntity messageEntity = new MessageEntity();

            //是否是文件
            File file = new File(str);

            if (file.exists()) { //是文件
                //文件类型
                messageEntity.setType(getFileType(str));
                messageEntity.setFileName(file.getName());
                //读取文件数据流
                BufferedInputStream fileBis = new BufferedInputStream(new FileInputStream(str));

                byte[] buffer = new byte[1024];
                int len;
                if (-1 != (len = fileBis.read(buffer))) {
                    byte[] temp = new byte[len];
                    System.arraycopy(buffer, 0, temp, 0, len);
                    messageEntity.appendMessage(temp);
                }
            } else { //文本消息
                messageEntity.setType(0);
                messageEntity.appendMessage(str.getBytes());
            }

            return messageEntity;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *获取文件类型
     */
    private int getFileType(String str){
        if(str.matches("w+.txt")){
            return 2;
        }else if(str.matches("w+.jpg")){
            return 1;
        }else {
            return 3;
        }
    }
}

