package com.paulo.javabase.module4.task5.server;

/**
 * 消息实体类
 */
public class MessageEntity {

    /**
     * 连接id
     */
    private int id;

    /**
     * 连接名称
     */
    private String name;

    /**
     * 消息
     */
    private byte[] message;

    public MessageEntity() {
    }

    public MessageEntity(int id, String name, byte[] message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }
}
