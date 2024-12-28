package org.example.Collections;

import org.example.Supportives.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CollectionToArrayConversion {
    public static void main(String[] args) {
        // Convert a collection to an array
        // Using toArray() method

//        List<String> list = List.of("apple", "banana", "cat", "dog");
//        // without type specification
//        Object[] array = list.toArray();
//        System.out.println(Arrays.toString(array));
//
//        // with type specification
//        String[] array1 = list.toArray(new String[0]);
//        System.out.println(Arrays.toString(array1));
//
//        // using Stream API
//        String[] array2 = list.stream().toArray(String[]::new);
//        System.out.println(Arrays.toString(array2));
//
//        // Using loops
//        String[] array3 = new String[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            array3[i] = list.get(i);
//        }
//
//        System.out.println(Arrays.toString(array3));

        // Convert a list of Integers to an array of ints
//        List<Integer> list = List.of(1, 2, 3, 4, 5);
//
//        // without type specification
//        Object[] array = list.toArray();
//        System.out.println(Arrays.toString(array));
//        // with type specification
//        Integer[] array1 = list.toArray(new Integer[0]);
//        int[] array2 = list.stream().mapToInt(Integer::intValue).toArray();
//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));
//
//        // Using loops
//        int[] array3 = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            array3[i] = list.get(i);
//        }
//        System.out.println(Arrays.toString(array3));
//        Integer[] array4 = list.stream().toArray(Integer[]::new);
//        System.out.println(Arrays.toString(array4));
//        System.out.println(Arrays.toString(array4));


        // Convert a list of Person objects to an array of Person objects
//
//        List<Person> people = List.of(
//                new Person("Alice", 23),
//                new Person("Bob", 25),
//                new Person("Charlie", 27)
//        );
//
//        // without type specification
//        Object[] array = people.toArray();
//        System.out.println(Arrays.toString(array));
//
//        // with type specification
//        Person[] array1 = people.toArray(new Person[0]);
//        System.out.println(Arrays.toString(array1));
//
//        // using Stream API
//        Person[] array2 = people.stream().toArray(Person[]::new);
//        System.out.println(Arrays.toString(array2));
//
//        // Using loops
//        Person[] array3 = new Person[people.size()];
////        for (int i = 0; i < people.size(); i++) {
////            array3[i] = people.get(i);
////        }
//
//        for (Person per: people) {
//            array3[people.indexOf(per)] = per;
//        }
//
//        System.out.println(Arrays.toString(array3));




    }
}
