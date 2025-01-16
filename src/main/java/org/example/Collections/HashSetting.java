package org.example.Collections;

import org.example.OOP.Contructor.Student;

import java.util.HashSet;

public class HashSetting {
    public static void main(String[] args) {
        // Create a HashSet

//        HashSet<String> hashSet = new HashSet<>();

        // Add elements
//        hashSet.add("Java");
//        hashSet.add("Python");
//        hashSet.add("JavaScript");
//        hashSet.add("Ruby");
//        hashSet.add("Java");
//
//        // Print the HashSet
//        System.out.println(hashSet);

//        // Remove elements
//        hashSet.remove("JavaScript");
//        System.out.println(hashSet);


//        HashSet<Student> students = new HashSet<>();
//
//        // Add students to HashSet
//        students.add(new Student( "John", 1));
//        students.add(new Student("Alice", 2));
//        students.add(new Student( "John", 1)); // Duplicate based on overridden equals and hashCode
//
//        // Print the HashSet
//        System.out.println(students);

        int[] numbers = {1, 4, 2, 5, 3, 1, 4, 3};
        HashSet<Integer> unique = new HashSet<>();

        for (int num: numbers){
            unique.add(num);
        }


//        unique.add(2);
//        unique.add(4);
//        unique.add(2);
//        unique.add(5);
//        unique.add(4);

        System.out.println(unique);

    }
}
