package org.example.OOP.Abstractions;

abstract class Animal {
    abstract void makeSound();
    abstract void move();

    void describe(){
        System.out.println("I am an animal");
    }
}

class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("Woof! Woof!");
    }

    @Override
    void move(){
        System.out.println("The dog runs on four legs.");
    }
}

class Bird extends Animal{
    @Override
    void makeSound(){
        System.out.println("Tweet! Tweet!");
    }

    @Override
    void move(){
        System.out.println("The bird flaps its wings and flies");
    }
}

class Fish extends Animal{
    @Override
    void makeSound(){
        System.out.println("Blub! Blub!");
    }

    @Override
    void move(){
        System.out.println("The fish swims through the water");
    }
}

class AnimalsBehave {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.describe();
        dog.makeSound();
        dog.move();

        System.out.println("-------------------");

        Animal bird = new Bird();
        bird.describe();
        bird.makeSound();
        bird.move();

        System.out.println("--------------------");

        Animal fish = new Fish();
        fish.describe();
        fish.makeSound();
        fish.move();
    }
}
