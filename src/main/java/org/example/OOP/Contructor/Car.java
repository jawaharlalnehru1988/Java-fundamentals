package org.example.OOP.Contructor;

public class Car {
    String brand;
    String model;
    int year;

    Car(){
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }

    Car(String brand, String model, int year){
        this.brand = brand;
        this.model = brand;
        this.year = year;
    }

    void displayDetails(){
        System.out.println("Brand: " + this.brand + ", Model: " + this.model + ", Year: "+ this.year);
    }

    public static void main(String[] args) {
        Car car = new Car();
       car.displayDetails();

       Car car1 = new Car("Maruthi", "i80", 2018);
       car1.displayDetails();
    }
}
