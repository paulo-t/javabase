package com.paulo.javabase.practice;

public class AnonymousInterfaceTest {
    public static void main(String[] args) {
        AnonymousInterfaceTest ait = new AnonymousInterfaceTest();
        //匿名类的定义
        ait.test(new AnonymousInterface(){
            public void show() {
                System.out.println("我也是实现类");
            }
        });
    }

    public void test(AnonymousInterface anonymousInterface){
        anonymousInterface.show();
    }
}
