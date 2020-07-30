package com.paulo.javabase.practice.thread;

public class RunnableIdNameTest implements Runnable {
    @Override
    public void run() {
       for(int i =10;i>0;i--){
           System.out.println(i);
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

        System.out.println("新年快乐 !");

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableIdNameTest(), "关羽");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("终于等到你，还好没放弃");
    }
}
