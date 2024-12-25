package org.example.Collections;

import java.util.LinkedList;

public class LinkedListObj {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Add elements
        linkedList.add("Java");
        linkedList.add("Python");
        linkedList.add("JavaScript");
        linkedList.add("Ruby");

        // Print the LinkedList
        System.out.println(linkedList);

        // Add elements at the beginning
        linkedList.addFirst("C++");
        linkedList.addFirst("C");

        // Print the LinkedList
        System.out.println(linkedList);

        // Add elements at the end
        linkedList.addLast("C#");
        linkedList.addLast("Swift");

        // Print the LinkedList
        System.out.println(linkedList);

        // Remove elements
        linkedList.remove("C");
        linkedList.remove("C++");

        // Print the LinkedList
        System.out.println(linkedList);

        // Remove elements at the beginning
        linkedList.removeFirst();
        linkedList.removeFirst();

        // Print the LinkedList
        System.out.println(linkedList);

        // Remove elements at the end
        linkedList.removeLast();
        linkedList.removeLast();

        // Print the LinkedList
        System.out.println(linkedList);

        // Get the first element
        System.out.println(linkedList.getFirst());

        // Get the last element
        System.out.println(linkedList.getLast());

        // Get the element at index 1
        System.out.println(linkedList.get(1));

        // Set the element at index 1
        linkedList.set(1, "Kotlin");

        // Print the LinkedList
        System.out.println(linkedList);

        // Check if the element is present
        System.out.println(linkedList.contains("Java"));

        // Check if the LinkedList is empty
        System.out.println(linkedList.isEmpty());

        // Get the size of the LinkedList
        System.out.println(linkedList.size());

        // Clear the LinkedList
        linkedList.clear();

        // Print the LinkedList
        System.out.println(linkedList);
    }
}
