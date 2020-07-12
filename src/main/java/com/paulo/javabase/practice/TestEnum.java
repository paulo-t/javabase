package com.paulo.javabase.practice;

@MyAnnotation(name = "1")
@MyAnnotation(name = "2")
public enum TestEnum {
    A("aa"),
    B("bb");

    private String desc;

    TestEnum(String desc){
        this.desc = desc;
    }

    public static void main(String[] args) {
        System.out.println(TestEnum.A.compareTo(TestEnum.B));
    }
}
