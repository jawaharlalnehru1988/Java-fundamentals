package org.example.Challenges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class   Person {
    private String name;
    private int age;
    private String job;
    private String location;
    private double salary;


    public void printAttributes() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Job: " + job);
        System.out.println("Location: " + location);
        System.out.println("Salary: " + salary);
    }
}
