package com.paulo.javabase.practice;

import java.util.Arrays;

public class AnonymousInterfaceImpl implements AnonymousInterface {
    public void show() {
        System.out.println("我是实现类");
    }

    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(Character.BYTES);
        System.out.println(Character.SIZE);
        new AnonymousInterfaceImpl().show();
    }
}
