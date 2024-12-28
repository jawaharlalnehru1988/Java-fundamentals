package org.example.Collections;

import java.util.*;

public class CollectionsToCollectionsConversions {
    public static void main(String[] args) {
        // Convert List to set

//        List<String> list = List.of("apple", "banana", "cat", "dog");
//        Set<String> set = new HashSet<>(list);
//        System.out.println(set);

        // Convert List to Treeset

//        List<String> list1 = List.of("apple", "banana", "cat", "dog");
//        Set<String> set = new TreeSet<>(list1);
//        System.out.println(set);

        // Convert Set to List

//        Set<String> set = Set.of("apple", "banana", "cat", "dog");
//        List<String> list = List.copyOf(set);
//        List<String> list = new ArrayList<>(set);
//
//        System.out.println(list);

        // Convert Set to List

//        Set<String> set = Set.of("apple", "banana", "cat", "dog");
//        List<String> list = new LinkedList<>(set);
//        System.out.println(list);

        // Convert Map to List

//        Map<Integer, String> map = Map.of(1, "apple", 2, "banana", 3, "cat", 4, "dog");
//        List<String> valueList = new ArrayList<>(map.values());
//        System.out.println(valueList);
//        List<Integer> keyList = new ArrayList<>(map.keySet());
//        System.out.println(keyList);


        // Convert Map to Set

        Map<Integer, String> map = Map.of(1, "apple", 2, "banana", 3, "cat", 4, "dog");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Set<Integer> keySet = map.keySet();
        Set<String> valueSet = new HashSet<>(map.values());
        System.out.println(entrySet);
        System.out.println(keySet);
        System.out.println(valueSet);


    }
}
