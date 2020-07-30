package com.paulo.javabase.practice.thread;

public class AccountTest implements Runnable {
    private int amount;

    public AccountTest(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {

    }

}
