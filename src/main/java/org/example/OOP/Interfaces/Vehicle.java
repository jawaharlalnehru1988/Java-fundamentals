package org.example.OOP.Interfaces;

import java.util.Arrays;

public interface Vehicle {
    void start();

    default void fuelUp() {
        System.out.println("Filling fuel...");
    }

    static void service(){
        System.out.println("Vehicle is being serviced");
    }

}

class Car implements Vehicle{
    @Override
    public void start(){
        System.out.println("Vehicle has started..");


    }
}

class Bus implements Vehicle{
    private int value = 5;

    @Override
    public void start(){
        this.value = value*8;
        System.out.println("this starts with heavy speed: " + this.value);
    }

    public void fillFullStatus(){
        int[] counts = {2, 4, 6, 7, 8};
         int total =  Arrays.stream(counts).sum();
        System.out.println("this fuel should be filled: " + total);
    }
}

class TestCar{
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.fuelUp();
        Vehicle.service();
        car.start();

        Bus bus = new Bus();
        bus.start();
        bus.fillFullStatus();
    }
}
