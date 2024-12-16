package org.example.Lambda;

public class Person {
    String name;
    int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return name + ": " + age;
    }

    public String printNames(){
        return name;
    }
}
