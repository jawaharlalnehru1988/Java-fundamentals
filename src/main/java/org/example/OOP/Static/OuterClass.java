package org.example.OOP.Static;

public class OuterClass {
    static class StaticNestedClass{
        void display(){
            System.out.println("Inside static nested class");
        }
    }
    class InnerClass{
        void display(){
            System.out.println("Inside non-static nested class.");
        }
    }
}
