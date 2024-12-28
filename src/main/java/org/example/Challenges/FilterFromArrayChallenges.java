package org.example.Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterFromArrayChallenges {
//    functions to implement the solution

//    create a method to Find all strings with a length greater than a certain value.
    public static List<String> findStringsGreaterThan(String[] strings, int value){
        //edge cases
        if(strings == null) return null;

        return Arrays.stream(strings)
                .filter(s -> s.length() > value)
                .collect(Collectors.toList());
    }

    // method 2: with for loop
    public static List<String> findStringsGreater(String[] strings, int value){
        if(strings == null) return null;
        List<String> longStrings = new ArrayList<>();

        for (String string : strings) {
            if (string.length() > value) {
               longStrings.add(string);
            }
        }
        return longStrings;
    }

    // create a method to filter numbers greater than a certain value

    public static List<Integer> filterNumbersGreaterThan(int[] numbers, int value){
        if(numbers == null) return null;
        return Arrays.stream(numbers)
                .filter(num -> num > value)
                .boxed()
                .collect(Collectors.toList());
    }

    // method 2: with for loop
    public static List<Integer> filterNumbersGreater(int[] numbers, int value){
        if(numbers == null) return null;
        List<Integer> greaterNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number > value) {
                greaterNumbers.add(number);
            }
        }
        return greaterNumbers;
    }

    // filter objects greater than a certain value
    public static List<Person> filterStudentsGreaterThan(Person[] students, int value){
        if(students == null) return null;
        return Arrays.stream(students)
                .filter(student -> student.getAge() > value)
                .collect(Collectors.toList());
    }

    // method 2: with for loop
    public static List<Person> filterStudentsGreater(Person[] students, int value){
        if(students == null) return null;
        List<Person> greaterStudents = new ArrayList<>();
        for (Person student : students) {
            if (student.getAge() > value) {
                greaterStudents.add(student);
            }
        }
        return greaterStudents;
    }

//3. Filter Strings Ending with a Specific Suffix

    public static List<String> filterStringsEndingWith(String[] strings, String suffix){
        if(strings == null) return null;
        return Arrays.stream(strings)
                .filter(s -> s.endsWith(suffix))
                .collect(Collectors.toList());
    }

    // method 2: with for loop

    public static List<String> filterStringsEndWith(String[] strings, String suffix){
        if(strings == null) return null;
        List<String> endWith = new ArrayList<>();
        for (String string : strings) {
            if (string.endsWith(suffix)) {
                endWith.add(string);
            }
        }
        return endWith;
    }

    public static void main(String[] args) {

        // Problem 1: Find all strings with a length greater than a certain value.
//        String[] strings = {"apple", "banana", "cat", "dog"};
//
//        // Solution
//        List<String> longStrings = Arrays.stream(strings)
//                .filter(s -> s.length() > 3)
//                .collect(Collectors.toList());
//        System.out.println(longStrings);
//
//        // solution with for loop
//        for (String string : strings) {
//            if (string.length() > 3) {
//                System.out.println(string);
//            }
//        }

        //--------------------------------------------------------------------------------

        // Problem: Find all strings that start with a particular prefix.

//        String[] strings = {"apple", "banana", "apricot", "grape"};
//        List<String> startsWithA = Arrays.stream(strings)
//                .filter(s -> s.startsWith("a"))
//                .collect(Collectors.toList());
//        System.out.println(startsWithA); // Output: [apple, apricot]
//
//        // solution with for loop
//        for (String string : strings) {
//            if (string.startsWith("a")) {
//                System.out.println(string);
//            }
//        }

//use cases
//List<String> result = findStringsGreaterThan(new String[]{"apple", "banana", "cat", "dog"}, 3);
//        System.out.println(findStringsGreaterThan(new String[]{"apple", "banana", "cat", "dog"}, 3));
//
//        List<String> result2 = findStringsGreater(new String[]{"apple", "banana", "cat", "dog"}, 3);
//        System.out.println(result2);

//        System.out.println(filterNumbersGreaterThan(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));
//        System.out.println(filterNumbersGreater(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 5));

//        Person[] students = {
//               new Person("hari", 20, "developer", "bangalore", 10000),
//                new Person("john", 30, "developer", "bangalore", 20000),
//                new Person("doe", 40, "developer", "bangalore", 30000),
//                new Person("jane", 50, "developer", "bangalore", 40000),
//                new Person("smith", 60, "developer", "bangalore", 50000),
//        };
//
//        System.out.println(filterStudentsGreaterThan(students, 30));
//        System.out.println(filterStudentsGreater(students, 30));
        //--------------------------------------------------------------------------------

        String[] strings = {"apple", "banana", "grape", "pineapple"};
        System.out.println(filterStringsEndingWith(strings, "e"));


    }
}
