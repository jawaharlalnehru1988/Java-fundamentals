package org.example.Challenges;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: JAVA 8+ STREAMS & FILTERING
 * ============================================================================
 * Topics Covered:
 * 1. Filter Strings by Length & Length Range
 * 2. Filter / Clean Null and Empty Strings (Objects::nonNull, !isBlank)
 * 3. Case-Insensitive String Filter / Search
 * 4. Transform / Map Array Elements (To Uppercase, Add Suffix)
 * 5. Dynamic Filtering with Custom Predicates & Predicate Chaining (.and(), .or())
 * 6. Stream Mutability Caveat: Stream.toList() vs Collectors.toList()
 * ============================================================================
 */
public class StreamAndFilterChallenges {

    // ========================================================================
    // CHALLENGE 1: Filter Strings by Length Range
    // ========================================================================

    /**
     * Filters strings having length strictly between minLen and maxLen.
     */
    public static List<String> filterByLengthRange(String[] arr, int minLen, int maxLen) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> s.length() > minLen && s.length() < maxLen)
                .collect(Collectors.toList());
    }

    // ========================================================================
    // CHALLENGE 2: Filter and Remove Null and Empty Strings
    // ========================================================================

    /**
     * Cleans an array by removing null, empty, and whitespace-only strings.
     */
    public static List<String> cleanNullAndEmptyStrings(String[] arr) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> !s.trim().isEmpty())
                .collect(Collectors.toList());
    }

    // ========================================================================
    // CHALLENGE 3: Case-Insensitive Filtering
    // ========================================================================

    /**
     * Finds all strings matching the target string (ignoring case).
     */
    public static List<String> filterIgnoreCase(String[] arr, String target) {
        if (arr == null || target == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> s.equalsIgnoreCase(target))
                .collect(Collectors.toList());
    }

    // ========================================================================
    // CHALLENGE 4: Transform / Map Elements (Uppercase & Suffix)
    // ========================================================================

    /**
     * Converts every string in the array to uppercase.
     */
    public static List<String> convertToUpperCase(String[] arr) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /**
     * Appends a suffix to every element.
     */
    public static List<String> appendSuffix(String[] arr, String suffix) {
        if (arr == null) return Collections.emptyList();
        String safeSuffix = (suffix != null) ? suffix : "";
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .map(s -> s + safeSuffix)
                .collect(Collectors.toList());
    }

    // ========================================================================
    // CHALLENGE 5: Custom Predicates & Predicate Chaining
    // ========================================================================

    /**
     * Filters strings based on an arbitrary Predicate<String>
     */
    public static List<String> filterWithPredicate(String[] arr, Predicate<String> condition) {
        if (arr == null || condition == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(condition)
                .collect(Collectors.toList());
    }

    /**
     * Demonstrates Predicate Chaining (.and(), .or(), .negate())
     */
    public static List<String> filterWithChainedPredicate(String[] arr) {
        if (arr == null) return Collections.emptyList();

        Predicate<String> startsWithA = s -> s.startsWith("A") || s.startsWith("a");
        Predicate<String> lengthGreaterThan4 = s -> s.length() > 4;
        Predicate<String> doesNotContainSpaces = s -> !s.contains(" ");

        // Chaining: Starts with 'A' AND Length > 4 AND No spaces
        Predicate<String> combined = startsWithA.and(lengthGreaterThan4).and(doesNotContainSpaces);

        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(combined)
                .collect(Collectors.toList());
    }

    // ========================================================================
    // CHALLENGE 6: Java 16+ Stream.toList() vs Collectors.toList() Mutability
    // ========================================================================

    /**
     * Demonstrates the difference between unmodifiable list (Stream.toList())
     * and mutable list (Collectors.toList())
     */
    public static void demonstrateListMutability(String[] arr) {
        System.out.println("--- Stream Mutability Caveat ---");

        // 1. Collectors.toList() -> MUTABLE list (can add/remove)
        List<String> mutableList = Arrays.stream(arr).collect(Collectors.toList());
        mutableList.add("NewFruit (Collectors)");
        System.out.println("Collectors.toList() after addition: " + mutableList);

        // 2. Stream.toList() -> UNMODIFIABLE list (Java 16+)
        List<String> unmodifiableList = Arrays.stream(arr).toList();
        try {
            unmodifiableList.add("NewFruit (Stream.toList)");
        } catch (UnsupportedOperationException e) {
            System.out.println("Stream.toList() threw expected: UnsupportedOperationException (List is unmodifiable)");
        }
    }

    // ========================================================================
    // MAIN METHOD: Demo & Test Runner for YouTube
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("     JAVA CODING CHALLENGES: STREAMS & FILTERING DEMO          ");
        System.out.println("===============================================================\n");

        String[] fruits = {"Apple", "Banana", "pomegranate", "orange", "grape", "cherry", "fig"};
        System.out.println("Sample Fruits: " + Arrays.toString(fruits) + "\n");

        // 1. Length Range
        System.out.println("--- 1. Filter by Length Range (3 < len < 7) ---");
        System.out.println("Result: " + filterByLengthRange(fruits, 3, 7));
        System.out.println();

        // 2. Remove Null & Empty
        System.out.println("--- 2. Clean Null and Empty Strings ---");
        String[] messyArray = {"jasmine", "", null, "   ", "lotus", "rose", null};
        System.out.println("Messy Array: " + Arrays.toString(messyArray));
        System.out.println("Clean Array: " + cleanNullAndEmptyStrings(messyArray));
        System.out.println();

        // 3. Case-Insensitive Matching
        System.out.println("--- 3. Case-Insensitive Filter ---");
        String[] brands = {"Apple", "apple", "APPLE", "banana", "samsung"};
        System.out.println("Matching 'apple': " + filterIgnoreCase(brands, "apple"));
        System.out.println();

        // 4. Transformations (Uppercase & Suffix)
        System.out.println("--- 4. Map Transformations ---");
        String[] languages = {"Java", "Python", "C++", "Go"};
        System.out.println("Uppercase   : " + convertToUpperCase(languages));
        System.out.println("With Suffix : " + appendSuffix(languages, " Language"));
        System.out.println();

        // 5. Custom & Chained Predicates
        System.out.println("--- 5. Chained Predicates (StartsWith 'A' & Length > 4 & No space) ---");
        String[] candidateWords = {"Apple", "Apricot", "Avocado", "A cup", "Art", "banana"};
        System.out.println("Candidates: " + Arrays.toString(candidateWords));
        System.out.println("Filtered  : " + filterWithChainedPredicate(candidateWords));
        System.out.println();

        // 6. Mutability Demo
        demonstrateListMutability(new String[]{"Apple", "Banana"});
        System.out.println();
    }
}
