package org.example.Challenges;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: RECURSION ALGORITHMS
 * ============================================================================
 * Topics Covered:
 * 1. Factorial of a Number
 * 2. N-th Fibonacci Number & Sequence
 * 3. Sum of Digits of a Number
 * 4. Power Calculation (Base^Exponent with Fast Exponentiation)
 * 5. Reverse a String using Recursion
 * ============================================================================
 */
public class RecursionChallenges {

    // ========================================================================
    // CHALLENGE 1: Factorial of a Number
    // ========================================================================

    /**
     * Calculates n!
     * Base Cases: 0! = 1, 1! = 1
     * Time Complexity: O(N), Space Complexity: O(N) Call Stack
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // ========================================================================
    // CHALLENGE 2: N-th Fibonacci Number
    // ========================================================================

    /**
     * Calculates the n-th Fibonacci number (0-indexed: 0, 1, 1, 2, 3, 5, 8...)
     * Time Complexity: O(2^N), Space Complexity: O(N)
     */
    public static int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("Index cannot be negative.");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ========================================================================
    // CHALLENGE 3: Sum of Digits
    // ========================================================================

    /**
     * Example: 12345 -> 1 + 2 + 3 + 4 + 5 = 15
     * Time Complexity: O(log10(N)), Space Complexity: O(log10(N))
     */
    public static int sumOfDigits(int n) {
        n = Math.abs(n);
        if (n == 0) return 0;
        return (n % 10) + sumOfDigits(n / 10);
    }

    // ========================================================================
    // CHALLENGE 4: Power of a Number (x^y)
    // ========================================================================

    /**
     * Linear recursion: base * power(base, exponent - 1)
     * Time Complexity: O(exponent)
     */
    public static long power(int base, int exponent) {
        if (exponent < 0) throw new IllegalArgumentException("Exponent must be non-negative");
        if (exponent == 0) return 1;
        return base * power(base, exponent - 1);
    }

    /**
     * Fast exponentiation (Divide and Conquer)
     * Time Complexity: O(log(exponent))
     */
    public static long fastPower(int base, int exponent) {
        if (exponent == 0) return 1;
        long half = fastPower(base, exponent / 2);
        if (exponent % 2 == 0) {
            return half * half;
        } else {
            return base * half * half;
        }
    }

    // ========================================================================
    // CHALLENGE 5: Reverse a String using Recursion
    // ========================================================================

    /**
     * Time Complexity: O(N^2) due to substring creation, Space Complexity: O(N)
     */
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    // ========================================================================
    // MAIN METHOD: Demo & Test Runner for YouTube
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("      JAVA CODING CHALLENGES: RECURSION ALGORITHMS DEMO        ");
        System.out.println("===============================================================\n");

        // 1. Factorial
        System.out.println("--- 1. Factorial ---");
        System.out.println("Factorial(5) = " + factorial(5));
        System.out.println("Factorial(7) = " + factorial(7));
        System.out.println();

        // 2. Fibonacci
        System.out.println("--- 2. Fibonacci ---");
        System.out.print("First 8 Fibonacci numbers: ");
        for (int i = 0; i < 8; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println("\n");

        // 3. Sum of Digits
        System.out.println("--- 3. Sum of Digits ---");
        System.out.println("Sum of digits in 12345: " + sumOfDigits(12345));
        System.out.println("Sum of digits in 987  : " + sumOfDigits(987));
        System.out.println();

        // 4. Power
        System.out.println("--- 4. Power (x^y) ---");
        System.out.println("2^5 (Standard) : " + power(2, 5));
        System.out.println("2^10 (Fast O(log N)): " + fastPower(2, 10));
        System.out.println();

        // 5. Reverse String
        System.out.println("--- 5. Reverse String Recursively ---");
        System.out.println("Reverse of 'Recursion': " + reverseString("Recursion"));
        System.out.println("Reverse of 'Java': " + reverseString("Java"));
        System.out.println();
    }
}
