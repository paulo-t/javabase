package com.paulo.javabase.module2;

/**
 * 手机卡
 */
public class PhoneCard {
    /**
     *
     * 卡类型
     */
    private PhoneCardTypeEnum type;

    /**
     * 卡号
     */
    private String cardNum;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 余额
     */
    private double remainNum;

    /**
     * 上网流量
     */
    private double netFlow;

    public PhoneCard() {

    }

    public PhoneCard(PhoneCardTypeEnum type, String cardNum, String userName, String password, double remainNum, double netFlow) {
        this.type = type;
        this.cardNum = cardNum;
        this.userName = userName;
        this.password = password;
        this.remainNum = remainNum;
        this.netFlow = netFlow;
    }

    public PhoneCardTypeEnum getType() {
        return type;
    }

    public void setType(PhoneCardTypeEnum type) {
        this.type = type;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(double remainNum) {
        this.remainNum = remainNum;
    }

    public double getNetFlow() {
        return netFlow;
    }

    public void setNetFlow(double netFlow) {
        this.netFlow = netFlow;
    }

    private void show(){
        System.out.println(cardNum + " " + userName + " " + remainNum);
    }
}
