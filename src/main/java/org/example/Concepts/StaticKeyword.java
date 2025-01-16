package org.example.Concepts;

public class StaticKeyword {
    static int count = 0;

    static int age;

    static {
        age = 20;
    }

    StaticKeyword(){
        count++;
    }

    void displayCount(){
        System.out.println("Count: " + count);
    }

    static void printMessage(){
        System.out.println("this is static keyword");
    }
}


 class ExecutingClass{
    public static void main(String[] args) {
        StaticKeyword staticKeyword = new StaticKeyword();
        StaticKeyword staticKeyword1 = new StaticKeyword();
        staticKeyword.displayCount();

        StaticKeyword.printMessage();
        System.out.println(StaticKeyword.age);

        Outer.StaticNested insta = new Outer.StaticNested();

        insta.display();
    }
}

class Outer{
    static class StaticNested{
        void display(){
            System.out.println("Static nested class called");
        }
    }
}