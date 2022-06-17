package com.ark.datetime;

import java.time.*;

//Java 8 Date time examples
public class DateTimeExamples {
    public static void main(String[] args) {
        /* Local Date */
        LocalDate localDate = LocalDate.of(2022, 6, 17);
        int year = localDate.getYear();
        System.out.println("Year " + year);
        Month month = localDate.getMonth();
        System.out.println("Month " + month);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("Day of Week " + dayOfWeek);
        /* LocalTime */
        LocalTime localTime = LocalTime.of(12, 12, 12);
        System.out.println("LocalTime :" + localTime.getHour() + " " + localTime.getMinute() + " " + localTime.getSecond());
        /* LocalDateTime */
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime.getMonth());
        /* Duration */
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, localDateTime);
        System.out.println(duration);


    }
}
