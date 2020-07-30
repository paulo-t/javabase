package com.paulo.javabase.practice.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStringTest {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket s = null;
        BufferedReader br = null;
        PrintStream printStream = null;
        try {
            serverSocket = new ServerSocket(9000);

            System.out.println("等待客户端连接");

            //阻塞等待客户端连接
            s = serverSocket.accept();

            System.out.println("客户端连接成功");

            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //没有数据发来时下面的代码也会阻塞
            String s1 = br.readLine();
            System.out.println("客户端发送的内容为: " + s1);


            //服务器发送
            printStream = new PrintStream(s.getOutputStream());
            printStream.print("I have received !");
            System.out.println("服务端消息发送成功 !");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != printStream){
                printStream.close();
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != s){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(null != serverSocket){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
