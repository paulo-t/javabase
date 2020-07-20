package com.paulo.javabase.module3;

import java.util.Scanner;

/**
 * 编程获取两个指定字符串中的最大相同子串。
 * <p>
 * 如： s1="asdafghjka", s2="aaasdfg" 他们的最大子串为"asd"
 * <p>
 * 提示： 将短的那个串进行长度依次递减的子串与较长的串比较。
 */
public class SubStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个字符串");
        String str1 = sc.next();

        System.out.println("请输入第二个字符串");
        String str2 = sc.next();

        String subStr = str1.length() > str2.length() ? getSubStr(str1, str2) : getSubStr(str2, str1);
        System.out.println("最大子串为: " + subStr);
    }

    /**
     * 获取最大子串
     */
    private static String getSubStr(String str1, String str2) {
        if (str1 == null || str1.equals("") || str2 == null || str2.equals("")) {
            return "";
        }

        if (str1.contains(str2)) {
            return str2;
        }

        for (int i = 1; i < str2.length(); i++) {
            for (int j = 0; j < i + 1; j++) {
                String substring = str2.substring(j, str2.length() - i + j);
                if (str1.contains(substring)) {
                    return substring;
                }
            }
        }

        return "";
    }
}
