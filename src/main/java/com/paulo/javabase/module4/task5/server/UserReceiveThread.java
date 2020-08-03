package com.paulo.javabase.module4.task5.server;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: 消息接受线程
 * @date:2020/7/31
 */
public class UserReceiveThread extends Thread {

    /**
     * 连接信息
     */
    private ConnectInfo connectInfo;

    /**
     * 消息队列
     */
    private MessageQueue messageQueue;


    /**
     * 文件最大大小1M
     */
    private static final int FILE_MAX_SIZE = 1024 * 1024;

    public UserReceiveThread(ConnectInfo connectInfo, MessageQueue messageQueue) {
        this.connectInfo = connectInfo;
        this.messageQueue = messageQueue;
    }


    @Override
    public void run() {
        System.out.println(connectInfo.getName()+"接收线程启动完毕");

        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(connectInfo.getSocket().getInputStream());

            while (true) {

                //将文件放入消息队列
                byte[] buffer = new byte[FILE_MAX_SIZE];

                int len;

                //客户端是否断开
                boolean isEnd = false;

                while (-1 != (len = bis.read(buffer))) {

                    byte[] auxArr = new byte[len];
                    System.arraycopy(buffer, 0, auxArr, 0, len);

                    if ("bye".equalsIgnoreCase(new String(auxArr))) {
                        isEnd = true;
                    }

                    MessageEntity messageEntity = new MessageEntity(connectInfo.getId(), connectInfo.getName(), auxArr);
                    System.out.println("接收到来自" + connectInfo.getId() + "的消息: " + new String(auxArr));
                    messageQueue.addMessage(messageEntity);
                }

                if (isEnd) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != connectInfo.getSocket()) {
                try {
                    connectInfo.getSocket().close();
                    //移除连接信息
                    ConnectInfoMgr.removeConnectInfo(connectInfo.getId());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
