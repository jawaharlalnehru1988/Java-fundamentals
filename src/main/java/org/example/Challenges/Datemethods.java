package org.example.Challenges;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Datemethods {
    public static void main(String[] args) {
         // Write a Java program to get the current date time information using date time API.

        LocalDate date = LocalDate.now();
        System.out.println("Current date: " + date);

        // Write a Java program to get the current time in a specified format.

        LocalTime time = LocalTime.now();
        System.out.println("Current time: " + time);

        // local date and time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current date and time: " + dateTime);

        // Date and time in a specified format

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println("Formatted date and time: " + formattedDateTime);

        // Month

        Month month = dateTime.getMonth();
        System.out.println("Month: " + month);

        // Day of the week
        int day = dateTime.getDayOfMonth();
        System.out.println("Day of the month: " + day);

        int seconds = dateTime.getSecond();
        System.out.println("Seconds: " + seconds);

        // get years
        int year = dateTime.getYear();
        System.out.println("Year: " + year);








    }
}
