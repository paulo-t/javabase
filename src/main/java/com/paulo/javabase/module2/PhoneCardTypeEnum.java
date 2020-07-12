package com.paulo.javabase.module2;

/**
 *手机卡类型枚举
 */
public enum PhoneCardTypeEnum {
    LARGE(1,"大卡"),
    LITTLE(2,"小卡"),
    MICRO(2,"微型卡")
    ;
    /**
     * 类型
     */
    private int type;
    /**
     * 类型描述
     */
    private String desc;

    PhoneCardTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
