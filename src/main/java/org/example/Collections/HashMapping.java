package org.example.Collections;

import org.example.OOP.Contructor.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

public class HashMapping {

    public static void main(String[] args){

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        map.put("Orange", 40);

        //check whether the key is present in the map
//        Boolean value = map.containsKey("Cherry");
//        System.out.println(map.containsKey("Cherry"));
//        System.out.println(value);
//
//        //check whether the value is present in the map
//        Boolean num = map.containsValue(10);
//        System.out.println(num);

//        //remove the key from the map
//        map.remove("Apple");
//
//        //remove the key from the map if the key is present
//        map.remove("Banana", 60);

//        //replace the value of the key
//        map.replace("Banana", 50);
//
//        //replace the value of the key if the key is present
//        map.replace("Banana", 50, 60);

//              map.clear();
//        System.out.println(map);
//
//        // to know the size of the map
//        System.out.println("size: " + map.size());

//        // to print the map using forEach
//        map.forEach((key, value) -> {
//            System.out.println(key + ": " + value);
//        });

//          Boolean isValuesExist =  map.isEmpty();
//            System.out.println(isValuesExist);

//        // to get the value of the key
//        System.out.println("Value for apple: " + map.get("Apple"));
//        System.out.println("Value to Banana: " + map.get("Banana"));

        // to get all the keys
//        Set<String> keys = map.keySet();
////
//        System.out.println("keys " + keys);

//        for(String key : keys){
//            System.out.println(key + ": " + map.get(key));
//        }


        // to get all the values
//        Collection<Integer> values = map.values();
//
//        System.out.println("values " + values);
//
//        for(Integer value : values){
//            System.out.println(value);
//        }


        // to get all the entries
//        Set<Map.Entry<String, Integer>> entries = map.entrySet();
////
//        System.out.println("entries " + entries);
////
//        for(Map.Entry<String, Integer> entry : entries){
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }

        // Another map to copy into the existing map
//        HashMap<String, Integer> anotherMap = new HashMap<>();
//        anotherMap.put("Grapes", 50);
//        anotherMap.put("Pineapple", 60);
//
//        anotherMap.putAll(map);
//
//        System.out.println(anotherMap);


//        map.replaceAll((key, value) -> value * 2);
//
//        System.out.println(map);

        // replace the value of the key if the key is present
//        map.replaceAll((key, value) -> {
//            if(key.equals("Banana")){
//                return value * 2;
//            }
//            return value;
//        });
//
//        System.out.println(map);

        // clone the map

//        HashMap<String, Integer> clonedMap = (HashMap<String, Integer>) map.clone();
//
//
//        //Modifying the cloned map
//
//        clonedMap.put("Pineapple", 70);
//
//        System.out.println(clonedMap);
//        System.out.println(map);


//        map.compute("Banana", (key, value) -> value * 2);
//        System.out.println(map);

        // HashMap with Integer keys and String values
//        HashMap<Integer, String> map1 = new HashMap<>();
//        map1.put(1, "Apple");
//        map1.put(2, "Banana");
//        map1.put(3, "Cherry");
//        map1.put(4, "Orange");

//        System.out.println(map1);
//        System.out.println(map1.get(1));
//        System.out.println(map1.values());
//        System.out.println(map1.keySet());
//        System.out.println(map1.entrySet());
//        System.out.println(map1.containsKey(6));
//        System.out.println(map1.containsValue("Banana"));
//        String fruit = map1.remove(1);
//        System.out.println(fruit);

        // HashMap with String keys and String values
//        HashMap<String, String> map2 = new HashMap<>();
//
//        map2.put("A", "Apple");
//        map2.put("B", "Banana");
//        map2.put("C", "Cherry");
//        map2.put("O", "Orange");

//        map2.replaceAll((key, value) -> value + " is a fruit");
//        System.out.println(map2);
//        map2.forEach((key, value) -> System.out.println(key + ": " + value));

//        map2.replace("B", "Banana is a fruit");
//        System.out.println(map2);


//        @SuppressWarnings("unchecked")
//                HashMap<String, String> clonedMap = (HashMap<String, String>) map2.clone();
//        clonedMap.put("P", "Pineapple");
//        System.out.println(clonedMap);

//        map2.replaceAll((key, value) -> {
//            if (key.equals("B")) {
//                return value + " is a fruit";
//            }
//            return value;
//        });
//
//        System.out.println(map2);

        // Hashmap with Student object as key and String as value
//        HashMap<Student, String> map3 = new HashMap<>();
//
//        Student student1 = new Student("Ram", 8);
//        Student student2 = new Student("Shyam", 9);
//        Student student3 = new Student("Gita", 7);
//        Student student4 = new Student("Sita", 6);
//
//        map3.put(student1, "A");
//        map3.put(student2, "B");
//        map3.put(student3, "C");
//        map3.put(student4, "D");
//
//        System.out.println(map3);
//
        //Hashmap with Integer as key and Student object as value

//        HashMap<Integer, Student> map4 = new HashMap<>();
//
//        Student student1 = new Student("Ram", 8);
//        Student student2 = new Student("Shyam", 9);
//        Student student3 = new Student("Gita", 7);
//        Student student4 = new Student("Sita", 6);
//
//        map4.put(1, student1);
//        map4.put(2, student2);
//        map4.put(3, student3);
//        map4.put(4, student4);
//
//        System.out.println(map4);

        // Hashmap with Mixed keys and values

//        HashMap<Object, Object> map5 = new HashMap<>();
//
//        map5.put(1, "Apple");
//        map5.put("B", 20);
//        map5.put(2.3, "Cherry");
//        map5.put("Ddll", 40);
//
//        System.out.println(map5);


     // Hashmap with Enum as key and value

//        HashMap<Day, String> map6 = new HashMap<>();
//
//        map6.put(Day.MONDAY, "Monday");
//        map6.put(Day.TUESDAY, "Tuesday");
//        map6.put(Day.WEDNESDAY, "Wednesday");
//        map6.put(Day.THURSDAY, "Thursday");
//        map6.put(Day.FRIDAY, "Friday");
//        map6.put(Day.SATURDAY, "Saturday");
//        map6.put(Day.SUNDAY, "Sunday");
//
//        System.out.println(map6);


        // Hashmap with null key and value

//        HashMap<String, String> map7 = new HashMap<>();
//
//        map7.put(null, "Apple");
//        map7.put("B", null);
//        map7.put(null, null);
//
//        System.out.println(map7);




    }
}
