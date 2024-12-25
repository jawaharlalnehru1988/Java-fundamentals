package org.example.Collections;

import org.example.OOP.Contructor.Student;

import java.util.Arrays;
import java.util.List;

public class ArrayBuiltInMethods {
    public static void main(String[] args) {

//        1. sort(): Sorts the elements of the array in ascending order.

        // Sort primitive array int[]
//        int[] numbers = {5, 1, 3, 2, 4};
//        Arrays.sort(numbers);
//        System.out.println(Arrays.toString(numbers));

        // Sort primitive array double[]
//        double[] doubleNumbers = {5.5, 1.1, 3.3, 2.2, 4.4};
//        Arrays.sort(doubleNumbers);
//        System.out.println(Arrays.toString(doubleNumbers));

        // Sort primitive array char[]
//        char[] chars = {'c', 'a', 'e', 'b', 'd'};
//        Arrays.sort(chars);
//        System.out.println(Arrays.toString(chars));

        //  --------------------------------------------------------------------------------------------

        // Sort Object array String[]
//        String[] names = {"John", "Jane", "Doe"};
//        Arrays.sort(names);
//        System.out.println(Arrays.toString(names));

        // Sort Object array Student[]
//        Student[] students = {
//                new Student("John", 1),
//                new Student("Jane", 2),
//                new Student("Doe", 3)
//        };
//        Arrays.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
//        System.out.println(Arrays.toString(students));

        // sort Object array Integer[]
//        Integer[] nums = {5, 1, 3, 2, 4};
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));

//        2. binarySearch(): Searches the specified array of the primitive data type for the specified value using the binary search algorithm.

        // binarySearch primitive array int[]

//        int[] numbers = {1, 2, 3, 4, 5};
//        int index = Arrays.binarySearch(numbers, 3);
//        System.out.println(index);

        // binarySearch primitive array double[]
//        double[] doubleNumbers = {1.1, 2.2, 3.3, 4.4, 5.5};
//        int index = Arrays.binarySearch(doubleNumbers, 3.3);
//        System.out.println(index);

        // binarySearch primitive array char[]
//        char[] chars = {'a', 'b', 'c', 'd', 'e'};
//        int index = Arrays.binarySearch(chars, 'c');
//        System.out.println(index);

        //  --------------------------------------------------------------------------------------------

        // binarySearch Object array String[]
//        String[] names = {"John", "Jane", "Doe"};
//        int index = Arrays.binarySearch(names, "Jane");
//        System.out.println(index);

        // binarySearch Object array Student[]
//        Student[] students = {
//                new Student("John", 1),
//
//                new Student("Jane", 2),
//                new Student("Doe", 3)
//        };
//
//        Arrays.sort(students, (s1, s2) -> s1.getName().compareTo(s2.getName()));
//        int index = Arrays.binarySearch(students, new Student("Jane", 2), (s1, s2) -> s1.getName().compareTo(s2.getName()));
//        System.out.println(index);

        // binarySearch Object array Integer[]
//        Integer[] nums = {1, 2, 3, 4, 5};
//        int index = Arrays.binarySearch(nums, 3);
//        System.out.println(index);


//        3. equals(): Returns true if the two specified arrays of the same type contain the same elements in the same order.

        // equals primitive array int[]
//        int[] numbers1 = {1, 2, 3, 4, 5};
//        int[] numbers2 = {1, 2, 3, 4, 5};
//        boolean result = Arrays.equals(numbers1, numbers2);
//        System.out.println(result);

        // equals primitive array double[]
//        double[] doubleNumbers1 = {1.1, 2.2, 3.3, 4.4, 5.5};
//        double[] doubleNumbers2 = {1.1, 2.2, 3.3, 4.4, 5.5};
//        boolean result = Arrays.equals(doubleNumbers1, doubleNumbers2);
//        System.out.println(result);

        // equals primitive array char[]
//        char[] chars1 = {'a', 'b', 'c', 'd', 'e'};
//        char[] chars2 = {'a', 'b', 'c', 'd', 'e'};
//        boolean result = Arrays.equals(chars1, chars2);
//        System.out.println(result);

        //  --------------------------------------------------------------------------------------------

        // equals Object array String[]
//        String[] names1 = {"John", "Jane", "Doe"};
//        String[] names2 = {"John", "Jane", "Doe"};
//        boolean result = Arrays.equals(names1, names2);
//        System.out.println(result);

        // equals Object array Student[]
//        Student[] students1 = {
//                new Student("John", 1),
//                new Student("Jane", 2),
//                new Student("Doe", 3)
//        };
//        Student[] students2 = {
//                new Student("John", 1),
//                new Student("Jane", 2),
//                new Student("Doe", 3)
//        };

//        boolean result = Arrays.equals(students1, students2);
//        System.out.println(result);

        // equals Object array Integer[]
//        Integer[] nums1 = {1, 2, 3, 4, 5};
//        Integer[] nums2 = {1, 2, 3, 4, 5};
//        boolean result = Arrays.equals(nums1, nums2);
//        System.out.println(result);

//        4. fill(): Assigns the specified value to each element of the specified array of the primitive data type.

        // fill primitive array int[]
//        int[] numbers = new int[5];
//        Arrays.fill(numbers, 5);
//        System.out.println(Arrays.toString(numbers));

        // fill primitive array double[]
//        double[] doubleNumbers = new double[5];
//        Arrays.fill(doubleNumbers, 5.5);
//        System.out.println(Arrays.toString(doubleNumbers));

        // fill primitive array char[]
//        char[] chars = new char[5];
//        Arrays.fill(chars, 'a');
//        System.out.println(Arrays.toString(chars));

        //  --------------------------------------------------------------------------------------------

        // fill Object array String[]
//        String[] names = new String[5];
//        Arrays.fill(names, "John");
//        System.out.println(Arrays.toString(names));

        // fill Object array Student[]
//        Student[] students = new Student[5];
//        Arrays.fill(students, new Student("John", 1));

//        System.out.println(Arrays.toString(students));

        // fill Object array Integer[]
//        Integer[] nums = new Integer[5];
//        Arrays.fill(nums, 5);
//        System.out.println(Arrays.toString(nums));

//        5. copyOf(): Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length.

        // copyOf primitive array int[]

//        int[] numbers = {1, 2, 3, 4, 5};
//        int[] copyOfNumbers = Arrays.copyOf(numbers, 3);
//        System.out.println(Arrays.toString(copyOfNumbers));

        // 6. copyOfRange(): Copies the specified range of the specified array into a new array.

        // copyOfRange primitive array int[]
//        int[] numbers = {1, 2, 3, 4, 5};
//        int[] copyOfNumbers = Arrays.copyOfRange(numbers, 1, 4);
//        System.out.println(Arrays.toString(copyOfNumbers));

        // copyOfRange primitive array double[]

//        double[] doubleNumbers = {1.1, 2.2, 3.3, 4.4, 5.5};
//        double[] copyOfDoubleNumbers = Arrays.copyOfRange(doubleNumbers, 1, 4);
//        System.out.println(Arrays.toString(copyOfDoubleNumbers));

// 7. setAll(): Assigns the specified value producer to each element of the specified array of the primitive data type.

        // setAll primitive array int[]

//        int[] numbers = new int[5];
//        Arrays.setAll(numbers, i -> i + 1);
//        System.out.println(Arrays.toString(numbers));

        // 8. asList(): Returns a fixed-size list backed by the specified array.

        // asList primitive array int[]

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        System.out.println(list);

        // asList with Object array Integer[]
//        Integer[] nums = {1, 2, 3, 4, 5};
//        List<Integer> integerList = Arrays.asList(nums);
//        System.out.println(integerList);

        // asList primitive array double[]

//        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
//        System.out.println(doubleList);

        // asList primitive array String[]
//        List<String> stringList = Arrays.asList("John", "Jane", "Doe");
//        System.out.println(stringList);


        // asList Object array Student[]

//        Student[] students = {
//                new Student("John", 1),
//                new Student("Jane", 2),
//                new Student("Doe", 3)
//        };
//
//        List<Student> studentList = Arrays.asList(students);
//        System.out.println(studentList);

//        9. stream(): Returns a sequential Stream with the specified array as its source.

            // stream primitive array int[]
//        int[] numbers = {1, 2, 3, 4, 5};
//        Arrays.stream(numbers).forEach(System.out::println);

            // stream primitive array double[]
//        double[] doubleNumbers = {1.1, 2.2, 3.3, 4.4, 5.5};
//        Arrays.stream(doubleNumbers).forEach(System.out::println);

            // stream primitive array char[]
//        char[] chars = {'a', 'b', 'c', 'd', 'e'};
//        Arrays.stream(chars).forEach(System.out::println);

            //  --------------------------------------------------------------------------------------------

            // stream Object array String[]
//        String[] names = {"John", "Jane", "Doe"};
//        Arrays.stream(names).forEach(System.out::println);

            // stream Object array Student[]
//        Student[] students = {
//                new Student("John", 1),
//                new Student("Jane", 2),
//                new Student("Doe", 3)
//        };
//        Arrays.stream(students).forEach(System.out::println);

            // 11. deepEquals(): Returns true if the two specified arrays are deeply equal to one another.


        // deepEquals primitive array int[]
//        int[] numbers1 = {1, 2, 3, 4, 5};
//        int[] numbers2 = {1, 2, 3, 4, 5};
//        boolean result = Arrays.deepEquals(new int[][]{numbers1}, new int[][]{numbers2});
//        System.out.println(result);

        // deepEquals primitive array double[]
//        double[] doubleNumbers1 = {1.1, 2.2, 3.3, 4.4, 5.5};
//        double[] doubleNumbers2 = {1.1, 2.2, 3.3, 4.4, 5.5};
//        boolean result = Arrays.deepEquals(new double[][]{doubleNumbers1}, new double[][]{doubleNumbers2});
//        System.out.println(result);

        // 12. mismatch(): Returns the index of the first mismatch between two arrays of the primitive data type.

//        int[] nums1 = {1, 2, 3};
//        int[] nums2 = {1, 2, 4};
//        int mismatchIndex = Arrays.mismatch(nums1, nums2);
//        System.out.println(mismatchIndex);








    }
}
