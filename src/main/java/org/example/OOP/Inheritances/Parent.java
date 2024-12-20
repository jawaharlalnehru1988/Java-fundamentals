package org.example.OOP.Inheritances;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parent {
    private String firstName;
    private String lastName;
    private String job;
    private int age;

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public void printDetails(){
        System.out.println("Name: " + getFullName());
        System.out.println("Job: " + job);
        System.out.println("Age: " + age);
    }


}
