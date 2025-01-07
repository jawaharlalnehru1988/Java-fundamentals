package org.example.OOP.Encapsulation;

import java.util.Arrays;

public class Employee {
    private String name;
    private int age;
    private double salary;

    public void setName(String name){
        if(name == null ||  name.trim().isEmpty() ){
            System.out.println("Name cannot be null or empty");
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else {
            this.name = name;
        }
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        if(age < 18 || age > 65){
            throw new IllegalArgumentException("Age must be between 18 and 65");
        }
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setSalary(double salary){
        if(salary <= 0){
            throw new IllegalArgumentException("Salary must be greater than 0");
        }
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public static void main(String[] args) {

        Book[] books = {
                new Book("bhagavat", "krishna"),
                new Book("gita", "krishna"),
                new Book("bhagavatam", "krishna"),
                new Book("garuda", "krishna")
        };


        System.out.println(Arrays.toString(books));


        Employee employee = new Employee();
        try{
            employee.setName("");
        } catch( IllegalArgumentException e){
            System.out.println("Invalid Name: " + e.getMessage());
        }
        try{
            employee.setName(null);
        } catch( IllegalArgumentException e){
            System.out.println("Invalid Name: " + e.getMessage());
        }

        try{
            employee.setAge(17);
        } catch (IllegalArgumentException e){
            System.out.println("invalid Age: " + e.getMessage());
        }

        try{
            employee.setSalary(-2000);
        } catch (IllegalArgumentException e){
            System.out.println("Invalid salary: " + e.getMessage());
        }

        try{
            employee.setName("Hari");
            employee.setAge(21);
            employee.setSalary(3000);

            System.out.println("Employee details");
            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Salary: $" + employee.getSalary());
        } catch (IllegalArgumentException e){
            System.out.println("Invalid entries" + e.getMessage());
        }


    }


}
