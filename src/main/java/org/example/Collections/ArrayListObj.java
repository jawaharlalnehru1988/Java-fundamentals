package org.example.Collections;

import org.example.Supportives.Employee;

import java.util.ArrayList;
import java.util.List;

import static java.lang.reflect.Array.set;

public class ArrayListObj {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        //add() method
        employees.add(new Employee(1, "Ram", 2342234.23));
        employees.add(new Employee(2, "Lakshman", 242342.23));
        employees.add(new Employee(3, "Raghunath", 234222.23));
        Employee empl = new Employee(4, "ram Krishna", 10.12);
        Employee empl2 = new Employee(5, "gopala", 146.12);
        Employee emp3 = new Employee(6, "Dasarath", 2342.23);
        employees.add(empl);
        employees.add(empl2);

        //----------------------------------------------------------------------

        employees.add(3, emp3);


//        for (Employee emp : employees) {
//            System.out.println(emp);
//        }
        //get()

        //----------------------------------------------------------------------
//        Employee sss = employees.get(4);
//        System.out.println(sss);

        //get the count

        //----------------------------------------------------------------------

//        int count = employees.size();
//        System.out.println("count" + count);


        //remove object
        //----------------------------------------------------------------------

// Employee removedValue = employees.remove(0);
// System.out.println("removedValue " + removedValue);

        // set(El, e) Replaces the element at the specified index with a new value.
        try {
            employees.set(3, new Employee(7, "Ramkumar", 5232.13));
            if (employees.size() > 5) {
                Employee seventh = employees.get(1);
                System.out.println(seventh);
            }

            System.out.println(employees.size());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index access - " + e.getMessage());
        }
    }

}
