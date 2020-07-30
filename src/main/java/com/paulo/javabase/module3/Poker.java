package com.paulo.javabase.module3;

import java.util.ArrayList;
import java.util.Collections;
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
    private static final String[] pokerNums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k","A","2"};
    /**
     * 初始的牌库
     */
    private List<Card> pokerPool = new ArrayList<>();


    /**
     * 初始化牌库
     */ {
        for (PokerTypeEnum value : PokerTypeEnum.values()) {
            for (int i = 0; i < pokerNums.length; i++) {
                pokerPool.add(new Card(pokerNums[i],value.getDesc(),pokerNums.length - i + 2));
            }
        }


        pokerPool.add(new Card("小王","",2));
        pokerPool.add(new Card("大王","",1));
    }

    private List<Card> getPokerPool() {
        return pokerPool;
    }


    public static void main(String[] args) {
        Poker poker = new Poker();
        //洗牌
        List<Card> shuffle = shuffle(poker);
        //摸排
        List<Card> playerOne = new ArrayList<>();
        List<Card> playerTwo = new ArrayList<>();
        List<Card> playerThree = new ArrayList<>();
        List<Card> background = new ArrayList<>();

        send(shuffle, playerOne, playerTwo, playerThree, background);

        sort(playerOne);
        sort(playerTwo);
        sort(playerThree);
        sort(background);

        System.out.print("玩家一的手牌: ");
        print(playerOne);
        System.out.println("");

        System.out.print("玩家二的手牌: ");
        print(playerTwo);
        System.out.println("");


        System.out.print("玩家三的手牌: ");
        print(playerThree);
        System.out.println("");

        System.out.print("底牌: " );
        print(background);
    }

    private static void print(List<Card> cards){
        for (int i = 0; i < cards.size(); i++) {
            if(i == cards.size() - 1){
                System.out.print(cards.get(i).getNum());
            }else {
                System.out.print(cards.get(i).getNum() + ",");
            }
        }
    }
    /**
     * 洗牌
     */
    public static List<Card> shuffle(Poker poker) {
        List<Card> pokerPool = new ArrayList<>();
        pokerPool.addAll(poker.getPokerPool());
        Collections.shuffle(pokerPool);

        return pokerPool;
    }

    /**
     * 摸排
     */
    public static void send(List<Card> pool, List<Card> playerOne, List<Card> playerTwo, List<Card> playerThree, List<Card> background) {
        for (int i = 0; i < pool.size() - 3; i++) {
            if (i % 3 == 0) {
                playerOne.add(pool.get(i));
            } else if (i % 3 == 1) {
                playerTwo.add(pool.get(i));
            } else {
                playerThree.add(pool.get(i));
            }
        }

        background.addAll(pool.subList(pool.size() - 3, pool.size()));
    }

    /**
     * 排序
     */
    private static void sort(List<Card> pokers) {
        pokers.sort((o1, o2) -> o1.getPriority() - o2.getPriority());
    }

    /**
     * 扑克牌类
     */
    private static class Card{
        /**
         * 数字
         */
        private String num;
        /**
         * 花色
         */
        private String type;
        /**
         * 优先级
         */
        private int priority;

        public Card() {
        }

        public Card(String num, String type, int priority) {
            this.num = num;
            this.type = type;
            this.priority = priority;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "num='" + num + '\'' +
                    ", type='" + type + '\'' +
                    ", priority='" + priority + '\'' +
                    '}';
        }
    }
}
