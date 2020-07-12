package com.paulo.javabase.module2;

/**
 * 二维数组计算
 */
public class ArrayCalculate {
    private static final int ROW = 16;
    private static final int COLUMN = 16;

    public static void main(String[] args) {
        int[][] arr = new int[COLUMN][ROW];

        int num = 0;

        //初始化值
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ++num;
            }
        }

        //记录每列的和
        int[] rowSumArr = new int[ROW];
        //左上到右下的和
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = 0; j < arr[i].length; j++) {
                //每行的和
                sum += arr[i][j];
                //每列的和
                rowSumArr[j] += arr[i][j];
                //从左上到右下的和
                if (j == i) {
                    leftSum += arr[i][j];
                }
                if (j == ROW - 1 - i) {
                    rightSum += arr[i][j];
                }
            }

            System.out.println("第" + (i + 1) + "行的和为:" + sum);
        }


        for (int i = 0; i < rowSumArr.length; i++) {
            System.out.println("第" + (i + 1) + "列的和为:" + rowSumArr[i]);
        }

        System.out.println("从左上到右下的和为:" + leftSum);
        System.out.println("从右上到左下的和为:" + rightSum);
    }
}
