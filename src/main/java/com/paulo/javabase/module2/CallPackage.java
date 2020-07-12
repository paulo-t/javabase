package com.paulo.javabase.module2;

/**
 * 通话套餐
 */
public class CallPackage extends AbstractBasePackage implements CallService {
    /**
     * 通话时长s
     */
    private long time;

    /**
     * 短信条数
     */
    private int shortMsgCount;


    public CallPackage(){}

    public CallPackage(long time, int shortMsgCount, double billPerMonth) {
        this.time = time;
        this.shortMsgCount = shortMsgCount;
        this.billPerMonth = billPerMonth;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getShortMsgCount() {
        return shortMsgCount;
    }

    public void setShortMsgCount(int shortMsgCount) {
        this.shortMsgCount = shortMsgCount;
    }

    public double getBillPerMonth() {
        return billPerMonth;
    }

    public void setBillPerMonth(double billPerMonth) {
        this.billPerMonth = billPerMonth;
    }

    @Override
    public void show(){
        System.out.println("当前套餐详情,通话时长:" + time + " 短信条数:" + shortMsgCount + " 每月资费:" + billPerMonth);
    }

    @Override
    public void call(int count, PhoneCard phoneCard) {
        System.out.println(phoneCard.getUserName() + "您好，您的手机号码" + phoneCard.getCardNum() + "剩余通话时长为" + count + "分钟");
    }
}
