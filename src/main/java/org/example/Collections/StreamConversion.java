package org.example.Collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class StreamConversion {

    public static void main(String[] args) {



        // Convert Array to Stream
//        int[] numbers = {1, 2, 3, 4, 5};
//        IntStream intStream = IntStream.of(numbers);
//        intStream.forEach(System.out::println);
//
//        // Convert Stream to Array
//        int[] intArray = IntStream.of(1, 2, 3, 4, 5).toArray();
//        for (int i : intArray) {
//            System.out.println(i);
//        }

        // Convert Stream to List
//        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
//        List<Integer> intList = intStream1.boxed().collect(Collectors.toList());
//        System.out.println(intList);

        // Convert List to Stream
//        List<Integer> intList = List.of(1, 2, 3, 4, 5);
//        IntStream intStream = intList.stream().mapToInt(Integer::intValue);
//        intStream.forEach(System.out::println);

        // Convert IntStream to Stream<Integer>
//        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
//        Stream<Integer> stream = intStream.boxed();
//        stream.forEach(System.out::println);

        // Convert Stream<Integer> to IntStream
//        IntStream intStream = Stream.of(1, 2, 3, 4, 5).mapToInt(Integer::intValue);
//        intStream.forEach(System.out::println);


        //---------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------


        // double to DoubleStream

//        double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
//
//        List<Double> doubleList = DoubleStream.of(doubleArray).boxed().collect(Collectors.toList());
//        System.out.println(doubleList);

        // Convert List to Stream
//        List<Integer> intList = List.of(1, 2, 3, 4, 5);
//        IntStream intStream = intList.stream().mapToInt(Integer::intValue);
//        intStream.forEach(System.out::println);

        // Convert Array to Stream
//        int[] intArray = {1, 2, 3, 4, 5};
//        IntStream intStream = IntStream.of(intArray);
//        intStream.forEach(System.out::println);

        // long to LongStream

//        long[] longArray = {1, 2, 3, 4, 5};
//        List<Long> longList = LongStream.of(longArray).boxed().collect(Collectors.toList());
//        System.out.println(longList);

        // intStream to Stream<Integer>
//        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
//        Stream<Integer> stream = intStream.boxed();
//        stream.forEach(System.out::println);

        // Stream<Integer> to IntStream
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
//        IntStream intStream = stream.mapToInt(Integer::intValue);
//        intStream.forEach(System.out::println);

        // DoubleStream to Stream<Double>
//        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5);
//        Stream<Double> stream = doubleStream.boxed();
//        stream.forEach(System.out::println);

        // Stream<Double> to DoubleStream
//        Stream<Double> stream = Stream.of(1.1, 2.2, 3.3, 4.4, 5.5);
//        DoubleStream doubleStream = stream.mapToDouble(Double::doubleValue);
//        doubleStream.forEach(System.out::println);

        // LongStream to Stream<Long>
//        LongStream longStream = LongStream.of(1, 2, 3, 4, 5);
//        Stream<Long> stream = longStream.boxed();
//        stream.forEach(System.out::println);

        // Stream<Long> to LongStream
//        Stream<Long> stream = Stream.of(1L, 2L, 3L, 4L, 5L);
//        LongStream longStream = stream.mapToLong(Long::longValue);
//        longStream.forEach(System.out::println);

        // String to Stream<String>
//        Stream<String> stream = Stream.of("apple", "banana", "cherry");
//        stream.forEach(System.out::println);

    }
}
