package org.example.OOP.Contructor;

public class Circle {
    double radius;

    Circle(){
        this.radius = 1.0;
    }

    Circle(double radius){
        this.radius = radius;
    }

    double calculateArea(){
    return Math.PI * radius * radius;
    }

    double calculateCircumference(){
        return 2 * Math.PI * radius;
    }

    public void displayDetails(){
        System.out.printf("Radius: %.1f, Area: %.2f, circumference: %.2f%n", radius, calculateArea(), calculateCircumference());
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.displayDetails();
        Circle circle1 = new Circle(2.0);
        circle1.displayDetails();
    }
}
