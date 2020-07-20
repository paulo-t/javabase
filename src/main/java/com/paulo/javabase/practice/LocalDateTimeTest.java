package com.paulo.javabase.practice;

import java.time.LocalDateTime;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime lc = LocalDateTime.of(2020,7,19,22,10,5);
        lc.getYear();
        LocalDateTime localDateTime = lc.withYear(2008);
        System.out.println("lc:"+lc);
        System.out.println("localDateTime:" + localDateTime);

        LocalDateTime localDateTime1 = localDateTime.plusYears(1);
        System.out.println("localDateTime1:" + localDateTime1);

        LocalDateTime localDateTime2 = localDateTime1.minusMonths(1);
        System.out.println("localDateTime2:" + localDateTime2);

    }
}
