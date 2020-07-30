package com.paulo.javabase.practice.reflect;

public class ReflectTest {
    public static void main(String[] args) {
        Class<Integer> integerClass = Integer.class;

        Class<String> stringClass = String.class;

        System.out.println(stringClass);

        String s = new String("1234");
        Class<? extends String> sClass = s.getClass();

        System.out.println(stringClass == sClass);

    }
}
