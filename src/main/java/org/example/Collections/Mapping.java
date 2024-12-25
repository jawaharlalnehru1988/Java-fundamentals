package org.example.Collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapping {

    public static void main(String[] args){

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Cherry", 30);
        map.put("Orange", 40);

        //check whether the key is present in the map
//        Boolean value = map.containsKey("Cherry");
////        System.out.println(map.containsKey("Cherry"));
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
//
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
//
//        System.out.println("entries " + entries);
//
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


        map.compute("Banana", (key, value) -> value * 2);

    }
}
