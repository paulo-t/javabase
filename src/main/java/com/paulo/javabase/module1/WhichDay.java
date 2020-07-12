package com.paulo.javabase.module1;

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
        System.out.println("请输入年、月、日,用空格分隔，任意数字为-1退出程序");
        Scanner sc = new Scanner(System.in);
        while(true){
            int year = sc.nextInt();
            if(-1 == year){
                System.out.println("程序退出..");
                return;
            }
            int month = sc.nextInt();
            if(-1 == month){
                System.out.println("程序退出..");
                return;
            }
            int day = sc.nextInt();
            if(-1 == day){
                System.out.println("程序退出..");
                return;
            }
            int days = witchDay(year, month, day);
            if (days <= 0) {
                System.out.println("输入的日期有误");
            } else {
                System.out.println("输入的日期是当年的第" + days + "天");
            }
        }

    }

    private static int witchDay(int year,int month,int day){
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

                return (i + 1);
            }
        }

        return -1;
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
