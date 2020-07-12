package com.paulo.javabase.practice;

public class StaticInnerClassTest {

    private int property1 = 1;

    private static int property2 = 2;

    private static int property3 = 3;

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.show();
        staticInnerClass.show(6);
    }


    /**
     * 静态内部类
     */
    public static class StaticInnerClass {

        private int field1 = 4;


        private static int property3 = 5;

        public StaticInnerClass() {
            System.out.println("静态内部类的构造方法");
        }

        public void show() {
            System.out.println("外部类中property2属性的值为: " + property2);

            System.out.println("当前类的field1属性的值为: " + field1);
        }

        public void show(int property3) {

            System.out.println("当前方法中的property3: " + property3);

            System.out.println("内部类中property3属性的值为: " + StaticInnerClass.property3);

            System.out.println("外部类中property3属性的值为: " + StaticInnerClassTest.property3);
        }

    }
}
