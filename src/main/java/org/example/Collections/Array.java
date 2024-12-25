package org.example.Collections;

import org.example.OOP.Contructor.Student;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {

        // Integer Array

        //declare first and add values later
        int[] nums = new int[5];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;


        // declare and add values
        int[] numbers = {1, 2, 3, 4, 5, 6};

        // printing the values with for loop

//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] != 0)
//            System.out.println(nums[i]);
//        }

        // printing the values with for each loop

//        for (int num : numbers) {
//            System.out.println(num);
//        }
//
//        // printing the values with Arrays.toString
//
//        System.out.println(Arrays.toString(nums));
//
//        // printing the values with Arrays.stream
//        Arrays.stream(nums).forEach(System.out::println);



//        // Double Array
//        //declare first and add values later
        double[] doubleNum = new double[5];
        doubleNum[0] = 1.1;
        doubleNum[1] = 2.2;
        doubleNum[2] = 3.3;
        doubleNum[3] = 4.4;
        doubleNum[4] = 5.5;
//
//        // declare and add values
        double[] doubleNumbers = {1.1, 2.2, 3.3, 4.4, 5.5};
//
//        // printing the values with for loop
//        for (int i = 0; i < doubleNum.length; i++) {
//            System.out.println(doubleNum[i]);
//        }
//
//        // printing the values with for each loop
//        for (double num : doubleNum) {
//            System.out.println(num);
//        }
//
//        // printing the values with Arrays.toString
//        System.out.println(Arrays.toString(doubleNum));
//
//        // printing the values with Arrays.stream
//        Arrays.stream(doubleNum).forEach(System.out::println);
//
//
//        // String Array
//        //declare first and add values later
        String[] name = new String[5];
        name[0] = "Hari";
        name[1] = "Gopal";
        name[2] = "Raghav";
        name[3] = "Ravi";
        name[4] = "Rajesh";
//
//        // declare and add values
//
        String[] names = {"Hari", "Gopal", "Raghav", "Ravi", "Rajesh"};
//
//
//        // printing the values with for loop
//
//        for (int i = 0; i < name.length; i++) {
//            System.out.println(name[i]);
//        }
//
//        // printing the values with for each loop
//        for (String n : name) {
//            System.out.println(n);
//        }
//
//        // printing the values with Arrays.toString
//        System.out.println(Arrays.toString(name));
//
//        // printing the values with Arrays.stream
//        Arrays.stream(name).forEach(System.out::println);
//
//        // Object Array which contains multiple data types
//
//        //declare first and add values later
        Object[] obj = new Object[4];
        obj[0] = 1;
        obj[1] = 2.2;
        obj[2] = "Hari";
        obj[3] = 'c';
//
//        // declare and add values
//        Object[] objects = {1, 2.2, "Hari", 'c'};
//
//        // printing the values with for loop
//        for (int i = 0; i < obj.length; i++) {
//            System.out.println(obj[i]);
//        }
//
//        // printing the values with for each loop
//
//        for (Object o : obj) {
//            System.out.println(o);
//        }

//        // printing the values with Arrays.toString
//        System.out.println(Arrays.toString(obj));
//
//        // printing the values with Arrays.stream
//        Arrays.stream(obj).forEach(System.out::println);
//
//        // Array of objects
//
//        //declare first and add values later
//
        Student[] student = new Student[4];

        student[0] = new Student("Hari", 1);
        student[1] = new Student("Ravi", 2);
        student[2] = new Student("Rajesh", 3);
        student[3] = new Student("Raghav", 4);
//
//
//
//        // declare and add values
        Student[] students = {
                new Student("Hari", 1),
                new Student("Ravi", 2),
                new Student("Rajesh", 3),
                new Student("Raghav", 4),
                new Student("Gopal", 5)
        };
//
//        // printing the values with for loop
//        for (int i = 0; i < student.length; i++) {
//            student[i].displayInfo();
//        }
//
//        // printing the values with for each loop
//        for (Student s : students) {
//            s.displayInfo();
//        }
//
//        // printing the values with Arrays.toString
//        System.out.println(Arrays.toString(student));
//
//        // printing the values with Arrays.stream
//        Arrays.stream(student).forEach(Student::displayInfo);


    }
}


