package org.example.OOP.Static;

public class Counter {
    static int staticCounter = 0;
    int instanceCounter = 0;

    Counter(){
        staticCounter++;
        instanceCounter++;
    }

   void displayCounters(){
       System.out.println("Static Counter: " + staticCounter);
       System.out.println("Instance Counter: " + instanceCounter);
   }
}

