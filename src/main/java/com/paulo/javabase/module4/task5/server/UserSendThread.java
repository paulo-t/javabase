package com.paulo.javabase.module4.task5.server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class UserSendThread extends Thread {

    /**
     * 消息队列
     */
    private MessageQueue messageQueue;


    public UserSendThread(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }


    @Override
    public void run() {
        System.out.println("服务器群发线程启动");

        MessageEntity messageEntity;

        while (true) {
            if (null != (messageEntity = messageQueue.getMessage())) {
                List<ConnectInfo> connectInfos = ConnectInfoMgr.allConnectInfo();
                for (ConnectInfo connectInfo : connectInfos) {
                    if (messageEntity.getId() != connectInfo.getId()) {
                        //不是发送方
                        System.out.println("开始向" + connectInfo.getId() + "群发消息");
                        new SendThread(connectInfo, messageEntity).start();
                    }
                }
            }
        }
    }


    private static class SendThread extends Thread {
        /**
         * 连接信息
         */
        private ConnectInfo connectInfo;

        /**
         * 消息实体
         */
        private MessageEntity messageEntity;

        public SendThread(ConnectInfo connectInfo, MessageEntity messageEntity) {
            this.connectInfo = connectInfo;
            this.messageEntity = messageEntity;
        }

        @Override
        public void run() {
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(connectInfo.getSocket().getOutputStream());
                oos.writeObject(messageEntity);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                /*if (null != oos) {
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }*/
            }
        }
    }
}
