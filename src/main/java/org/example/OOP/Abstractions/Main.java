package org.example.OOP.Abstractions;

//Abstract class
abstract class Shape {
    //Abstract method(no implementation)
    abstract double calculateArea();

    //Concrete method (with implementation)
     void displayType(){
        System.out.println("This is a shape.");
    }
}

//Concrete subclass
class Circle extends Shape{
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

    @Override
    double calculateArea(){
        return Math.PI * radius * radius;
    }
}

//Concrete subclass
class Rectangle extends Shape{
    private double length;
    private double width;

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea(){
        return length * width;
    }
}


// Main method
public class Main{
    public static void main(String[] args) {
    Shape circle = new Circle(5);
    circle.displayType();
        System.out.println("The area of circle is : " + circle.calculateArea());


    Shape rectangle = new Rectangle(8, 4);
    rectangle.displayType();
        System.out.println("The area of the rectangle is: " +  rectangle.calculateArea());


    }
}