package com.paulo.javabase.module4.task5.client;

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

    private static final int FILE_MAX_SIZE = 1024 * 1024;

    @Override
    public void run() {
        BufferedOutputStream bof = null;
        Scanner sc = null;

        try {
            bof = new BufferedOutputStream(socket.getOutputStream());
            sc = new Scanner(System.in);

            while (true) {
                System.out.println("请输入你要发送的消息或者文件路径");

                String str = sc.next();

                byte[] msg = extractMsg(str);

                if(null == msg){
                    continue;
                }

                bof.write(msg,0,msg.length);
                bof.flush();

                if("bye".equalsIgnoreCase(str)){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bof) {
                try {
                    bof.close();
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
    private byte[] extractMsg(String str) {
        try {
            if (null == str || "".equalsIgnoreCase(str)) {
                return null;
            }

            //消息
            byte[] msg = null;

            byte[] buffer = new byte[FILE_MAX_SIZE];

            //是否是文件
            File file = new File(str);
            if (file.exists()) {
                if (file.length() <= 0) {
                    System.out.println("文件为空");
                    return null;
                }

                if (file.length() > FILE_MAX_SIZE) {
                    System.out.println("文件大小超出限制");
                    return null;
                }


                BufferedInputStream fileBis = new BufferedInputStream(new FileInputStream(str));

                int len;
                if (-1 != (len = fileBis.read(buffer))) {
                    byte[] temp = new byte[len];
                    System.arraycopy(buffer, 0, temp, 0, len);
                    msg = temp;
                }
            } else { //文本消息
                msg = str.getBytes();
            }

            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

