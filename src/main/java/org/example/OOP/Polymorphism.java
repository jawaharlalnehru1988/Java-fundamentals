package org.example.OOP;

class Calculator{
    public int add(int a){
        return a;
    }

    public int add(int a , int b){
        return a + b;
    }
}


class Animal{
   public void sound(){
        System.out.println("animal sound");
    }
}

class Cow extends Animal{
    @Override
    public void sound(){
        System.out.println("maa.....maa....");
    }
}


public class Polymorphism {


    public static void main(String[] args) {

        Calculator calc = new Calculator();
        System.out.println(calc.add(5));
        System.out.println(calc.add(6, 7));

        Animal animal = new Cow();
        animal.sound();

        Animal animal1 = new Animal();
        animal1.sound();

        Cow cow = new Cow();
        cow.sound();
    }
}
