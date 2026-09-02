package org.example.Challenges;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: ARRAYS & NUMBERS (DUAL PARADIGMS)
 * ============================================================================
 * Comprehensive collection of array interview problems implemented using:
 *  1. IMPERATIVE APPROACH: Traditional loops, two-pointers, and state mutation.
 *  2. FUNCTIONAL APPROACH: Java 8+ Stream API, declarative pipelines & collectors.
 *
 * Topics Covered:
 *  - Challenge 1: Find Duplicates in an Array
 *  - Challenge 2: Remove Duplicates (Unsorted & Sorted)
 *  - Challenge 3: Filter Even & Odd Numbers (+ Partitioning)
 *  - Challenge 4: Filter Numbers by Threshold / Range
 *  - Challenge 5: Filter Positive & Negative Numbers (+ Partitioning)
 *  - Challenge 6: Find Minimum & Maximum (+ IntSummaryStatistics)
 *  - Challenge 7: Reverse an Array (In-place Two Pointers vs Stream)
 *  - Challenge 8: Sum & Average Calculation
 *  - Challenge 9: Element Search & Condition Matching (AnyMatch / AllMatch)
 * ============================================================================
 */
public class ArrayChallenges {

    // ========================================================================
    // CHALLENGE 1: Find Duplicates in an Array
    // ========================================================================

    /**
     * Imperative Approach (HashSet): Single pass tracking seen elements.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static List<Integer> findDuplicatesWithSet(int[] numbers) {
        if (numbers == null) return Collections.emptyList();
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int num : numbers) {
            // Set.add() returns false if the element was already present
            if (!seen.add(num) && !duplicates.contains(num)) {
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    /**
     * Imperative Approach (Brute Force): Nested loops comparison.
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

    /**
     * Functional Approach (Stream API & groupingBy):
     * Groups elements by frequency and filters those with count > 1.
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

    // ========================================================================
    // CHALLENGE 2: Remove Duplicates from an Array
    // ========================================================================

    /**
     * Imperative Approach 2A (Unsorted Array): Using LinkedHashSet to preserve order.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] removeDuplicatesImperative(int[] numbers) {
        if (numbers == null) return new int[0];
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : numbers) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            result[idx++] = num;
        }
        return result;
    }

    /**
     * Imperative Approach 2B (Sorted Array In-Place): Two Pointers.
     * Modifies the array in-place and returns the count of unique elements.
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

    /**
     * Functional Approach (Stream API distinct):
     * Preserves insertion order and returns a new deduplicated array.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] removeDuplicates(int[] numbers) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).distinct().toArray();
    }

    // ========================================================================
    // CHALLENGE 3: Filter Even and Odd Numbers
    // ========================================================================

    /**
     * Imperative Approach: Filter Even numbers using a classic loop.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] filterEvenNumbersImperative(int[] numbers) {
        if (numbers == null) return new int[0];
        List<Integer> evens = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        return evens.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Functional Approach: Filter Even numbers using Stream API filter.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] filterEvenNumbers(int[] numbers) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n % 2 == 0).toArray();
    }

    /**
     * Imperative Approach: Filter Odd numbers using a classic loop (manual array sizing).
     * Time Complexity: O(N), Space Complexity: O(N)
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

    /**
     * Functional Approach: Filter Odd numbers using Stream API filter.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] filterOddNumbersStream(int[] numbers) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n % 2 != 0).toArray();
    }

    /**
     * Functional Approach (Interview Pro-Tip): Partition array into Evens & Odds in a single pass.
     * Returns a Map where key true -> Even list, key false -> Odd list.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static Map<Boolean, List<Integer>> partitionEvenOddStream(int[] numbers) {
        if (numbers == null) return Collections.emptyMap();
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    // ========================================================================
    // CHALLENGE 4: Filter Numbers by Threshold / Range
    // ========================================================================

    /**
     * Imperative Approach: Filter numbers greater than threshold.
     */
    public static int[] filterGreaterThanImperative(int[] numbers, int threshold) {
        if (numbers == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            if (num > threshold) list.add(num);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Functional Approach: Filter numbers greater than threshold using Streams.
     */
    public static int[] filterGreaterThan(int[] numbers, int threshold) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n > threshold).toArray();
    }

    /**
     * Imperative Approach: Filter numbers within exclusive range (min < x < max).
     */
    public static int[] filterInRangeImperative(int[] numbers, int min, int max) {
        if (numbers == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            if (num > min && num < max) list.add(num);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Functional Approach: Filter numbers within exclusive range (min < x < max).
     */
    public static int[] filterInRange(int[] numbers, int min, int max) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n > min && n < max).toArray();
    }

    // ========================================================================
    // CHALLENGE 5: Filter Positive and Negative Numbers
    // ========================================================================

    /**
     * Imperative Approach: Filter positive numbers (n > 0).
     */
    public static int[] filterPositiveNumbersImperative(int[] numbers) {
        if (numbers == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            if (num > 0) list.add(num);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Functional Approach: Filter positive numbers (n > 0).
     */
    public static int[] filterPositiveNumbers(int[] numbers) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n > 0).toArray();
    }

    /**
     * Imperative Approach: Filter negative numbers (n < 0).
     */
    public static int[] filterNegativeNumbersImperative(int[] numbers) {
        if (numbers == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            if (num < 0) list.add(num);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Functional Approach: Filter negative numbers (n < 0).
     */
    public static int[] filterNegativeNumbersStream(int[] numbers) {
        if (numbers == null) return new int[0];
        return Arrays.stream(numbers).filter(n -> n < 0).toArray();
    }

    /**
     * Functional Approach (Interview Pro-Tip): Partition into Positive (true) and Non-Positive (false).
     */
    public static Map<Boolean, List<Integer>> partitionPositiveNegativeStream(int[] numbers) {
        if (numbers == null) return Collections.emptyMap();
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.partitioningBy(n -> n > 0));
    }

    // ========================================================================
    // CHALLENGE 6: Find Minimum and Maximum in Array
    // ========================================================================

    /**
     * Imperative Approach: Find min and max in a single pass O(N).
     * Time Complexity: O(N), Space Complexity: O(1)
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

    /**
     * Functional Approach: Find Minimum using IntStream.min().
     */
    public static int findMinStream(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null");
        }
        return Arrays.stream(numbers).min().getAsInt();
    }

    /**
     * Functional Approach: Find Maximum using IntStream.max().
     */
    public static int findMaxStream(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null");
        }
        return Arrays.stream(numbers).max().getAsInt();
    }

    /**
     * Functional Approach (Interview Pro-Tip): IntSummaryStatistics in a single stream pass!
     * Provides min, max, count, sum, and average in O(N).
     */
    public static IntSummaryStatistics findSummaryStatisticsStream(int[] numbers) {
        if (numbers == null) return new IntSummaryStatistics();
        return Arrays.stream(numbers).summaryStatistics();
    }

    // ========================================================================
    // CHALLENGE 7: Reverse an Array
    // ========================================================================

    /**
     * Imperative Approach: In-place array reversal using Two Pointers.
     * Modifies the original array.
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

    /**
     * Functional Approach: Pure functional reversal (returns a new reversed array).
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static int[] reverseArrayStream(int[] numbers) {
        if (numbers == null) return new int[0];
        int len = numbers.length;
        return IntStream.range(0, len)
                .map(i -> numbers[len - 1 - i])
                .toArray();
    }

    // ========================================================================
    // CHALLENGE 8: Sum and Average of Array Elements
    // ========================================================================

    /**
     * Imperative Approach: Calculate Sum using loop accumulator.
     */
    public static int calculateSumImperative(int[] numbers) {
        if (numbers == null) return 0;
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }

    /**
     * Functional Approach: Calculate Sum using IntStream.sum().
     */
    public static int calculateSumStream(int[] numbers) {
        if (numbers == null) return 0;
        return Arrays.stream(numbers).sum();
    }

    /**
     * Imperative Approach: Calculate Average.
     */
    public static double calculateAverageImperative(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0.0;
        return (double) calculateSumImperative(numbers) / numbers.length;
    }

    /**
     * Functional Approach: Calculate Average using IntStream.average().
     */
    public static OptionalDouble calculateAverageStream(int[] numbers) {
        if (numbers == null) return OptionalDouble.empty();
        return Arrays.stream(numbers).average();
    }

    // ========================================================================
    // CHALLENGE 9: Element Search & Predicate Matching
    // ========================================================================

    /**
     * Imperative Approach: Check if array contains a specific target value (Linear Search).
     */
    public static boolean containsElementImperative(int[] numbers, int target) {
        if (numbers == null) return false;
        for (int num : numbers) {
            if (num == target) return true;
        }
        return false;
    }

    /**
     * Functional Approach: Check if array contains target using anyMatch.
     */
    public static boolean containsElementStream(int[] numbers, int target) {
        if (numbers == null) return false;
        return Arrays.stream(numbers).anyMatch(n -> n == target);
    }

    /**
     * Functional Approach: Check if all elements satisfy a condition (e.g., all positive).
     */
    public static boolean areAllPositiveStream(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        return Arrays.stream(numbers).allMatch(n -> n > 0);
    }

    // ========================================================================
    // MAIN METHOD: Demo & Test Runner for Walkthroughs & Interviews
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("   JAVA CODING CHALLENGES: ARRAYS & NUMBERS (DUAL PARADIGMS)  ");
        System.out.println("===============================================================\n");

        int[] sampleArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3, 1, 4};

        // --------------------------------------------------------------------
        // 1. Find Duplicates
        // --------------------------------------------------------------------
        System.out.println("--- 1. Find Duplicates in Array ---");
        System.out.println("Input Array: " + Arrays.toString(sampleArray));
        System.out.println("Imperative (HashSet) : " + findDuplicatesWithSet(sampleArray));
        System.out.println("Imperative (Loops)   : " + findDuplicatesBruteForce(sampleArray));
        System.out.println("Functional (Stream)  : " + findDuplicatesWithStream(sampleArray));
        System.out.println();

        // --------------------------------------------------------------------
        // 2. Remove Duplicates
        // --------------------------------------------------------------------
        System.out.println("--- 2. Remove Duplicates ---");
        System.out.println("Imperative (LinkedHashSet): " + Arrays.toString(removeDuplicatesImperative(sampleArray)));
        System.out.println("Functional (Stream distinct): " + Arrays.toString(removeDuplicates(sampleArray)));
        int[] sortedArr = {1, 1, 2, 2, 3, 4, 4, 5};
        int uniqueCount = removeDuplicatesSortedInPlace(sortedArr);
        System.out.println("In-place Two Pointers (Sorted Array): " + uniqueCount + " unique elements -> "
                + Arrays.toString(Arrays.copyOf(sortedArr, uniqueCount)));
        System.out.println();

        // --------------------------------------------------------------------
        // 3. Filter Even and Odd Numbers
        // --------------------------------------------------------------------
        System.out.println("--- 3. Filter Even and Odd Numbers ---");
        System.out.println("Even (Imperative Loop) : " + Arrays.toString(filterEvenNumbersImperative(sampleArray)));
        System.out.println("Even (Stream Filter)   : " + Arrays.toString(filterEvenNumbers(sampleArray)));
        System.out.println("Odd  (Imperative Loop) : " + Arrays.toString(filterOddNumbers(sampleArray)));
        System.out.println("Odd  (Stream Filter)   : " + Arrays.toString(filterOddNumbersStream(sampleArray)));
        System.out.println("Partitioning (Evens=true, Odds=false): " + partitionEvenOddStream(sampleArray));
        System.out.println();

        // --------------------------------------------------------------------
        // 4. Filter by Threshold & Range
        // --------------------------------------------------------------------
        System.out.println("--- 4. Filter by Threshold & Range ---");
        System.out.println("Numbers > 5 (Imperative): " + Arrays.toString(filterGreaterThanImperative(sampleArray, 5)));
        System.out.println("Numbers > 5 (Stream)    : " + Arrays.toString(filterGreaterThan(sampleArray, 5)));
        System.out.println("Numbers in (3, 8) (Imperative): " + Arrays.toString(filterInRangeImperative(sampleArray, 3, 8)));
        System.out.println("Numbers in (3, 8) (Stream)    : " + Arrays.toString(filterInRange(sampleArray, 3, 8)));
        System.out.println();

        // --------------------------------------------------------------------
        // 5. Filter Positive / Negative
        // --------------------------------------------------------------------
        System.out.println("--- 5. Filter Positive / Negative Numbers ---");
        int[] mixedNumbers = {-5, -2, 0, 3, 7, -1, 10};
        System.out.println("Mixed Input              : " + Arrays.toString(mixedNumbers));
        System.out.println("Positive (Imperative Loop): " + Arrays.toString(filterPositiveNumbersImperative(mixedNumbers)));
        System.out.println("Positive (Stream Filter) : " + Arrays.toString(filterPositiveNumbers(mixedNumbers)));
        System.out.println("Negative (Imperative Loop): " + Arrays.toString(filterNegativeNumbersImperative(mixedNumbers)));
        System.out.println("Negative (Stream Filter) : " + Arrays.toString(filterNegativeNumbersStream(mixedNumbers)));
        System.out.println("Partitioning (Positives): " + partitionPositiveNegativeStream(mixedNumbers));
        System.out.println();

        // --------------------------------------------------------------------
        // 6. Min and Max (+ SummaryStatistics)
        // --------------------------------------------------------------------
        System.out.println("--- 6. Find Min & Max ---");
        int[] minMax = findMinMax(sampleArray);
        System.out.println("Single-Pass Loop: Min = " + minMax[0] + ", Max = " + minMax[1]);
        System.out.println("Stream Min      : " + findMinStream(sampleArray));
        System.out.println("Stream Max      : " + findMaxStream(sampleArray));
        System.out.println("IntSummaryStatistics: " + findSummaryStatisticsStream(sampleArray));
        System.out.println();

        // --------------------------------------------------------------------
        // 7. Reverse Array
        // --------------------------------------------------------------------
        System.out.println("--- 7. Reverse Array ---");
        int[] toReverse = {10, 20, 30, 40, 50};
        System.out.println("Original Array: " + Arrays.toString(toReverse));
        int[] streamReversed = reverseArrayStream(toReverse);
        System.out.println("Stream Reversed (Pure Functional): " + Arrays.toString(streamReversed));
        reverseArrayInPlace(toReverse);
        System.out.println("In-Place Reversed (Two Pointers) : " + Arrays.toString(toReverse));
        System.out.println();

        // --------------------------------------------------------------------
        // 8. Sum & Average
        // --------------------------------------------------------------------
        System.out.println("--- 8. Sum & Average Calculation ---");
        System.out.println("Sum (Imperative) : " + calculateSumImperative(sampleArray));
        System.out.println("Sum (Stream)     : " + calculateSumStream(sampleArray));
        System.out.println("Avg (Imperative) : " + calculateAverageImperative(sampleArray));
        System.out.println("Avg (Stream)     : " + calculateAverageStream(sampleArray).orElse(0.0));
        System.out.println();

        // --------------------------------------------------------------------
        // 9. Element Search & Predicate Matching
        // --------------------------------------------------------------------
        System.out.println("--- 9. Element Search & Matching ---");
        System.out.println("Contains 7 (Imperative): " + containsElementImperative(sampleArray, 7));
        System.out.println("Contains 7 (Stream)    : " + containsElementStream(sampleArray, 7));
        System.out.println("All Positive (Stream)  : " + areAllPositiveStream(sampleArray));
        System.out.println("All Positive on Mixed? : " + areAllPositiveStream(mixedNumbers));
        System.out.println("\n===============================================================");
    }
}

