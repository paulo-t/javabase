package com.paulo.javabase.practice;

public class InnerClassTest {

    private int property1 = 1;

    private int property2 = 2;

    private static int property3 = 3;

    private static int property4 = 4;


    public static void main(String[] args) {
        System.out.println("普通内部类测试");
        //声明一个外部类
        InnerClassTest ic = new InnerClassTest();

        //声明一个普通内部类
        NormalInnerClass nic = ic.new NormalInnerClass();
        nic.show();

        nic.show(4);

        System.out.println("-------------------------------------------------------");

    }

    /**
     * 普通内部类
     */
    public class NormalInnerClass {


        private int field1 = 1;

        private int property2 = 3;

        public NormalInnerClass() {
            System.out.println("普通内部类的构造方法");
        }


        public void show() {
            System.out.println("外部类中property1属性的值为: " + property1);

            System.out.println("当前类的field1属性的值为: " + field1);
        }

        public void show(int property2) {

            System.out.println("当前方法中的property2: " + property2);

            System.out.println("内部类中property2属性的值为: " + this.property2);

            System.out.println("外部类中property2属性的值为: " + InnerClassTest.this.property2);
        }
    }
}
