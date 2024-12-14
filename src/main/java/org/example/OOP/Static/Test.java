package org.example.OOP.Static;

public class Test {
    static {
        System.out.println("Static block: Executes once when class is loaded");
    }

    {
        System.out.println("Non-static block: Executes every time an object is created.");
    }
}
