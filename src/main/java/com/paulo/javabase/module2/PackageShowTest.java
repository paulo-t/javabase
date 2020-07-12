package com.paulo.javabase.module2;

public class PackageShowTest {
    public static void main(String[] args) {
        PhoneCard phoneCard = new PhoneCard(PhoneCardTypeEnum.LITTLE,"18061995700","paulo","paulo",100.0,40 * 2014 * 1.0);
        CallService call = new CallPackage();
        call.call(100,phoneCard);

        NetService net = new NetPackage();
        net.call(20 * 1024 * 1.0,phoneCard);
    }
}
