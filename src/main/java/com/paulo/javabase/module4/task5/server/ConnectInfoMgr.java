package com.paulo.javabase.module4.task5.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 连接信息管理类
 */
public class ConnectInfoMgr {

    //保存所有的连接信息
    private static Map<Integer,ConnectInfo> connectInfoMap = new ConcurrentHashMap<>();

    /**
     * 获取单个连接信息
     */
    public static ConnectInfo getConnectInfo(int id){
        return connectInfoMap.get(id);
    }

    /**
     * 添加连接信息
     */
    public static ConnectInfo addConnectInfo(ConnectInfo connectInfo){
        return connectInfoMap.put(connectInfo.getId(),connectInfo);
    }

    /**
     * 获取所有的连接信息
     */
    public static List<ConnectInfo> allConnectInfo(){
        return (null == connectInfoMap || 0 == connectInfoMap.size()) ? new ArrayList<>() : new ArrayList<>(connectInfoMap.values());
    }


    /**
     * 移除指定的连接信息
     */
    public static ConnectInfo removeConnectInfo(int id){
        return connectInfoMap.remove(id);
    }


}
