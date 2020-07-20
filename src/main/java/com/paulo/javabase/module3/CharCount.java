package com.paulo.javabase.module3;

/**
 * 编程统计字符串"ABCD123!@#$%ab"中大写字母、小写字母、数字、其它字符的个数并打 印出来。
 * 解题思路: 将字符串转换成Byte或者Char数组循环判断每个字符的类型
 */
public class CharCount {
    public static void main(String[] args) {
        String str = "ABCD123!@#$%ab";
        str.compareTo("");

        byte[] bytes = str.getBytes();

        int upperCount = 0;
        int lowerCount = 0;
        int numCount = 0;
        int otherCount = 0;
        for (byte aByte : bytes) {
            if (aByte - 'A' >= 0 && aByte - 'A' <= 26) {
                ++upperCount;
            } else if (aByte - 'a' >= 0 && aByte - 'a' <= 26) {
                ++lowerCount;
            } else if (aByte - '0' >= 0 && aByte - '0' <= 9) {
                ++numCount;
            } else {
                ++otherCount;
            }
        }

        System.out.println("大写字符数量: " + upperCount);
        System.out.println("小写字符数量: " + lowerCount);
        System.out.println("数字字符数量: " + numCount);
        System.out.println("其它字符数量: " + otherCount);
    }
}
