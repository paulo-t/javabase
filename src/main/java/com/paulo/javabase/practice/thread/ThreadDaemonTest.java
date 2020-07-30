package com.paulo.javabase.practice.thread;

public class ThreadDaemonTest extends Thread {
    @Override
    public void run() {
        System.out.println(isDaemon() ? "是守护线程":"不是守护线程");

        for(int i = 0;i<50;i++){
            System.out.println("子线程：" + i);
        }
    }

    public static void main(String[] args) {
        ThreadDaemonTest threadDaemonTest = new ThreadDaemonTest();
        threadDaemonTest.setDaemon(true);
        threadDaemonTest.start();

        for(int i = 0;i<20;i++){
            System.out.println("主线程：" + i);
        }
    }
}
