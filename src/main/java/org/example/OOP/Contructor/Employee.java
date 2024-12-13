package org.example.OOP.Contructor;

public class Employee {
    String name;
    double salary;
    String department;

    Employee(){
        this.name = "Unknown";
        this.salary = 0.00;
        this.department = "Unknown";
    }

    Employee(String name, double salary, String department){
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    String calculateAnnualSalary(){
        return "Name: " + this.name + ", Department: " + this.department + ", Annual Salary: " + (this.salary * 12);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Raghunath", 12000, "IT");

        String annualCTC = employee.calculateAnnualSalary();
        System.out.println(annualCTC);
    }
}
