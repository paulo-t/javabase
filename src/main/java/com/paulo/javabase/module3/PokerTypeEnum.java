package com.paulo.javabase.module3;

public enum PokerTypeEnum {
    RED(0,"红桃"),
    BLACK(1,"黑桃"),
    MH(2,"梅花"),
    FP(3,"方片");

    /**
     * 花色
     */
    private int type;
    /**
     * 描述
     */
    private String desc;

    PokerTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
