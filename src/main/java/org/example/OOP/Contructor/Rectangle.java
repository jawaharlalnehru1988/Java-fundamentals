package org.example.OOP.Contructor;

public class Rectangle {
    double length;
    double width;

    Rectangle(){
        this.length = 1.0;
        this.width = 1.0;
    }

    Rectangle(double length){
        this.length = length;
        this.width = 1.0;
    }

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    double calculateArea(){
        return this.length * this.width;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.calculateArea());
        Rectangle rectangle1 = new Rectangle(5.1);
        System.out.println(rectangle1.calculateArea());
        Rectangle rectangle2 = new Rectangle(3.0, 5.0);
        System.out.println(rectangle2.calculateArea());
    }
}
