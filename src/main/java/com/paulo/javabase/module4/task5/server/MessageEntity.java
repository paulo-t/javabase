package com.paulo.javabase.module4.task5.server;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 消息实体类
 */
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 8255585634119566124L;

    private static final byte[] DEFAULT_MSG = {};
    /**
     * 连接id
     */
    private int id;

    /**
     * 连接名称
     */
    private String name;

    /**
     * 消息类型 0:字符串 1:图片(jpg) 2:文本文件(txt) 3:其它
     */
    private int type;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 消息
     */
    private byte[] message;

    public MessageEntity() {
        message = DEFAULT_MSG;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", fileName='" + fileName + '\'' +
                ", message=" + Arrays.toString(message) +
                '}';
    }

    /**
     * 添加消息
     */
    public int appendMessage(byte[] msg) {
        int oldLen = message.length;

        byte[] bytes = Arrays.copyOf(message, message.length + msg.length);

        System.arraycopy(msg, 0, bytes, oldLen, msg.length);

        this.message = bytes;

        return message.length;
    }
}
