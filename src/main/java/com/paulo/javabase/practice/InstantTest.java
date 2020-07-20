package com.paulo.javabase.practice;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {
    public static void main(String[] args) {
        //获取的不是当前时区的时间
        Instant now = Instant.now();
        System.out.println("标准时区:" + now);
        //转换到东八时区
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("东八时区:" + offsetDateTime);

        System.out.println(offsetDateTime.toEpochSecond() * 1000);
        System.out.println(now.toEpochMilli());


        Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instant);


    }
}
