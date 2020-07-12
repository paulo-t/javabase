package com.paulo.javabase.module1;

/**
 * 找出 1000 以内的所有完数并打印出来
 */

public class PerfectNum {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            if (isPerfectNum(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 获取一个数的因子
     */
    private static boolean isPerfectNum(int num) {
        if(1 == num){
            return false;
        }

        int sum = 1;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (0 == num % i) {
                sum += i + num / i;
            }
        }

        return num == sum;
    }
}
