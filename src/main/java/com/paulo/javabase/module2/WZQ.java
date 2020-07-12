package com.paulo.javabase.module2;

import java.util.Scanner;

/**
 * 五子棋
 * 实现思路和上一道题的计算相同,每一方落子之后计算以当前子为中心的 N * N 二维数组的中间行、中间列、从左上到右下或者从右上到左下的和是否为N或者-N(白起落子将相应的位置置为1，黑棋为-1，必须是连续的和等于N个)
 */
public class WZQ {
    /**
     * 行数
     */
    private static final int COLUMN = 16;
    /**
     * 列数
     */
    private static final int ROW = 16;
    /**
     * 五子棋
     */
    private static final int COUNT = 5;
    /**
     * 白字黑字标识
     */
    private static boolean flag = true;

    /**
     * 棋盘
     */
    private static int[][] arr = new int[COLUMN][ROW];

    /**
     * 下棋
     */
    public static void go() {
        System.out.println("对局开始，白字先行");
        show();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println((flag ? "白棋" : "黑棋") + "选手请输入你落子的位置,两个坐标间用空格分隔");
            int x;
            int y;

            while (true) {
                x = sc.nextInt();
                y = sc.nextInt();
                if (!validXY(x, y)) {
                    System.out.println("坐标无效请重新输入");
                } else {
                    arr[x - 1][y - 1] = flag ? 1 : -1;

                    show();

                    if (isWin(x - 1, y - 1)) {
                        System.out.println("恭喜" + (flag ? "白棋" : "黑棋") + "选手获胜");
                        flag = true;
                        return;
                    } else {
                        flag = !flag;
                        break;
                    }
                }
            }
        }
    }


    /**
     * 选手是否获胜
     */
    private static boolean isWin(int x, int y) {

        int minX = x - COUNT;
        int maxX = x + COUNT;

        int minY = y - COUNT;
        int maxY = y + COUNT;


        int columnSum = 0;
        //记录每列的和
        int rowSum = 0;
        //左上到右下的和
        int leftSum = 0;
        //右上到左下
        int rightSum = 0;


        for (int i = Math.max(minX, 0); i <= Math.min(maxX, COLUMN); i++) {
            for (int j = Math.max(minY, 0); j <= Math.min(maxY, ROW); j++) {

                if (i == x) {
                    columnSum = sum(arr[i][j], columnSum);
                    if (fullCount(columnSum)) {
                        return true;
                    }
                }
                if (j == y) {
                    //当前列的和
                    rowSum = sum(arr[i][j], rowSum);
                    if (fullCount(rowSum)) {
                        return true;
                    }
                }

                //从左上到右下的和
                if ((j - minY) == (i - minX)) {
                    leftSum = sum(arr[i][j], leftSum);
                    if (fullCount(leftSum)) {
                        return true;
                    }
                }

                //从右上到左下的和
                if (j == maxY - i) {
                    rightSum = sum(arr[i][j], rightSum);
                    if (fullCount(rightSum)) {
                        return true;
                    }
                }
            }
        }

        if (COUNT == columnSum || COUNT == rowSum || COUNT == leftSum || COUNT == rightSum) {
            return true;
        } else if (-COUNT == columnSum || -COUNT == rowSum || -COUNT == leftSum || -COUNT == rightSum) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean fullCount(int count){
        if(Math.abs(count) == COUNT){
            return  true;
        }

        return false;
    }
    /**
     * 计算连续的和
     */
    private static int sum(int current, int sum) {
        //当前行的和
        if (flag) {
            if (isWhite(current)) {
                sum += current;
                if (sum == COUNT) {
                    return sum;
                }
            } else {
                //不连续置空
                sum = 0;
            }
        } else {
            if (isBlack(current)) {
                sum += current;
                if (sum == COUNT) {
                    return sum;
                }
            } else {
                //不连续置空
                sum = 0;
            }
        }

        return sum;
    }

    //是否是白棋
    private static boolean isWhite(int value) {
        return value == 1;
    }

    //是否是白棋
    private static boolean isBlack(int value) {
        return value == -1;
    }


    /**
     * 坐标有效？
     */
    private static boolean validXY(int x, int y) {
        return x >= 1 && x <= COLUMN && y >= 1 && y <= ROW && arr[x - 1][y - 1] == 0;
    }


    /**
     * 打印棋盘
     */
    private static void show() {
        System.out.print("  ");
        for (int i = 0; i < COLUMN; i++) {
            System.out.print(Integer.toHexString(i) + " ");
        }

        System.out.println("");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(Integer.toHexString(i) + " ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] == 0 ? "+ " : arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        WZQ.go();
    }
}
