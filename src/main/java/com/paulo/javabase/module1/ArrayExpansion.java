package com.paulo.javabase.module1;

import java.util.Scanner;

/**
 * 自定义数组扩容规则 当已存储元素数量达到总容量的 80%时，扩容 1.5 倍
 */
public class ArrayExpansion {
    public static void main(String[] args) {
        System.out.println("请输入数组的长度");
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();

        int[] arr = new int[len];

        System.out.println("请向数组中添加整数类型元素，每行一个元素,每次添加一个");
        int counter = 0;
        while (true) {
            int num = sc.nextInt();
            arr[counter++] = num;
            if (counter * 1.0 / arr.length >= 0.8) {
                int[] auxArr = new int[(int) Math.ceil(arr.length * 1.5)];
                System.arraycopy(arr, 0, auxArr, 0, counter);
                arr = auxArr;
                System.out.println("数组扩容至: " + arr.length + " 当前元素个数: " + counter);
                System.out.print("当前元素: ");
                for (int i = 0; i < counter; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println("");
            }
        }


    }
}
