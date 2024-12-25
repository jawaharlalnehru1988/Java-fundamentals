package org.example.Collections;

import java.util.TreeMap;

public class TreeMapping {

    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Add elements
        treeMap.put(1, "Java");
        treeMap.put(2, "Python");
        treeMap.put(3, "JavaScript");
        treeMap.put(4, "Ruby");
        treeMap.put(5, "C++");

        // Print the TreeMap
        System.out.println(treeMap);
    }
}
