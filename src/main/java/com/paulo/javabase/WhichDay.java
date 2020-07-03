package com.paulo.javabase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 用户输入年月日信息，判断这一天是这一年中的第几天并打印
 */
public class WhichDay {
    private static int[] runMonth = {1, 3, 5, 7, 8, 10, 12};
    private static int[] normalMonth = {4, 6, 9, 11};
    private static final int runDays = 31;
    private static final int normalDays = 30;
    private static final int runTwoDays = 29;
    private static final int notRunTwoDays = 28;

    public static void main(String[] args) {
        System.out.println("请输入年、月、日");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();


        int totalDay = totalDay(year);

        //存放一年中所有的天
        String[] arr = new String[totalDay];

        int count = 0;

        for (int i = 1; i <= 12; i++) {
            if (isRun(i)) {
                for (int j = 1; j <= runDays; j++) {
                    arr[count++] = i + "" + j;
                }
            } else if (isNormal(i)) {
                for (int j = 1; j <= normalDays; j++) {
                    arr[count++] = i + "" + j;
                }
            } else {
                if (0 == (totalDay & 1)) {
                    for (int j = 1; j <= runTwoDays; j++) {
                        arr[count++] = i + "" + j;
                    }
                } else {
                    for (int j = 1; j <= notRunTwoDays; j++) {
                        arr[count++] = i + "" + j;
                    }
                }
            }
        }

        String searchStr = month + "" + day;

        for(int i= 0;i<arr.length;i++){
            if(arr[i].equals(searchStr)){
                System.out.println("输入的年月日是当年的第" + (i + 1) + "天");
                return;
            }
        }

        System.out.println("输入的年月日有误");
    }

    /**
     * 是否是闰月
     */
    private static boolean isRun(int month) {
        return Arrays.binarySearch(runMonth, month) >= 0;
    }

    /**
     * 是否是闰月
     */
    private static boolean isNormal(int month) {
        return Arrays.binarySearch(normalMonth, month) >= 0;
    }

    /**
     * 一年总的天数
     */
    private static int totalDay(int year) {
        return year % 4 == 0 ? 366 : 365;
    }
}
