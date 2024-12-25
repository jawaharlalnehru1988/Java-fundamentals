package org.example.Collections;

import java.util.TreeSet;

public class TreeSetting {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<String> treeSet = new TreeSet<>();

        // Add elements
        treeSet.add("Java");
        treeSet.add("Python");
        treeSet.add("JavaScript");
        treeSet.add("Ruby");
        treeSet.add("Java");

        // Print the TreeSet
        System.out.println(treeSet);

        // Remove elements
        treeSet.remove("JavaScript");
        System.out.println(treeSet);

        // Get the first element
        System.out.println(treeSet.first());

        // Get the last element
        System.out.println(treeSet.last());

        // Get the element less than "JavaScript"
        System.out.println(treeSet.lower("JavaScript"));

        // Get the element greater than "JavaScript"
        System.out.println(treeSet.higher("JavaScript"));

        // Get the element less than or equal to "JavaScript"
        System.out.println(treeSet.floor("JavaScript"));

        // Get the element greater than or equal to "JavaScript"
        System.out.println(treeSet.ceiling("JavaScript"));
    }
}
