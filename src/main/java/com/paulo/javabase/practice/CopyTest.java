package com.paulo.javabase.practice;

import java.util.Arrays;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.javabase.practice
 * @date:2020/8/5
 */
public class CopyTest {
    public static void main(String[] args) {
        byte[]  message = {'c'};
        byte[] msg = {'a','b'};


        int oldLen = message.length;

        byte[] newBytes = Arrays.copyOf(message, message.length + msg.length);


        System.arraycopy(msg, 0, newBytes, oldLen, msg.length);

        System.out.println(Arrays.toString(newBytes));
    }
}
