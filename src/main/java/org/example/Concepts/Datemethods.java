package org.example.Concepts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Datemethods {
    public static void main(String[] args) {
         // Write a Java program to get the current date time information using date time API.

//        LocalDate date = LocalDate.now();
//        System.out.println("Current date: " + date);
//
//        // format the local date using date time formatter
//
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        System.out.println(date.format(formatedDate));

        //create a specific date
        LocalDate lDate = LocalDate.of(1988, 11, 14);
        // Formatting the date
        System.out.println(lDate.format(formatedDate));
        // getDay of month

        System.out.println(lDate.getDayOfMonth());
//        System.out.println(lDate.atStartOfDay());

        System.out.println(lDate.getYear());

        // compare to
        LocalDate mDate = LocalDate.of(2000, 11, 22);
        System.out.println(lDate.compareTo(mDate));
        System.out.println(mDate.minusDays(2));


        // Write a Java program to get the current time in a specified format.

//        LocalTime time = LocalTime.now();
//        System.out.println("Current time: " + time);
//
//        // local date and time
//        LocalDateTime dateTime = LocalDateTime.now();
//        System.out.println("Current date and time: " + dateTime);
//
//        // Date and time in a specified format
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = dateTime.format(formatter);
//        System.out.println("Formatted date and time: " + formattedDateTime);
//
//        // Month
//
//        Month month = dateTime.getMonth();
//        System.out.println("Month: " + month);
//
//        // Day of the week
//        int day = dateTime.getDayOfMonth();
//        System.out.println("Day of the month: " + day);
//
//        int seconds = dateTime.getSecond();
//        System.out.println("Seconds: " + seconds);
//
//        // get years
//        int year = dateTime.getYear();
//        System.out.println("Year: " + year);


        Calendar calendar = Calendar.getInstance();

        System.out.println("Current Date: " + calendar.getTime());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("year: " + year);
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);

        calendar.set(2000, Calendar.JANUARY, 1);
        System.out.println("Custom Date: " + calendar.getTime());

        calendar.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println("Date after 10 days: " + calendar.getTime());
    }
}
