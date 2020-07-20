package com.paulo.javabase.module3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *准备一个 HashMap 集合，统计字符串"123,456,789,123,456"中每个数字字符串出现的次数并打印出来。
 * 解题思路: 将字符串按,分隔，遍历每个元素如果 Map中存在这个元素就将它的数量加一，不存在就像Map中添加这个元素并将它的数量设置为一
 */
public class NumCount {
    public static void main(String[] args) {
        Map<String,Integer> map= new HashMap<>();

        String str = "123,456,789,123,456";

        String[] nums = str.split(",");
        for (String num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + "出现了 " + stringIntegerEntry.getValue() + "次");
        }

    }
}
