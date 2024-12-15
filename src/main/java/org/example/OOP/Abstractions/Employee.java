package org.example.OOP.Abstractions;

abstract class Employee {
    private String name;
    private int id;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();
    abstract String getRole();

    public void displayDetails(){
        System.out.printf("EmpName: %s, EmpId: %d, Salary: %.2f, Role: %s%n", name, id, calculateSalary(), getRole());
    }
}
