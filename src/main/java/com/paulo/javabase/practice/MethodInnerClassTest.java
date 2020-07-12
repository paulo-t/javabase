package com.paulo.javabase.practice;

public class MethodInnerClassTest {
    private int property1 = 1;

    public static void main(String[] args) {
        MethodInnerClassTest mc = new MethodInnerClassTest();
        mc.test();
    }

    public void test() {
        final int field2 = 3;

        //方法内部类
        class MethodInnerClass {
            private int field1 = 2;

            public void show() {

                property1 += 1;
                System.out.println("外部类的property1: " + property1);

                field1 += 1;
                System.out.println("内部类的field1: "+ field1);

                //field2+=1;  访问方法中的变量必须由final修饰
                System.out.println("内部类的field2: "+ field2);
            }
        }

        MethodInnerClass mic = new MethodInnerClass();
        mic.show();
    }
}
