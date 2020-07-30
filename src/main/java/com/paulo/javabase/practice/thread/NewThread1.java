package com.paulo.javabase.practice.thread;

public class NewThread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("id: " + getId() + ", name: " + getName());

                setName("zhangfei");

                System.out.println("id: " + getId() + ", name: " + getName());
            }
        };

        t1.start();


        System.out.println("id: " + Thread.currentThread().getId()+ ", name: " + Thread.currentThread().getName());


    }
}
