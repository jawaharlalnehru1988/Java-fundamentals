package org.example.Concepts;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ExceptionsHandlings {

    public static String getNullString() {
        return null;
    }

            private static String staticString = "hari om";

    Optional<String> optional = Optional.of(null);


    public Optional<String> getOptional() {
        return optional;
    }

    String input = null;

    // Validate input

    public static void printMessage(String message){
        try {
            if(message == null){
                throw new IllegalArgumentException("Message cannot be null");
            }
            System.out.println(message);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

//    2. Providing Out-of-Bounds Values
public static void setPercentage(int percentage) {

        try{
            if (percentage < 0 || percentage > 100) {
                throw new IllegalArgumentException("Percentage must be between 0 and 100");
            }
            System.out.println("Percentage set to: " + percentage);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
}

// Number format exception

    public static void setAge(String age) {
        try {
            int parsedAge = Integer.parseInt(age);
            if (parsedAge < 0) {
                System.out.println("Error: Age cannot be negative.");
                return;
            }
            System.out.println("Age set to: " + parsedAge);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid age format. Please enter a valid number." + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Accessing Methods or Properties on a Null Object
//        String str = null;
//
////        System.out.println(str.length()); // Throws Nullpointerexception
//        if (str != null) {
//            System.out.println(str.length());
//        } else {
//            System.out.println("String is null");
//        }

//        2. Array of Objects with Null Elements

//        String[] arr = new String[5];
////        System.out.println(arr[0].length());  // Throws NullPointerException
//
//        arr[0] = "hari";
//
//        if(arr[0] !=null){
//            System.out.println(arr[0].length());
//        }

        //3. Calling Methods on Null Return Values

//        String result = getNullString();
//
//        if(result != null){
//        System.out.println(result.toUpperCase());
//        } else {
//            System.out.println("Result is null");
//        }


// 4. Autoboxing with Null Values

//        Integer value = null;
////        int primitiveValue = value;
//
//        if(value != null){
//            int primitiveValue = value;
//        } else {
//            int primitiveValue = 0;
//        }


// 5. Using Null in Collections
//        HashMap<String, String> map = new HashMap<>();
//        map.put("key", null);
//
////        System.out.println(map.get("key").toUpperCase());
//
//        String value = map.get("key");
//        if(value != null){
//            System.out.println(map.get("key").toUpperCase());
//        } else {
//            System.out.println("the key is null because it does not exist");
//        }

// 6. Chaining Method Calls

//        Person person = null;
////        System.out.println(person.getName().toUpperCase());
//
//        if(person != null && person.getName() != null){
//            System.out.println(person.getName().toUpperCase());
//                    }

// 7. Using Null in Streams

//        Stream<String> stream = Stream.of("One", null, "Three");
////        stream.forEach(s -> System.out.println(s.toUpperCase()));
//
//        stream.filter(Objects::nonNull).forEach(s -> System.out.println(s.toUpperCase()));

//8. Static Fields Initialized to Null

//        System.out.println(staticString.toUpperCase());

//        String input = null;
//
//        // Validate input
//        if (input != null) {
//            try {
//                System.out.println(input.toUpperCase());
//            } catch (Exception e) {
//                System.out.println("An unexpected error occurred: " + e.getMessage());
//            }
//        } else {
//            System.out.println("Input is null, cannot proceed.");
//        }

        //-------------------------------------------------------------
        //-------------------------------------------------------------

        //1. Accessing an Index Greater Than or Equal to Array Length

//        int[] nums = {1, 2, 3};
////        System.out.println(nums[3]);
//
//        if(nums.length > 3 ){
//            System.out.println("element is not valid");
//        } else{
//            System.out.println(nums.length);
//        }

//        int[] arr = {1, 2, 3};
//        int index = 3;
//
//        if (index >= 0 && index < arr.length) {
//            System.out.println("Element at index " + index + ": " + arr[index]);
//        } else {
//            System.out.println("Invalid index: " + index);
//        }

//        int[] arr = {1, 2, 3};
//
//        try {
//            System.out.println("Element at index 3: " + arr[3]); // Throws exception
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Exception caught: " + e.getMessage());
//        }

//        int[] arr = {1, 2, 3};
//        int index = 3;
//
//        try {
//            if (index >= 0 && index < arr.length) {
//                System.out.println("Element at index " + index + ": " + arr[index]);
//            } else {
//                System.out.println("Invalid index: " + index);
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Exception caught: " + e.getMessage());
//        }

        // Negative index
//        int[] arr = {10, 20, 30};
//
//        try {
//            System.out.println(arr[-1]); // Throws ArrayIndexOutOfBoundsException
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Negative index error: " + e.getMessage());
//        }

        //Loop example

//        int[] arr = {1, 2, 3};
//
//        for (int i = 0; i <= arr.length; i++) { // `i <= arr.length` causes exception
//            try {
//                System.out.println("Element at index " + i + ": " + arr[i]);
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("Invalid index: " + i + "  " + e.getMessage());
//            }
//        }

        // ArithmeticException in Java

//        1. Division by Zero
//        int a = 10, b = 0;
//
//        System.out.println(a / b); // Throws ArithmeticException

//        2. Handling ArithmeticException with try-catch

//        int a = 10, b = 0;
//
//        try {
//            int result = a / b; // Throws ArithmeticException
//            System.out.println("Result: " + result);
//        } catch (ArithmeticException e) {
//            System.out.println("Exception caught: " + e.getMessage());
//        }


//        3. Preventing ArithmeticException Using if-else Check

//        int a = 10, b = 0;
//
//        if (b != 0) {
//            int result = a / b;
//            System.out.println("Result: " + result);
//        } else {
//            System.out.println("Cannot divide by zero.");
//        }


        //4. Division in Floating-Point Arithmetic

//        double a = 10.0, b = 0.0;
//
//        System.out.println(a / b); // Prints Infinity
//        System.out.println(-a / b); // Prints -Infinity
//        System.out.println(0.0 / b); // Prints NaN

        //5. Modulus by Zero

//        int a = 10, b = 0;
//
//        try {
//            int result = a % b; // Throws ArithmeticException
//            System.out.println("Result: " + result);
//        } catch (ArithmeticException e) {
//            System.out.println("Exception caught: " + e.getMessage());
//        }

        //6. ArithmeticException in Loops

//        int[] values = {10, 5, 0};
//
//        for (int value : values) {
//            try {
//                int result = 100 / value; // Throws exception for 0
//                System.out.println("Result: " + result);
//            } catch (ArithmeticException e) {
//                System.out.println("Cannot divide by " + value + ": " + e.getMessage());
//            }
//        }

        //7. Custom Message for Division by Zero

//        int a = 10, b = 0;
//
//        try{
//            if(b == 0){
//                throw new ArithmeticException("Division by zero not allowed");
//            } else {
//                int result = a/b;
//                System.out.println("result: " + result);
//            }
//        } catch (ArithmeticException e){
//            System.out.println(e.getMessage());
//        }

//        IllegalArgumentException in Java
//    printMessage("null");
//  Providing Out-of-Bounds Values
//        setPercentage(20);

        //3. Invalid Format for Arguments

        setAge("invalid");

    }


}


class Person {
    private String name;
    public String getName(){
        return name;
    }
}
