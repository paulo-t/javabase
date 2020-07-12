package com.paulo.javabase.module2;

/**
 * 上网套餐
 */
public class NetPackage extends AbstractBasePackage implements NetService {
    /**
     * 上网流量
     */
    private double netFlow;

    public NetPackage(){

    }

    public NetPackage(double netFlow, double billPerMonth) {
        this.netFlow = netFlow;
        this.billPerMonth = billPerMonth;
    }

    public double getNetFlow() {
        return netFlow;
    }

    public void setNetFlow(double netFlow) {
        this.netFlow = netFlow;
    }

    public double getBillPerMonth() {
        return billPerMonth;
    }

    public void setBillPerMonth(double billPerMonth) {
        this.billPerMonth = billPerMonth;
    }

    @Override
    public void show(){
        System.out.println("当前套餐详情,上网流量:" + netFlow +"M" + " 每月资费:" + billPerMonth);
    }

    @Override
    public void call(double netFlow, PhoneCard phoneCard) {
        System.out.println(phoneCard.getUserName() + "您好，您的手机号码" + phoneCard.getCardNum() + "剩余流量为" + netFlow + "M");
    }
}
