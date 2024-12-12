package org.example.Supportives;

public class Person {
public String name;
public int age;
public Person(String name, int age){
    this.name = name;
    this.age = age;
}
public Person(){}

    @Override
    public String toString(){
    return "Person{ Name: '" + this.name + "', Age: " + this.age + " }";
            }

}
