package org.example.Collections;

import org.example.Supportives.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Array {
    public static void main(String[] args) {
        //1. Declaration and Initialization in Separate Steps:

//        int[] numbers = new int[5];
//        numbers[0] = 10;
//        numbers[1] = 20;
//        numbers[2] = 30;
//        numbers[3] = 40;
//        numbers[4] = 50;
//
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(numbers[i]);
//        }

        //------------------------------------------------------------

        //2. Declaration and Initialization in a Single Step:

//        String[] fruits = {"Apple", "Orange", "Banana"};
//
//        for (String fruit: fruits){
//            System.out.println(fruit);
//        }

        //---------------------------------------------------------

        //creating array of objects

//        Person[] persons = new Person[3];
//
//        persons[0] = new Person();
//        persons[0].name = "Ram";
//        persons[0].age = 12;
//
//        persons[1] = new Person();
//        persons[1].name = "Sita";
//        persons[1].age = 10;
//
//        persons[2] = new Person();
//        persons[2].name = "Lakshman";
//        persons[2].age = 11;

//        for (int i = 0; i < persons.length; i++) {
//            System.out.println("Name: " + persons[i].name + ", Age: " + persons[i].age);
//
//        }

//        for (Person person : persons){
//            System.out.println("Name: " + person.name + ", Age: " + person.age);
//        }

        // cloning an object
//        Person[] person2 = persons.clone();
//        System.out.println(person2.length);


//        stream.map

//        Stream<Person> personStream = Arrays.stream(persons);
//
//        Person[] updatedPersons = personStream.map(person -> new Person(person.name, person.age + 5)).toArray(Person[]:: new);
//
//        System.out.println(Arrays.toString(updatedPersons));


        //---------------------------------------------------------------------
        //Stream.filter with strings

//        String[] names = {"Ram", "Krishna", "Hari", "Keshav", "Govinda"};
//
//        List<String> filteredNames = Arrays.stream(names).filter(name -> name.startsWith("R") || name.startsWith("K")).collect(Collectors.toList());
//
//        System.out.println(filteredNames);

        //Stream.filter with numbers
//        Integer[] numbers = {10, 15, 20, 25, 30};
//
//        List<Integer> filteredNumbers = Arrays.stream(numbers).filter(num -> num > 20).collect(Collectors.toList());
//
//        System.out.println(filteredNumbers);

     Person[] persons = new Person[]{
             new Person("Govind", 21),
             new Person("Mukund", 23)
     };

     Person[] people = {
             new Person("Madhusudhana", 24),
             new Person("Achyutha", 42)
     };

    List<Person> adidev = new ArrayList<>();

    }
}


