package org.example.Challenges;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: ARRAYS & NUMBERS
 * ============================================================================
 * Topics Covered:
 * 1. Find Duplicate Elements (Brute Force, HashSet, Stream Grouping)
 * 2. Remove Duplicates from Array (Two-Pointer & Stream distinct)
 * 3. Filter Even & Odd Numbers
 * 4. Filter Numbers by Threshold / Range
 * 5. Separate Positive & Negative Numbers
 * 6. Find Minimum & Maximum in Array
 * 7. Reverse an Array in Place (Two Pointers)
 * ============================================================================
 */
public class ArrayChallenges {

    // ========================================================================
    // CHALLENGE 1: Find Duplicates in an Array
    // ========================================================================

    /**
     * Approach 1A: Using HashSet (Recommended)
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static List<Integer> findDuplicatesWithSet(int[] numbers) {
        if (numbers == null) return Collections.emptyList();
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : numbers) {
            if (!seen.add(num) && !duplicates.contains(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    /**
     * Approach 1B: Using Java 8 Streams & groupingBy
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static List<Integer> findDuplicatesWithStream(int[] numbers) {
        if (numbers == null) return Collections.emptyList();
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Approach 1C: Nested Loops / Brute Force (For conceptual explanation)
     * Time Complexity: O(N^2), Space Complexity: O(1) auxiliary
     */
    public static List<Integer> findDuplicatesBruteForce(int[] numbers) {
        if (numbers == null) return Collections.emptyList();
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j] && !duplicates.contains(numbers[i])) {
                    duplicates.add(numbers[i]);
                    break;
                }
            }
        }
        return duplicates;
    }

    // ========================================================================
    // CHALLENGE 2: Remove Duplicates from Array
    // ========================================================================

    /**
     * Approach 2A: Using Java 8 Stream distinct()
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] removeDuplicates(int[] numbers) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).distinct().toArray();
    }

    /**
     * Approach 2B: In-place two-pointer removal (on sorted array)
     * Returns the length of unique elements.
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static int removeDuplicatesSortedInPlace(int[] sortedNums) {
        if (sortedNums == null || sortedNums.length == 0) return 0;
        int uniqueIndex = 0;
        for (int i = 1; i < sortedNums.length; i++) {
            if (sortedNums[i] != sortedNums[uniqueIndex]) {
                uniqueIndex++;
                sortedNums[uniqueIndex] = sortedNums[i];
            }
        }
        return uniqueIndex + 1;
    }

    // ========================================================================
    // CHALLENGE 3: Filter Even and Odd Numbers
    // ========================================================================

    /**
     * Filter only even numbers using Streams
     */
    public static int[] filterEvenNumbers(int[] numbers) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n % 2 == 0).toArray();
    }

    /**
     * Filter only odd numbers using Classic Loop
     */
    public static int[] filterOddNumbers(int[] numbers) {
        if (numbers == null) return new int[0];
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0) count++;
        }
        int[] result = new int[count];
        int idx = 0;
        for (int num : numbers) {
            if (num % 2 != 0) result[idx++] = num;
        }
        return result;
    }

    // ========================================================================
    // CHALLENGE 4: Filter Numbers by Threshold / Range
    // ========================================================================

    /**
     * Filter numbers strictly greater than a threshold value
     */
    public static int[] filterGreaterThan(int[] numbers, int threshold) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n > threshold).toArray();
    }

    /**
     * Filter numbers within an exclusive range (min < x < max)
     */
    public static int[] filterInRange(int[] numbers, int min, int max) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n > min && n < max).toArray();
    }

    // ========================================================================
    // CHALLENGE 5: Filter Positive and Negative Numbers
    // ========================================================================

    /**
     * Filter only strictly positive numbers (n > 0)
     */
    public static int[] filterPositiveNumbers(int[] numbers) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n > 0).toArray();
    }

    // ========================================================================
    // CHALLENGE 6: Find Minimum and Maximum in Array
    // ========================================================================

    /**
     * Find min and max in a single pass O(N)
     */
    public static int[] findMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null");
        }
        int min = numbers[0];
        int max = numbers[0];
        for (int num : numbers) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return new int[]{min, max}; // [min, max]
    }

    // ========================================================================
    // CHALLENGE 7: Reverse an Array In-Place
    // ========================================================================

    /**
     * In-place array reversal using Two Pointers
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static void reverseArrayInPlace(int[] numbers) {
        if (numbers == null) return;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
    }

    // ========================================================================
    // MAIN METHOD: Demo & Test Runner for YouTube
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("       JAVA CODING CHALLENGES: ARRAYS & NUMBERS DEMO           ");
        System.out.println("===============================================================\n");

        int[] sampleArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 1, 4};

        // 1. Find Duplicates
        System.out.println("--- 1. Find Duplicates in Array ---");
        System.out.println("Input Array: " + Arrays.toString(sampleArray));
        System.out.println("Duplicates (HashSet) : " + findDuplicatesWithSet(sampleArray));
        System.out.println("Duplicates (Stream)  : " + findDuplicatesWithStream(sampleArray));
        System.out.println("Duplicates (Loops)   : " + findDuplicatesBruteForce(sampleArray));
        System.out.println();

        // 2. Remove Duplicates
        System.out.println("--- 2. Remove Duplicates ---");
        System.out.println("Distinct Elements (Stream): " + Arrays.toString(removeDuplicates(sampleArray)));
        int[] sortedArr = {1, 1, 2, 2, 3, 4, 4, 5};
        int uniqueCount = removeDuplicatesSortedInPlace(sortedArr);
        System.out.println("In-place Unique Count on Sorted Array: " + uniqueCount);
        System.out.println("Sorted Array after in-place: " + Arrays.toString(Arrays.copyOf(sortedArr, uniqueCount)));
        System.out.println();

        // 3. Filter Even and Odd
        System.out.println("--- 3. Filter Even and Odd Numbers ---");
        System.out.println("Even Numbers: " + Arrays.toString(filterEvenNumbers(sampleArray)));
        System.out.println("Odd Numbers : " + Arrays.toString(filterOddNumbers(sampleArray)));
        System.out.println();

        // 4. Filter by Threshold & Range
        System.out.println("--- 4. Filter by Threshold & Range ---");
        System.out.println("Numbers > 5         : " + Arrays.toString(filterGreaterThan(sampleArray, 5)));
        System.out.println("Numbers in (3, 8)   : " + Arrays.toString(filterInRange(sampleArray, 3, 8)));
        System.out.println();

        // 5. Filter Positive / Negative
        System.out.println("--- 5. Filter Positive Numbers ---");
        int[] mixedNumbers = {-5, -2, 0, 3, 7, -1, 10};
        System.out.println("Mixed Input     : " + Arrays.toString(mixedNumbers));
        System.out.println("Positive Numbers: " + Arrays.toString(filterPositiveNumbers(mixedNumbers)));
        System.out.println();

        // 6. Min and Max
        System.out.println("--- 6. Find Min & Max ---");
        int[] minMax = findMinMax(sampleArray);
        System.out.println("Min: " + minMax[0] + ", Max: " + minMax[1]);
        System.out.println();

        // 7. Reverse Array In-Place
        System.out.println("--- 7. Reverse Array In-Place ---");
        int[] toReverse = {10, 20, 30, 40, 50};
        System.out.println("Before Reverse: " + Arrays.toString(toReverse));
        reverseArrayInPlace(toReverse);
        System.out.println("After Reverse : " + Arrays.toString(toReverse));
        System.out.println();
    }
}
