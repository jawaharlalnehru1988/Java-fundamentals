package org.example.Collections;

import org.example.Challenges.Person;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayToCollectionConversion {

    private static Character[] toCharacterArray(char[] charArray) {

        Character[] charObjectArray = new Character[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            charObjectArray[i] = charArray[i];
        }
        return charObjectArray;
    }

    private static Boolean[] toBooleanArray(boolean[] boolArray) {
        Boolean[] boolObjectArray = new Boolean[boolArray.length];
        for (int i = 0; i < boolArray.length; i++) {
            boolObjectArray[i] = boolArray[i];
        }
        return boolObjectArray;
    }

    private static Float[] toFloatArray(float[] floatArray) {
        Float[] floatObjectArray = new Float[floatArray.length];
        for (int i = 0; i < floatArray.length; i++) {
            floatObjectArray[i] = floatArray[i];
        }
        return floatObjectArray;
    }

    public static void main(String[] args) {
        // Convert Fixed size string array to List

//        String[] strArray = {"Java", "Python", "C++", "JavaScript", "Ruby"};
//        List<String> strList = Arrays.asList(strArray);
//        System.out.println("string array: " + Arrays.toString(strArray));
//        System.out.println("strList: " + strList);

        // Convert Fixed size integer array to List
//        Integer[] intArray = {1, 2, 3, 4, 5};
//        List<Integer> intList = Arrays.asList(intArray);
//        System.out.println("intArray: " + Arrays.toString(intArray));
//        System.out.println("intList: " + intList);


        // Convert Fixed size double array to List
//        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
//        List<Double> doubleList = Arrays.asList(doubleArray);
//        System.out.println("doubleArray: " + Arrays.toString(doubleArray));
//        System.out.println("doubleList: " + doubleList);

        // Convert Fixed size character array to List

//        Character[] charArray = {'A', 'B', 'C', 'D', 'E'};
//        List<Character> charList = Arrays.asList(charArray);
//        System.out.println("charArray: " + Arrays.toString(charArray));
//        System.out.println("charList: " + charList);

        // Convert Fixed size boolean array to List

//        Boolean[] boolArray = {true, false, true, false, true};
//        List<Boolean> boolList = Arrays.asList(boolArray);
//        System.out.println("boolArray: " + Arrays.toString(boolArray));
//        System.out.println("boolList: " + boolList);

        // Convert Fixed size byte array to List

//        Byte[] byteArray = {1, 2, 3, 4, 5};
//        List<Byte> byteList = Arrays.asList(byteArray);
//        System.out.println("byteArray: " + Arrays.toString(byteArray));
//        System.out.println("byteList: " + byteList);

        // Convert Fixed size short array to List

//        Short[] shortArray = {1, 2, 3, 4, 5};
//        List<Short> shortList = Arrays.asList(shortArray);
//        System.out.println("shortArray: " + Arrays.toString(shortArray));
//        System.out.println("shortList: " + shortList);

        // Convert Fixed size long array to List

//        Long[] longArray = {1L, 2L, 3L, 4L, 5L};
//        List<Long> longList = Arrays.asList(longArray);
//        System.out.println("longArray: " + Arrays.toString(longArray));
//        System.out.println("longList: " + longList);

        // Convert Fixed size float array to List

//        Float[] floatArray = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
//        List<Float> floatList = Arrays.asList(floatArray);
//        System.out.println("floatArray: " + Arrays.toString(floatArray));
//        System.out.println("floatList: " + floatList);

        // Convert Fixed size object array to List

//        Object[] objArray = {1, "Java", 3.14, true, 'A'};
//        List<Object> objList = Arrays.asList(objArray);
//        System.out.println("objArray: " + Arrays.toString(objArray));
//        System.out.println("objList: " + objList);

        // Convert fixed size int array to List

//        int[] intArray = {1, 2, 3, 4, 5};
//        List<Integer> intList = Arrays.asList(Arrays.stream(intArray).boxed().toArray(Integer[]::new));
//        List<Integer> intList2 = Arrays.stream(intArray).boxed().collect(Collectors.toList());

//
////        --------------or----------
//        List<Integer> intList3 = Arrays.stream(intArray).boxed().toList();
//        System.out.println("intArray: " + Arrays.toString(intArray));
//        System.out.println("intList: " + intList);
//        System.out.println("intList2: " + intList2);

        // Convert fixed size double array to List
//        double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
//        List<Double> doubleList = Arrays.stream(doubleArray).boxed().collect(Collectors.toList());
//        System.out.println("doubleArray: " + Arrays.toString(doubleArray));
//        System.out.println("doubleList: " + doubleList);

        // Convert fixed size char array to List

//        char[] charArray = {'A', 'B', 'C', 'D', 'E'};
//        List<Character> charList = Arrays.stream(toCharacterArray(charArray)).collect(Collectors.toList());
//        System.out.println("charArray: " + Arrays.toString(charArray));

        // Convert fixed size boolean array to List

//        boolean[] boolArray = {true, false, true, false, true};
//        List<Boolean> boolList = Arrays.stream(toBooleanArray(boolArray)).collect(Collectors.toList());
//        System.out.println("boolArray: " + Arrays.toString(boolArray));


        // Convert fixed size float array to List

//        float[] floatArray = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
//        List<Float> floatList = Arrays.stream(toFloatArray(floatArray)).collect(Collectors.toList());
//        System.out.println("floatArray: " + Arrays.toString(floatArray));
//        System.out.println("floatList: " + floatList);

        // Convert fixed size String array to List with stream

//        String[] strArray = {"Java", "Python", "C++", "JavaScript", "Ruby"};
//        List<String> strList = Arrays.stream(strArray).collect(Collectors.toList());
//        System.out.println("strArray: " + strList);

        // Convert fixed size integer array to List with stream

//        Integer[] integers = {1, 2, 3, 4, 5};
//        List<Integer> intList = Arrays.stream(integers).collect(Collectors.toList());
//        System.out.println("intArray: " + intList);

        // Convert fixed size Character array to List with stream

//        Character[] charArray = {'A', 'B', 'C', 'D', 'E'};
//        List<Character> charList = Arrays.stream(charArray).collect(Collectors.toList());
//        System.out.println("charArray: " + charList);

        // Convert fixed size Boolean array to List with stream

//        Boolean[] boolArray = {true, false, true, false, true};
//        List<Boolean> boolList = Arrays.stream(boolArray).collect(Collectors.toList());
//        System.out.println("boolArray: " + boolList);

        // Convert fixed size Float array to List with stream

//        Float[] floatArray = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
//        List<Float> floatList = Arrays.stream(floatArray).collect(Collectors.toList());
//        System.out.println("floatArray: " + floatList);

        // Convert fixed size Object array to List with stream

//        Object[] objArray = {1, "Java", 3.14, true, 'A'};
//        List<Object> objList = Arrays.stream(objArray).collect(Collectors.toList());
//        System.out.println("objArray: " + objList);

//        Person[] people = {
//                new Person("John", 25, "tester", "chennai", 34404),
//                new Person("Mike", 30, "developer", "bangalore", 34405),
//                new Person("David", 35, "manager", "mumbai", 34406),
//                new Person("Sam", 40, "tester", "delhi", 34407),
//                new Person("Smith", 45, "developer", "pune", 34408)
//        };

//        List<Person> personList = Arrays.asList(people);
//        System.out.println("personList: " + personList);

//        List<Person> personList = Arrays.stream(people).collect(Collectors.toList());
//        System.out.println("personList: " + personList);

//        List<Person> personList = Arrays.stream(people).toList();
//        System.out.println("personList: " + personList);


        // -------------------------------------------------------------------------
        //--------------------------------------------------------------------------

        // Convert fixed size int array to map where index will be the key and value will be the element

//        int[] numbers = {1, 2, 3, 4, 5};
//        HashMap<Integer, Integer> numberMap = new HashMap<>();
//        for (int i = 0; i < numbers.length; i++) {
//            numberMap.put(i, numbers[i]);
//        }
//
//        System.out.println("numberMap: " + numberMap);

        // Convert fixed size String array to map where index will be the key and value will be the element

//        HashMap<Integer, String> stringHashMap = new HashMap<>();
//
//        String[] strings = {"Java", "Python", "C++", "JavaScript", "Ruby"};
//
//        for (int i = 0; i < strings.length; i++) {
//            stringHashMap.put(i, strings[i]);
//        }
//
//        System.out.println("stringHashMap: " + stringHashMap);

        // Convert fixed size People array to map where index will be the key and value will be the element

//        Person[] people = {
//                new Person("John", 25, "tester", "chennai", 34404),
//                new Person("Mike", 30, "developer", "bangalore", 34405),
//                new Person("David", 35, "manager", "mumbai", 34406),
//                new Person("Sam", 40, "tester", "delhi", 34407),
//                new Person("Smith", 45, "developer", "pune", 34408)
//        };
//
//        HashMap<Integer, Person> personMap = new HashMap<>();
//
//        for (int i = 0; i < people.length; i++) {
//            personMap.put(i, people[i]);
//        }
//
//        System.out.println("personMap: " + personMap);

        //  Convert fixed size People array to map where people's age will be the key and value will be the element

//        Person[] people = {
//                new Person("John", 25, "tester", "chennai", 34404),
//                new Person("Mike", 30, "developer", "bangalore", 34405),
//                new Person("David", 35, "manager", "mumbai", 34406),
//                new Person("Sam", 40, "tester", "delhi", 34407),
//                new Person("Smith", 45, "developer", "pune", 34408)
//        };
//
//        HashMap<Integer, Person> personMap = new HashMap<>();

//        for (Person person : people) {
//            personMap.put(person.getAge(), person);
//        }

//        for (int i = 0; i < people.length; i++) {
//            personMap.put(people[i].getAge(), people[i]);
//        }
//
//        System.out.println("personMap: " + personMap);

        Person[] people = {
                new Person("John", 25, "tester", "chennai", 34404),
                new Person("Mike", 30, "developer", "bangalore", 34405),
                new Person("David", 35, "manager", "mumbai", 34406),
                new Person("Sam", 40, "tester", "delhi", 34407),
                new Person("Smith", 45, "developer", "pune", 34408)
        };


        // Convert fixed size People array to map where people's name will be the key and value will be the salary

//        HashMap<String, Double> personMap = new HashMap<>();
//
//        for (Person person : people) {
//            personMap.put(person.getName(), person.getSalary());
//        }
//
//        System.out.println("personMap: " + personMap);
//
//        personMap.forEach((key, value) -> {
//            System.out.println("Name: '" + key + "', Salary: '" + value + "'");
//        });


        //// Convert fixed size People array to set where name will be the value
//
//        Set<String> nameSet = new HashSet<>();
//
//        for (Person person : people) {
//            nameSet.add(person.getName());
//        }
//
//        System.out.println("nameSet: " + nameSet);


//        String[] array = {"apple", "banana", "cherry"};
//        Set<String> set = new HashSet<>(Arrays.asList(array));
//
//        System.out.println(set);

//        String[] array = {"apple", "banana", "cherry"};
//        Queue<String> queue = new LinkedList<>(Arrays.asList(array));
//
//        System.out.println(queue);

//        String[] keys = {"name", "age", "city"};
//        String[] values = {"Alice", "25", "New York"};
//
//        Map<String, String> map = new HashMap<>();
//        for (int i = 0; i < keys.length; i++) {
//            map.put(keys[i], values[i]);
//        }
//
//        System.out.println(map);



    }

}
