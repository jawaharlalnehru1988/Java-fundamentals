package org.example.Challenges;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private String job;
    private String location;
    private double salary;

    public Person(String name, int age, String job, String location, double salary) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.location = location;
        this.salary = salary;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public void printAttributes() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Job: " + job);
        System.out.println("Location: " + location);
        System.out.println("Salary: " + salary);
    }
}
