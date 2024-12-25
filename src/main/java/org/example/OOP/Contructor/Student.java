package org.example.OOP.Contructor;

public class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber){
        this.name = name;
        this.rollNumber = rollNumber;
    }

   public void displayInfo(){
        System.out.println("Name: " + this.name + ", Roll Number: " + this.rollNumber);
    }


}
