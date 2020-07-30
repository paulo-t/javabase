package com.paulo.javabase.practice.net;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientStringTest {
    public static void main(String[] args) {
        Socket s = null;
        PrintStream printStream = null;

        Scanner sc = null;
        BufferedReader bf = null;

        try {
            s = new Socket("127.0.0.1",9000);
            System.out.println("服务器连接成功");

            sc = new Scanner(System.in);
            System.out.println("请输入需要发送的内容");
            String next = sc.next();

            printStream = new PrintStream(s.getOutputStream());

            printStream.print(next);

            //接收服务器回发的消息
            bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String s1 = bf.readLine();

            System.out.println("服务器回发的内容是:" + s1);


        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if(null != bf){
                try {
                    bf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != sc){
                sc.close();
            }

            if(printStream != null){
                printStream.close();
            }

            if(s!=null){
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
