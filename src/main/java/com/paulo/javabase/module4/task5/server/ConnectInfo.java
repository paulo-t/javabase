package com.paulo.javabase.module4.task5.server;

import java.net.Socket;


/**
 * 连接信息
 */
public class ConnectInfo {
    /**
     * 连接id
     */
    private int id;

    /**连接名称
     *
     */
    private String name;

    /**
     * socket
     */
    private Socket socket;

    public ConnectInfo() {
    }

    public ConnectInfo(int id, String name, Socket socket) {
        this.id = id;
        this.name = name;
        this.socket = socket;
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

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
