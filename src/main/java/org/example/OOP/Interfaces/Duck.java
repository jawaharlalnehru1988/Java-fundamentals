package org.example.OOP.Interfaces;

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

public class Duck implements Flyable, Swimmable {
    @Override
    public void fly(){
        System.out.println("Duck flies nicely");
    }

    @Override
    public void swim(){
        System.out.println("Duck swims nicely");
    }
}

class ActionsOfDuck{
    public static void main(String[] args) {
        Flyable duckFly = new Duck();
        Swimmable duckSwim = new Duck();

        duckFly.fly();
        duckSwim.swim();
    }
}
