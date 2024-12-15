package org.example.OOP.Abstractions;

import java.util.ArrayList;
import java.util.List;

public class SalaryAllocation {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Developer("Hari Haran", 101, 34939.23, 2300.33));
        employees.add(new Developer("Ram kumar", 102, 34223.23, 2000.33));
        employees.add(new Manager("Prithivi Rajan", 103, 20030.32, 3223.23));

        for (Employee employee : employees){
            employee.displayDetails();
        }
    }
}
