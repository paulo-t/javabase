package com.paulo.javabase.module2;

/**
 * 抽象基础套餐类
 */
public abstract class AbstractBasePackage {
    /**
     * 每月资费
     */
    protected double billPerMonth;

    public void show(){
        System.out.println("当前套餐每月资费:"+ billPerMonth);
    }
}
