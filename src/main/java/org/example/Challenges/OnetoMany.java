package org.example.Challenges;

import org.example.OOP.Contructor.Student;

import java.util.ArrayList;
import java.util.List;

public class OnetoMany {
}

class Teacher{
    private String name;
    private int age;
    private String job;
    private String location;
    private double salary;
    private List<Student> students;

    public Teacher(String name, int age, String job, String location, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.location = location;
        this.salary = salary;
        this.students = new ArrayList<>();
    }

    //add single student
    public void addStudent(Student student){
        students.add(student);
    }

    //add multiple students
    public void addStudents(List<Student> students){
        this.students.addAll(students);
    }

    //remove single student
    public void removeStudent(Student student){
        students.remove(student);
    }

    //remove multiple students
    public void removeStudents(List<Student> students){
        this.students.removeAll(students);
    }


}
