package org.example.OOP.Contructor;

public class Student {
    String name;
    int rollNumber;

    Student(String name3, int rollNumberr){
        this.name = name3;
        this.rollNumber = rollNumberr;
    }

    Student(Student student){
        this.name = student.name;
        this.rollNumber = student.rollNumber;
    }

    void displayInfo(){
        System.out.println("Name: " + this.name + ", Roll Number: " + this.rollNumber);
    }

    public static void main(String[] args) {
        Student student = new Student("Jagannath", 101);
        student.displayInfo();
        Student student1 = new Student(student);
        student1.displayInfo();
    }
}
