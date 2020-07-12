package com.paulo.javabase.module1;

/**
 * 五子棋游戏棋盘的绘制
 */
public class Gobang {
    private static final int COLUMN_NUM = 16;
    private static final int ROW_NUM = 16;

    public static void main(String[] args) {
        char[][] arr = new char[COLUMN_NUM][ROW_NUM];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = '+';
            }
        }

        System.out.print("  ");
        for (int i = 0; i < COLUMN_NUM; i++) {
            System.out.print(Integer.toHexString(i) + " ");
        }

        System.out.println("");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(Integer.toHexString(i) + " ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

    }
}
