package org.example.Challenges;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayofNumbers {
    // write a method that takes an array of numbers and returns the duplicate values in the array
// method 1; with nested for loops
//    public static int[] findDuplicate(int[] numbers) {
//        int[] duplicates = new int[numbers.length];
//        int count = 0;
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] == numbers[j]) {
//                    duplicates[count] = numbers[j];
//                    count++;
//                }
//            }
//        }
//        return duplicates;
//    }




    public static void main(String[] args) {

        // create a number variable and assign 10 values with duplicate values
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 1};

        // find the duplicate values in the array
//        int[] duplicates = findDuplicate(numbers);
//        for (int i = 0; i < duplicates.length; i++) {
//            if (duplicates[i] != 0) {
//                System.out.println("Duplicate value: " + duplicates[i]);
//            }
//        }


        // find duplicates using hash map

//        Map<Integer, Integer> numberCount = new HashMap<>();
//        for (int number : numbers) {
//            if (numberCount.containsKey(number)) {
//                numberCount.put(number, numberCount.get(number) + 1);
//            } else {
//                numberCount.put(number, 1);
//            }
//        }
//
//        for(Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
//            if (entry.getValue() > 1) {
//                System.out.println("Duplicate value: " + entry.getKey());
//            }
//        }

        //--------------------------------------------------------------------------------

        // find duplicates using streams
//        Map<Integer, Long> numberCount = Arrays.stream(numbers)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        numberCount.forEach((key, value) -> {
//            if (value > 1) {
//                System.out.println("Duplicate value: " + key);
//            }
//        });

        //--------------------------------------------------------------------------------

        // find duplicates using streams
//        Arrays.stream(numbers)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .forEach((key, value) -> {
//                    if (value > 1) {
//                        System.out.println("Duplicate value: " + key);
//                    }
//                });

        //--------------------------------------------------------------------------------

        // find duplicates using HashSet and Arraylist

        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int number : numbers) {
            if (!uniqueNumbers.add(number)) {
                duplicates.add(number);
            }
        }

        duplicates.forEach(System.out::println);

    }
}
