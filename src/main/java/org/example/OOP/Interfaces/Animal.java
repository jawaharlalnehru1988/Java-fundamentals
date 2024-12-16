package org.example.OOP.Interfaces;

public interface Animal {
    void makeSound();
    void eat();
}

class Dog implements Animal{
    @Override
     public void makeSound(){
        System.out.println("Woof! Woof!");
    }

    @Override
    public void eat(){
        System.out.println("the dog is eating rice");
    }
}

class Cat implements Animal{
    @Override
    public void makeSound(){
        System.out.println("meow! meow!");
    }

    @Override
    public void eat(){
        System.out.println("Cat drink milk");
    }
}

class ActionOfAnimals{
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.makeSound();
        dog.eat();
        System.out.println("-----------");

        cat.makeSound();
        cat.eat();
    }
}
