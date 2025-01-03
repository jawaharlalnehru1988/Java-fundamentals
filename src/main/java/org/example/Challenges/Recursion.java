package org.example.Challenges;

public class Recursion {

//    // to find factorial of a number
//    public static int factorial(int n){
//        if(n == 0 || n == 1) return 1;
//        return n * factorial(n - 1);
//    }
//
//    // to find fibonacci of a number
//    public static int fibonacci(int n){
//        if(n == 0) return 0;
//        if(n == 1) return 1;
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }

    // to find sum of the digits of a given number

//    public static int sumOfDigits(int n){
//        if(n == 0) return 0;
//        return n % 10 + sumOfDigits(n / 10);
//    }

    // reverse a string using recursion
//    public static String reverseString(String str){
//        if(str.isEmpty()) return str;
//        return reverseString(str.substring(1)) + str.charAt(0);
//    }

    // to find the power of a number
    public static int power(int base, int exponent){
        if(exponent == 0) return 1;
        return base * power(base, exponent - 1);
    }

    public static void main(String[] args) {

//        System.out.println(factorial(5));
//        System.out.println(fibonacci(5));
//        System.out.println(sumOfDigits(12345));
//        System.out.println(reverseString("Hello World"));
        System.out.println(power(2, 3));


    }
}
