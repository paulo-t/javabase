package com.paulo.javabase.module2;

/**
 *用户消费信息
 */
public class ConsumeInfo {
    /**
     * 统计通话时长
     */
    private int callTime;

    /**
     * 上网流量
     */
    private double netFlow;

    /**
     * 每月消费金额
     */
    private double billPerMonth;

    public ConsumeInfo(){

    }

    public ConsumeInfo(int callTime, double netFlow, double billPerMonth) {
        this.callTime = callTime;
        this.netFlow = netFlow;
        this.billPerMonth = billPerMonth;
    }
}
