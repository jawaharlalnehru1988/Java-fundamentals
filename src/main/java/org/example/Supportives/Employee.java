package org.example.Supportives;

public class Employee {
    private Integer id;
    private String empName;
    private Double salary;


    public Employee(Integer id, String empName, Double salary) {
        this.id = id;
        this.empName = empName;
        this.salary = salary;
    }

    //toString() for easy printing
    public String toString() {
        return "Employee{Employee Name='" + empName + "', salary=" + salary + ",  id: " + id + "}";
    }

}
