package com.paulo.javabase.module4.task5.server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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



    public UserReceiveThread(ConnectInfo connectInfo, MessageQueue messageQueue) {
        this.connectInfo = connectInfo;
        this.messageQueue = messageQueue;
    }


    @Override
    public void run() {
        System.out.println(connectInfo.getName() + "接收线程启动完毕");

        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(connectInfo.getSocket().getInputStream());

            while (true) {
                Object obj = ois.readObject();
                System.out.println("接收到来自" + connectInfo.getId() + "的消息: " + obj);

                if (null != obj) {
                    MessageEntity messageEntity = (MessageEntity) obj;
                    messageEntity.setId(connectInfo.getId());
                    messageEntity.setName(connectInfo.getName());
                    messageQueue.addMessage(messageEntity);

                    if (null != messageEntity.getMessage() && 0 == messageEntity.getType() && "bye".equalsIgnoreCase(new String(messageEntity.getMessage()))) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != ois) {
                try {
                    ois.close();
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
