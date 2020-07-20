package com.paulo.javabase.practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2008,8 - 1,8,20,8,8);

        Date time = calendar.getTime();
        System.out.println(DATE_FORMAT.format(time));

        calendar.set(Calendar.YEAR,2020);
        Date time2 = calendar.getTime();
        System.out.println(DATE_FORMAT.format(time2));

        calendar.add(Calendar.MONTH,1);
        Date time3 = calendar.getTime();
        System.out.println(DATE_FORMAT.format(time3));
    }
}
