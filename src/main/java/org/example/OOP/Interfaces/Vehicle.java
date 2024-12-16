package org.example.OOP.Interfaces;

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

class TestCar{
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.fuelUp();
        Vehicle.service();
        car.start();
    }
}
