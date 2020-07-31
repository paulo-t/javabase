package com.paulo.javabase.module4.task5;

import java.net.Socket;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.javabase.module4.task5
 * @date:2020/7/31
 */
public class UserThread extends Thread {

    /**
     * 连接的用户
     */
    private Socket socket;

    /**
     * 消息队列
     */
    private MessageQueue messageQueue;


    @Override
    public void run() {
        super.run();
    }
}
