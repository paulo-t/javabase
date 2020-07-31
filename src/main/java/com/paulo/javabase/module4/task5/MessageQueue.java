package com.paulo.javabase.module4.task5;

import java.util.List;
import java.util.Map;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: 消息队列用来记录用户发送的消息
 * @date:2020/7/31
 */
public class MessageQueue {
    /**
     * 记录消息
     */
    List<byte[]> messages;

    /**
     * 每个用户的读取的位置
     */
    private Map<String,Integer> consumers;


}
