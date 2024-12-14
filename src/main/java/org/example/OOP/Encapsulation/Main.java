package org.example.OOP.Encapsulation;

public class Main {
    public static void main(String[] args) {

            Person person = new Person();
            person.setName("Ram sree");
            person.age = 12;
            person.nationality = "Indian";
            person.id = "12SA";

        System.out.printf("Name: %s, Age: %d, Nationality: %s, Id: %s", person.getName(), person.age, person.nationality, person.id);


    }



}
