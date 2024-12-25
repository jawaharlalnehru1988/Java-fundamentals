package org.example.Collections;

import org.example.OOP.Contructor.Student;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArrayListObj {
    public static void main(String[] args) {

//        ArrayList<Integer> nums = new ArrayList<>();
//
//            // Add elements
//            nums.add(1);
//            nums.add(2);
//            nums.add(3);
//            nums.add(4);
//            nums.add(5);
//
//            // Print the ArrayList
//            System.out.println(nums);
//
//            // Access elements
//            System.out.println(nums.get(0));
//            System.out.println(nums.get(2));
//            System.out.println(nums.get(4));
//
//            // Update elements
//            nums.set(0, 10);
//            nums.set(2, 30);
//            nums.set(4, 50);
//            System.out.println(nums);
//
//            // add element at index
//            nums.add(2, 20);
//            System.out.println(nums);
//
//            // add all elements
//
//            ArrayList<Integer> nums2 = new ArrayList<>();
//            nums2.add(6);
//            nums2.add(7);
//            nums2.add(8);
//
//            nums.addAll(nums2);
//            System.out.println(nums);

        // Student ArrayList

//        ArrayList<Student> students = new ArrayList<>();
//
//        // Add elements
//        students.add(new Student( "John", 1));
//        students.add(new Student( "Jane", 2));
//        students.add(new Student( "Jagannath", 3));
//        students.add(new Student( "Jayadeva", 4));
//        students.add(new Student( "Radha", 5));
//
//        // Print the ArrayList
//        System.out.println(students);
//
//        // Access elements
//        System.out.println(students.get(0));
//        System.out.println(students.get(2));
//        System.out.println(students.get(4));
//
//        // Update elements
//        students.set(0, new Student("John", 2));
//        students.set(2, new Student("Jagannath", 4));
//        students.set(4, new Student("Radha", 6));
//        System.out.println(students);
//
//        // add element at index
//        students.add(2, new Student( "Jane", 3));
//        System.out.println(students);
//
//        // add all elements
//
//        ArrayList<Student> students2 = new ArrayList<>();
//        students2.add(new Student("John", 8));
//        students2.add(new Student("Jane", 4));
//        students2.add(new Student("Jagannath", 7));
//
//        students.addAll(students2);
//        System.out.println(students);

        // ArrayList of ArrayList
//
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//
//        ArrayList<Integer> list1 = new ArrayList<>();
//
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//
//        list2.add(4);
//        list2.add(5);
//        list2.add(6);
//
//        ArrayList<Integer> list3 = new ArrayList<>();
//
//
//        list3.add(7);
//        list3.add(8);
//        list3.add(9);
//
//        list.add(list1);
//        list.add(list2);
//        list.add(list3);
//
//        System.out.println(list);


        // ArrayList of String

        ArrayList<String> names = new ArrayList<>();

        names.add("John");
        names.add("Jane");
        names.add("Jagannath");
        names.add("Jayadeva");
        names.add("Radha");

        // print with forEach
//        names.forEach(System.out::println);

        // remove element with index
//        names.remove(0);
//        System.out.println(names);
//
//        // remove element with value
//        names.remove("Jane");
//        System.out.println(names);
//
//        // remove all elements
//        names.clear();
//        System.out.println(names);

        // check if element exists
//        System.out.println(names.contains("Radha"));


        // check the size of the ArrayList
//        System.out.println(names.size());


        // check if the ArrayList is empty
//        System.out.println(names.isEmpty());

            // convert ArrayList to Array
//        String[] namesArray = names.toArray(new String[0]);
//        for(String name : namesArray){
//            System.out.println(name);
//        }

        // sort the ArrayList
//        names.sort(String::compareTo);
//        names.forEach(System.out::println);

        // convert ArrayList to Array using Stream

//         String[] ram = names.stream().toArray(String[]::new);
//        for(String name : ram) {
//            System.out.println(name);
//        }

        // convert ArrayList to String using reduce
//        names.stream().reduce((name1, name2) -> name1 + " " + name2).ifPresent(System.out::println);

        // convert ArrayList to String using collect
//        String name = names.stream().collect(Collectors.joining(", "));
//        System.out.println(name);

        // convert ArrayList to UpperCase using map
//        names.stream().map(String::toUpperCase).forEach(System.out::println);

            // convert ArrayList to UpperCase using map and collect
//        ArrayList<String> upperCaseNames = names.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(upperCaseNames);
//
//        // convert ArrayList to lowercase using map and collect
//        ArrayList<String> lowerCaseNames = names.stream().map(String::toLowerCase).collect(Collectors.toCollection(ArrayList::new));
//
//        System.out.println(lowerCaseNames);




    }

}
