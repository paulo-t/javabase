package com.paulo.javabase.module3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *使用集合实现斗地主游戏的部分功能，要求如下：
 *
 *  （1）首先准备 54 张扑克牌并打乱顺序。
 *
 *  （2）由三个玩家交替摸牌，每人 17 张扑克牌，最后三张留作底牌。
 *
 *  （3）查看三个玩家手中的扑克牌和底牌。
 *
 *  （4）其中玩家手中的扑克牌需要按照大小顺序打印，规则如下：
 *
 *     手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
 */
public class Poker {
    /**
     * 左右的扑克牌数字
     */
    private static final String[] pokerNums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k"};
    /**
     * 初始的牌库
     */
    private List<String> pokerPool = new ArrayList<>();


    /**
     * 初始化牌库
     */ {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < pokerNums.length; j++) {
                pokerPool.add(pokerNums[j]);
            }
        }

        pokerPool.add("小王");
        pokerPool.add("大王");
    }

    private List<String> getPokerPool() {
        return pokerPool;
    }


    public static void main(String[] args) {
        Poker poker = new Poker();
        //洗牌
        List<String> shuffle = shuffle(poker);
        //摸排
        List<String> playerOne = new ArrayList<>();
        List<String> playerTwo = new ArrayList<>();
        List<String> playerThree = new ArrayList<>();
        List<String> background = new ArrayList<>();

        send(shuffle, playerOne, playerTwo, playerThree, background);

        sort(playerOne);
        sort(playerTwo);
        sort(playerThree);
        sort(background);

        System.out.println("玩家一的手牌: " + playerOne);
        System.out.println("玩家二的手牌: " + playerTwo);
        System.out.println("玩家三的手牌: " + playerThree);
        System.out.println("底牌: " + background);
    }


    /**
     * 洗牌
     */
    public static List<String> shuffle(Poker poker) {
        List<String> pokerPool = new ArrayList<>();
        pokerPool.addAll(poker.getPokerPool());
        Collections.shuffle(pokerPool);

        return pokerPool;
    }

    /**
     * 摸排
     */
    public static void send(List<String> pool, List<String> playerOne, List<String> playerTwo, List<String> playerThree, List<String> background) {
        for (int i = 0; i < pool.size() - 3; i++) {
            if (i % 3 == 0) {
                playerOne.add(pool.get(i));
            } else if (i % 3 == 1) {
                playerTwo.add(pool.get(i));
            } else {
                playerThree.add(pool.get(i));
            }
        }

        background.addAll(pool.subList(pool.size() - 4, pool.size() - 1));
    }

    /**
     * 排序
     */
    private static void sort(List<String> pokers) {
        pokers.sort((o1, o2) -> o1.length() - o2.length() == 0 ? o1.compareTo(o2) : o1.length() - o2.length());
    }
}
