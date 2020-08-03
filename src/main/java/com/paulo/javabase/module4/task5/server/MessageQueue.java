package com.paulo.javabase.module4.task5.server;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: 消息队列用来记录用户发送的消息
 * @date:2020/7/31
 */
public class MessageQueue {
    private Queue<MessageEntity> messageQueue = new LinkedList<>();

    private final Object lock = new Object();


    /**
     * 添加消息
     */
    public void addMessage(MessageEntity msg) {
        synchronized (lock) {
            lock.notify();
            messageQueue.add(msg);
        }
    }

    /**
     * 获取消息
     */
    public MessageEntity getMessage() {
        while(true){
            synchronized (lock) {
                MessageEntity message = messageQueue.poll();
                if(null == message){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    return message;
                }
            }
        }
    }
}
