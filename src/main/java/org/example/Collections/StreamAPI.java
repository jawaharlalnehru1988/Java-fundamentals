package org.example.Collections;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamAPI {
    public static void main(String[] args) {

        // Integer Array

        //declare first and add values later
//        int[] nums = new int[5];
//        nums[0] = 1;
//        nums[1] = 2;
//        nums[2] = 3;
//        nums[3] = 4;
//        nums[4] = 5;

        // Printing the length of the array
//        System.out.println("Original Array: " + nums.length);

        // Printing the values with for loop
//        Arrays.stream(nums).filter(num -> num%2 == 0).forEach(System.out::println);


        // how to use toArray method
//        ArrayList<Integer> numList = new ArrayList<>();
//
//        for (int num : nums) {
//            if(num % 2 == 0){
//            numList.add(num);
//            }
//        }
////
//        System.out.println(numList);
//        for (int i = 0; i < 10; i++) {
//            numList.add(i);
//        }
//
//        Integer[] numArr = numList.toArray(new Integer[0]);
//
//        for(Integer num : numArr){
//            if(num % 3 == 0)
//            System.out.println(num);
//        }

//        int[] nums = {1, 2, 3, 4, 5};
//        boolean isAllWholeNum = Arrays.stream(nums).allMatch(num -> num > 0);
//        System.out.println(isAllWholeNum);

//        String[] names = {"John", "Jane", "Doe"};
//        boolean isAllNames = Arrays.stream(names).allMatch(name -> name.length() > 3);
//        System.out.println(isAllNames);

//            boolean isAnyName = Arrays.stream(names).allMatch(name -> name.startsWith("J"));
//            System.out.println(isAnyName);

//        boolean result = Arrays.stream(new int[]{1, 2, 3, 4, 5}).anyMatch(num -> num > 3);
//        System.out.println(result);

//        String[] names = {"Jagannath", "Jayadeva", "radha"};
//        boolean result = Arrays.stream(names).anyMatch(name -> name.endsWith("a"));
//        System.out.println(result);

//        boolean resultMatch = Arrays.stream(new int[]{1, 2, 3, 4, 5}).noneMatch(num -> num > 5);
//        System.out.println(resultMatch);

//        int[] nums = {1, 2, 3, 4, 5};
//        int sum = Arrays.stream(nums).sum();
//        System.out.println(sum);

//        int[] nums = {1, 2, 3, 4, 5};
//        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
//        System.out.println(sum);

//        int[] nums = {1, 2, 3, 4, 5};
//        int sum = Arrays.stream(nums).reduce(0, Integer::sum);
//        System.out.println(sum);

//        int[] nums = {1, 2, 3, 4, 5};
//        Arrays.stream(nums).average().ifPresent(System.out::println);

//        int[] nums = {1, 2, 3, 4, 5};
//        int max = Arrays.stream(nums).max().getAsInt();
//        System.out.println(max);
//
//        int min = Arrays.stream(nums).min().getAsInt();
//        System.out.println(min);

//        int[] nums = {1, 2, 3, 4, 5};
//        int[] copyOfNums = Arrays.copyOf(nums, 3);
//        System.out.println(Arrays.toString(copyOfNums));

//        int[] nums = {1, 2, 3, 4, 5};
//        int[] copyOfNums = Arrays.copyOfRange(nums, 1, 4);
//        System.out.println(Arrays.toString(copyOfNums));

//        String[] words = {"apple", "banana", "cherry", "date"};
//        long count = Arrays.stream(words).count();
////        long count = Stream.of(words).count();
//        System.out.println(count);


//        String[] words = {"apple", "banana", "cherry", "date"};
//        Arrays.stream(words).filter(word -> word.length() > 5).forEach(System.out::println);

//        String[] words = {"apple", "banana", "cherry", "date"};
//        Stream.of(words).filter(word -> word.length() > 5).forEach(System.out::println);

//        String[] words = {"apple", "cherry", "date", "banana"};
//        Arrays.stream(words).sorted().forEach(System.out::println);

//        int[] numbers = {3, 5, 1, 7, 2, 9, 3};
//        Arrays.stream(numbers).sorted().forEach(System.out::println);

//        int[] numbers = {3, 5, 1, 7, 2, 9, 3};
//        Arrays.stream(numbers).distinct().forEach(System.out::println);

//         int[] numbers = {3, 5, 1, 7, 2, 9, 3};
//         Stream<Integer> stream = IntStream.of(numbers).boxed();
//            stream.distinct().forEach(System.out::println);



    }}