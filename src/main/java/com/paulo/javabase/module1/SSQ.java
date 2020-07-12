package com.paulo.javabase.module1;

import java.util.Arrays;
import java.util.Random;

/**
 *双色球抽奖游戏中奖号码的生成
 * 6 个红球号码和 1 个蓝球号码组成
 */
public class SSQ {
    private static int[] redPool = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};

    private static int[] bluePool = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

    private static final int RED_NUM = 6;

    private static final int BLUE_NUM = 1;


    public static void main(String[] args) {
        int[] redBalls = getBalls(redPool,RED_NUM);
        int[] blueBalls = getBalls(bluePool,BLUE_NUM);

        System.out.println("红球:" + Arrays.toString(redBalls));
        System.out.println("蓝球:" + Arrays.toString(blueBalls));
    }

    /**
     * 获取球
     */
    private static int[] getBalls(int[] initRedBalls,int num){
        int[] balls = new int[num];
        int counter = 0;
        Random random = new Random();

        while(counter < num){
            int randomIndex = random.nextInt(initRedBalls.length);
            int redNumber = initRedBalls[randomIndex];

            if(Arrays.binarySearch(balls,redNumber) < 0){
                balls[counter++] = redNumber;
            }
        }

        return balls;

    }

}
