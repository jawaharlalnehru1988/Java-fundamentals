package org.example.OOP.Contructor;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return rollNumber == student.rollNumber && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, rollNumber);
    }
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }
}
