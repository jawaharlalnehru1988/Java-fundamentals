package org.example.OOP.Abstractions;

 interface Driveable {
    void startEngine();
}

abstract class Vehicle implements Driveable{
     private String brand;

     public Vehicle(String brand){
         this.brand = brand;
     }

     abstract int fuelCapacity();

     public void displayBrand(){
         System.out.println("Brand: " + brand);
     }
}

class Car2 extends  Vehicle{
     private int fuelCapacity;

     public Car2(String brand, int fuelCapacity){
         super(brand);
         this.fuelCapacity = fuelCapacity;
     }

     @Override
    public void startEngine(){
         System.out.println("Car engine started");
     }

     @Override
    int fuelCapacity(){
         return fuelCapacity;
     }
}

class Bike extends Vehicle{
     private int fuelCapacity;

     public Bike(String brand, int fuelCapacity){
         super(brand);
         this.fuelCapacity = fuelCapacity;
     }

     @Override
    public void startEngine(){
         System.out.println("Bike engine started");
     }

     @Override
    int fuelCapacity(){
         return  fuelCapacity;
     }
}

class TestVehicles {
    public static void main(String[] args) {
        Driveable car = new Car2("Maruthi", 50);
        Driveable bike = new Bike("TVS", 15);

        Vehicle vehicle1 = (Vehicle) car;
        Vehicle vehicle2 = (Vehicle) bike;

        vehicle1.displayBrand();
        car.startEngine();
        System.out.println("Fuel Capacity: " + vehicle1.fuelCapacity());
        vehicle2.displayBrand();
        bike.startEngine();
        System.out.println("Fuel Capacity: " + vehicle2.fuelCapacity());
    }
}