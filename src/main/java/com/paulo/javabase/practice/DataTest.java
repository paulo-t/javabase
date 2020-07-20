package com.paulo.javabase.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTest {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        Date parse = simpleDateFormat.parse("1970-12-21 23:30:00");
        System.out.println(parse);

        Date date2 = new Date(1000);
        System.out.println(date2);


    }
}
