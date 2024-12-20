package org.example.Challenges;

public class StringsMethods {
    public static void main(String[] args) {
        String name = "John Doe";
        System.out.println(name.length());
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());
        System.out.println(name.charAt(0));
        System.out.println(name.indexOf("Doe"));
        System.out.println(name.contains("Doe"));
        System.out.println(name.equals("John Doe"));
        System.out.println(name.equalsIgnoreCase("john doe"));
        System.out.println(name.replace("John", "Jane"));
        System.out.println(name.substring(0, 4));
        System.out.println(name.trim());

    }
}
