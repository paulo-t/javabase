package com.paulo.javabase.practice;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3};
        int[] ints = Arrays.copyOf(arr, 10);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
