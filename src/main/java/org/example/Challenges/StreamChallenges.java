package org.example.Challenges;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: 50+ JAVA 8+ STREAM API & FILTERING PROBLEMS
 * ============================================================================
 * Masterclass collection of 55 essential Stream API interview challenges
 * categorized by concept:
 *
 *  SECTION 1: Basic Filtering & String Predicates (Challenges 1 - 10)
 *  SECTION 2: Mapping, Transforming & Flattening (Challenges 11 - 18)
 *  SECTION 3: Sorting, Slicing & Ordering (Challenges 19 - 26)
 *  SECTION 4: Numeric Streams, Math & Reductions (Challenges 27 - 34)
 *  SECTION 5: GroupingBy, Partitioning & Advanced Collectors (Challenges 35 - 43)
 *  SECTION 6: Matching, Finding & Element Lookups (Challenges 44 - 50)
 *  SECTION 7: Advanced Streams, Generators & Mutability (Challenges 51 - 55)
 * ============================================================================
 */
public class StreamChallenges {

    // ========================================================================
    // SECTION 1: BASIC FILTERING & STRING PREDICATES (1 - 10)
    // ========================================================================

    /** 1. Filter strings by strict length range (minLen < len < maxLen) */
    public static List<String> filterByLengthRange(String[] arr, int minLen, int maxLen) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> s.length() > minLen && s.length() < maxLen)
                .collect(Collectors.toList());
    }

    /** 2. Clean null, empty, and blank whitespace-only strings */
    public static List<String> cleanNullAndEmptyStrings(String[] arr) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> !s.trim().isEmpty())
                .collect(Collectors.toList());
    }

    /** 3. Filter strings matching target ignoring case */
    public static List<String> filterIgnoreCase(String[] arr, String target) {
        if (arr == null || target == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(s -> s.equalsIgnoreCase(target))
                .collect(Collectors.toList());
    }

    /** 4. Filter strings starting with a prefix (case-insensitive) */
    public static List<String> filterStartingWith(List<String> list, String prefix) {
        if (list == null || prefix == null) return Collections.emptyList();
        String lowerPrefix = prefix.toLowerCase();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.toLowerCase().startsWith(lowerPrefix))
                .collect(Collectors.toList());
    }

    /** 5. Filter strings ending with a suffix (case-insensitive) */
    public static List<String> filterEndingWith(List<String> list, String suffix) {
        if (list == null || suffix == null) return Collections.emptyList();
        String lowerSuffix = suffix.toLowerCase();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.toLowerCase().endsWith(lowerSuffix))
                .collect(Collectors.toList());
    }

    /** 6. Filter strings containing a specific substring */
    public static List<String> filterContaining(List<String> list, String substring) {
        if (list == null || substring == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    /** 7. Filter strings matching a regular expression pattern */
    public static List<String> filterByRegex(List<String> list, String regex) {
        if (list == null || regex == null) return Collections.emptyList();
        Pattern pattern = Pattern.compile(regex);
        return list.stream()
                .filter(Objects::nonNull)
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());
    }

    /** 8. Filter strings that consist solely of numeric digits */
    public static List<String> filterOnlyDigits(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty() && s.chars().allMatch(Character::isDigit))
                .collect(Collectors.toList());
    }

    /** 9. Filter strings that are palindromes */
    public static List<String> filterPalindromes(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> {
                    String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    return !clean.isEmpty() && clean.equals(new StringBuilder(clean).reverse().toString());
                })
                .collect(Collectors.toList());
    }

    /** 10. Filter strings where all characters are distinct (no repeated characters) */
    public static List<String> filterUniqueCharactersOnly(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.length() == s.chars().distinct().count())
                .collect(Collectors.toList());
    }

    // ========================================================================
    // SECTION 2: MAPPING, TRANSFORMING & FLATTENING (11 - 18)
    // ========================================================================

    /** 11. Convert all strings to uppercase */
    public static List<String> convertToUpperCase(String[] arr) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    /** 12. Convert all strings to lowercase */
    public static List<String> convertToLowerCase(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    /** 13. Map strings to their respective lengths */
    public static List<Integer> mapStringToLengths(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .collect(Collectors.toList());
    }

    /** 14. Append a suffix to each string */
    public static List<String> appendSuffix(String[] arr, String suffix) {
        if (arr == null) return Collections.emptyList();
        String safeSuffix = (suffix != null) ? suffix : "";
        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .map(s -> s + safeSuffix)
                .collect(Collectors.toList());
    }

    /** 15. Extract the first character of each non-empty string */
    public static List<Character> extractFirstCharacters(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .map(s -> s.charAt(0))
                .collect(Collectors.toList());
    }

    /** 16. Reverse each individual string in the list */
    public static List<String> reverseEachString(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());
    }

    /** 17. Map numbers to their squares */
    public static List<Integer> mapToSquares(List<Integer> numbers) {
        if (numbers == null) return Collections.emptyList();
        return numbers.stream()
                .filter(Objects::nonNull)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    /** 18. Flatten nested lists into a single flat list (flatMap) */
    public static <T> List<T> flattenListOfLists(List<List<T>> nestedList) {
        if (nestedList == null) return Collections.emptyList();
        return nestedList.stream()
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // ========================================================================
    // SECTION 3: SORTING, SLICING & ORDERING (19 - 26)
    // ========================================================================

    /** 19. Sort strings in natural alphabetical order */
    public static List<String> sortAlphabetically(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.toList());
    }

    /** 20. Sort strings by length ascending */
    public static List<String> sortByLengthAscending(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    /** 21. Sort by length descending, then alphabetically */
    public static List<String> sortByLengthThenAlphabetical(List<String> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length).reversed().thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    /** 22. Sort numbers in descending order */
    public static List<Integer> sortDescending(List<Integer> list) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /** 23. Find Top N largest elements */
    public static List<Integer> findTopNElements(List<Integer> list, int n) {
        if (list == null || n <= 0) return Collections.emptyList();
        return list.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .collect(Collectors.toList());
    }

    /** 24. Skip first N elements and return remainder */
    public static List<String> skipFirstNElements(List<String> list, int n) {
        if (list == null) return Collections.emptyList();
        return list.stream()
                .skip(Math.max(0, n))
                .collect(Collectors.toList());
    }

    /** 25. Find the 2nd Highest distinct number in a list */
    public static Optional<Integer> findSecondHighest(List<Integer> numbers) {
        if (numbers == null) return Optional.empty();
        return numbers.stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    /** 26. Find the 2nd Lowest distinct number in a list */
    public static Optional<Integer> findSecondLowest(List<Integer> numbers) {
        if (numbers == null) return Optional.empty();
        return numbers.stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();
    }

    // ========================================================================
    // SECTION 4: NUMERIC STREAMS, MATH & REDUCTIONS (27 - 34)
    // ========================================================================

    /** 27. Calculate Sum using IntStream.sum() */
    public static int calculateSum(List<Integer> numbers) {
        if (numbers == null) return 0;
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /** 28. Calculate Average using IntStream.average() */
    public static OptionalDouble calculateAverage(List<Integer> numbers) {
        if (numbers == null) return OptionalDouble.empty();
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average();
    }

    /** 29. Find Maximum number using Stream.max() */
    public static Optional<Integer> findMaxNumber(List<Integer> numbers) {
        if (numbers == null) return Optional.empty();
        return numbers.stream()
                .filter(Objects::nonNull)
                .max(Integer::compareTo);
    }

    /** 30. Find Minimum number using Stream.min() */
    public static Optional<Integer> findMinNumber(List<Integer> numbers) {
        if (numbers == null) return Optional.empty();
        return numbers.stream()
                .filter(Objects::nonNull)
                .min(Integer::compareTo);
    }

    /** 31. Calculate product of all numbers using reduce */
    public static int calculateProduct(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return 0;
        return numbers.stream()
                .filter(Objects::nonNull)
                .reduce(1, (a, b) -> a * b);
    }

    /** 32. Count elements matching a custom condition */
    public static <T> long countMatching(List<T> list, Predicate<T> condition) {
        if (list == null || condition == null) return 0;
        return list.stream()
                .filter(Objects::nonNull)
                .filter(condition)
                .count();
    }

    /** 33. Summary Statistics (count, sum, min, average, max) in one pass */
    public static IntSummaryStatistics getSummaryStats(List<Integer> numbers) {
        if (numbers == null) return new IntSummaryStatistics();
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .summaryStatistics();
    }

    /** 34. Sum of squares of even numbers */
    public static int sumOfSquaresOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) return 0;
        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
    }

    // ========================================================================
    // SECTION 5: GROUPINGBY, PARTITIONING & COLLECTORS (35 - 43)
    // ========================================================================

    /** 35. Group strings by their length */
    public static Map<Integer, List<String>> groupStringsByLength(List<String> list) {
        if (list == null) return Collections.emptyMap();
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(String::length));
    }

    /** 36. Group strings by their first character */
    public static Map<Character, List<String>> groupStringsByFirstLetter(List<String> list) {
        if (list == null) return Collections.emptyMap();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
    }

    /** 37. Count frequency of each word/element */
    public static <T> Map<T, Long> countElementFrequencies(List<T> list) {
        if (list == null) return Collections.emptyMap();
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /** 38. Count character occurrences in a string */
    public static Map<Character, Long> countCharacterFrequency(String str) {
        if (str == null) return Collections.emptyMap();
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /** 39. Partition integers into Evens (true) and Odds (false) */
    public static Map<Boolean, List<Integer>> partitionEvenAndOdd(List<Integer> numbers) {
        if (numbers == null) return Collections.emptyMap();
        return numbers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    /** 40. Partition scores into Passing (>= threshold) and Failing */
    public static Map<Boolean, List<Integer>> partitionPassingScores(List<Integer> scores, int passingThreshold) {
        if (scores == null) return Collections.emptyMap();
        return scores.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.partitioningBy(score -> score >= passingThreshold));
    }

    /** 41. Join list of strings into delimited string with prefix and suffix */
    public static String joinStrings(List<String> list, String delimiter, String prefix, String suffix) {
        if (list == null) return "";
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.joining(delimiter, prefix, suffix));
    }

    /** 42. Collect stream into a sorted custom collection (TreeSet) */
    public static Set<String> collectToSortedSet(List<String> list) {
        if (list == null) return Collections.emptySet();
        return list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    /** 43. Map string list to Map<String, Integer> representing word to length */
    public static Map<String, Integer> mapWordsToLength(List<String> list) {
        if (list == null) return Collections.emptyMap();
        return list.stream()
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    // ========================================================================
    // SECTION 6: MATCHING, FINDING & LOOKUPS (44 - 50)
    // ========================================================================

    /** 44. Check if all numbers are positive */
    public static boolean areAllPositive(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return false;
        return numbers.stream().allMatch(n -> n > 0);
    }

    /** 45. Check if any number is even */
    public static boolean containsAnyEven(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return false;
        return numbers.stream().anyMatch(n -> n % 2 == 0);
    }

    /** 46. Check if no elements match a condition (e.g., no negative numbers) */
    public static boolean containsNoNegatives(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) return true;
        return numbers.stream().noneMatch(n -> n < 0);
    }

    /** 47. Find first element matching condition */
    public static <T> Optional<T> findFirstMatching(List<T> list, Predicate<T> condition) {
        if (list == null || condition == null) return Optional.empty();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(condition)
                .findFirst();
    }

    /** 48. Find any element matching condition (useful for parallel streams) */
    public static <T> Optional<T> findAnyMatching(List<T> list, Predicate<T> condition) {
        if (list == null || condition == null) return Optional.empty();
        return list.stream()
                .filter(Objects::nonNull)
                .filter(condition)
                .findAny();
    }

    /** 49. Find first non-repeating character in a string using Streams */
    public static Optional<Character> findFirstNonRepeatingChar(String str) {
        if (str == null || str.isEmpty()) return Optional.empty();
        Map<Character, Long> counts = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        return counts.entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    /** 50. Find first repeated character in a string using Streams */
    public static Optional<Character> findFirstRepeatedChar(String str) {
        if (str == null || str.isEmpty()) return Optional.empty();
        Set<Character> seen = new HashSet<>();
        return str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !seen.add(c))
                .findFirst();
    }

    // ========================================================================
    // SECTION 7: ADVANCED STREAMS, GENERATORS & CAVEATS (51 - 55)
    // ========================================================================

    /** 51. Dynamic Predicate Chaining (.and(), .or(), .negate()) */
    public static List<String> filterWithChainedPredicate(String[] arr) {
        if (arr == null) return Collections.emptyList();
        Predicate<String> startsWithA = s -> s.startsWith("A") || s.startsWith("a");
        Predicate<String> lengthGreaterThan4 = s -> s.length() > 4;
        Predicate<String> doesNotContainSpaces = s -> !s.contains(" ");

        Predicate<String> combined = startsWithA.and(lengthGreaterThan4).and(doesNotContainSpaces);

        return Arrays.stream(arr)
                .filter(Objects::nonNull)
                .filter(combined)
                .collect(Collectors.toList());
    }

    /** 52. Generate Fibonacci Series up to N numbers using Stream.iterate() */
    public static List<Long> generateFibonacci(int n) {
        if (n <= 0) return Collections.emptyList();
        return Stream.iterate(new long[]{0, 1}, fib -> new long[]{fib[1], fib[0] + fib[1]})
                .limit(n)
                .map(fib -> fib[0])
                .collect(Collectors.toList());
    }

    /** 53. Generate list of N Prime Numbers using IntStream */
    public static List<Integer> generatePrimes(int count) {
        if (count <= 0) return Collections.emptyList();
        return IntStream.iterate(2, i -> i + 1)
                .filter(StreamChallenges::isPrime)
                .limit(count)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }

    /** 54. Merge two lists and remove duplicates */
    public static <T> List<T> mergeAndRemoveDuplicates(List<T> list1, List<T> list2) {
        if (list1 == null && list2 == null) return Collections.emptyList();
        Stream<T> s1 = (list1 != null) ? list1.stream() : Stream.empty();
        Stream<T> s2 = (list2 != null) ? list2.stream() : Stream.empty();
        return Stream.concat(s1, s2)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    /** 55. Mutability Caveat: Stream.toList() vs Collectors.toList() */
    public static void demonstrateListMutability(String[] arr) {
        System.out.println("--- 55. Stream Mutability Caveat (Collectors.toList vs Stream.toList) ---");
        List<String> mutableList = Arrays.stream(arr).collect(Collectors.toList());
        mutableList.add("NewFruit (Collectors)");
        System.out.println("Collectors.toList() is MUTABLE: " + mutableList);

        List<String> unmodifiableList = Arrays.stream(arr).toList();
        try {
            unmodifiableList.add("NewFruit (Stream.toList)");
        } catch (UnsupportedOperationException e) {
            System.out.println("Stream.toList() threw expected: UnsupportedOperationException (UNMODIFIABLE)");
        }
    }

    // ========================================================================
    // MAIN DEMO RUNNER: Full test & demonstration suite
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("   JAVA 8+ STREAM API & FILTERING: 55 INTERVIEW CHALLENGES     ");
        System.out.println("===============================================================\n");

        List<String> sampleFruits = Arrays.asList("Apple", "Banana", "pomegranate", "orange", "grape", "cherry", "fig", "Avocado", "Apricot");
        List<Integer> sampleNumbers = Arrays.asList(10, 15, 20, 25, 30, 35, 40, 45, 50, 20, 10);

        // Section 1
        System.out.println(">>> SECTION 1: FILTERING & STRING PREDICATES");
        System.out.println("1. Length Range (4 to 7): " + filterByLengthRange(sampleFruits.toArray(new String[0]), 4, 7));
        System.out.println("2. Clean Null/Empty     : " + cleanNullAndEmptyStrings(new String[]{"Java", "", null, "   ", "Spring"}));
        System.out.println("3. Filter IgnoreCase    : " + filterIgnoreCase(sampleFruits.toArray(new String[0]), "apple"));
        System.out.println("4. Starting with 'Ap'   : " + filterStartingWith(sampleFruits, "Ap"));
        System.out.println("5. Ending with 'e'      : " + filterEndingWith(sampleFruits, "e"));
        System.out.println("6. Containing 'an'      : " + filterContaining(sampleFruits, "an"));
        System.out.println("7. Regex (starts with A): " + filterByRegex(sampleFruits, "^A.*"));
        System.out.println("8. Only Digits          : " + filterOnlyDigits(Arrays.asList("123", "45a", "999", "abc")));
        System.out.println("9. Palindromes          : " + filterPalindromes(Arrays.asList("madam", "racecar", "java", "noon")));
        System.out.println("10. Unique Chars Only   : " + filterUniqueCharactersOnly(Arrays.asList("cat", "apple", "dog", "banana")));
        System.out.println();

        // Section 2
        System.out.println(">>> SECTION 2: MAPPING & FLATTENING");
        System.out.println("11. Uppercase           : " + convertToUpperCase(new String[]{"red", "green", "blue"}));
        System.out.println("12. Lowercase           : " + convertToLowerCase(Arrays.asList("JAVA", "PYTHON")));
        System.out.println("13. String Lengths      : " + mapStringToLengths(Arrays.asList("A", "BB", "CCC")));
        System.out.println("14. Append Suffix       : " + appendSuffix(new String[]{"Dev", "Ops"}, "Sec"));
        System.out.println("15. First Characters    : " + extractFirstCharacters(Arrays.asList("Delhi", "Mumbai", "Chennai")));
        System.out.println("16. Reverse Strings     : " + reverseEachString(Arrays.asList("Java", "Stream")));
        System.out.println("17. Squares of Numbers  : " + mapToSquares(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println("18. FlatMap Nested Lists: " + flattenListOfLists(Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5))));
        System.out.println();

        // Section 3
        System.out.println(">>> SECTION 3: SORTING & SLICING");
        System.out.println("19. Alphabetical Order  : " + sortAlphabetically(Arrays.asList("Zebra", "Apple", "Mango")));
        System.out.println("20. By Length Ascending : " + sortByLengthAscending(Arrays.asList("Pomegranate", "Fig", "Apple")));
        System.out.println("21. By Length then Alpha: " + sortByLengthThenAlphabetical(Arrays.asList("bb", "aa", "ccc", "a")));
        System.out.println("22. Descending Sort     : " + sortDescending(Arrays.asList(5, 1, 9, 3, 7)));
        System.out.println("23. Top 3 Numbers       : " + findTopNElements(sampleNumbers, 3));
        System.out.println("24. Skip First 2 Words  : " + skipFirstNElements(sampleFruits, 2));
        System.out.println("25. 2nd Highest Number  : " + findSecondHighest(sampleNumbers).orElse(null));
        System.out.println("26. 2nd Lowest Number   : " + findSecondLowest(sampleNumbers).orElse(null));
        System.out.println();

        // Section 4
        System.out.println(">>> SECTION 4: NUMERIC STREAMS & MATH");
        System.out.println("27. Sum of Numbers      : " + calculateSum(Arrays.asList(10, 20, 30)));
        System.out.println("28. Average of Numbers  : " + calculateAverage(Arrays.asList(10, 20, 30)).orElse(0.0));
        System.out.println("29. Max Number          : " + findMaxNumber(sampleNumbers).orElse(null));
        System.out.println("30. Min Number          : " + findMinNumber(sampleNumbers).orElse(null));
        System.out.println("31. Product via Reduce  : " + calculateProduct(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println("32. Count Even Numbers  : " + countMatching(sampleNumbers, n -> n % 2 == 0));
        System.out.println("33. Summary Statistics  : " + getSummaryStats(sampleNumbers));
        System.out.println("34. Sum of Even Squares : " + sumOfSquaresOfEvenNumbers(Arrays.asList(1, 2, 3, 4))); // 2^2 + 4^2 = 20
        System.out.println();

        // Section 5
        System.out.println(">>> SECTION 5: GROUPING, PARTITIONING & COLLECTORS");
        System.out.println("35. Group by Length     : " + groupStringsByLength(Arrays.asList("a", "bb", "c", "ddd", "ee")));
        System.out.println("36. Group by 1st Letter : " + groupStringsByFirstLetter(Arrays.asList("Alice", "Bob", "Alex", "Charlie")));
        System.out.println("37. Element Frequencies : " + countElementFrequencies(Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple")));
        System.out.println("38. Char Frequency 'JAVA': " + countCharacterFrequency("JAVA"));
        System.out.println("39. Partition Even/Odd  : " + partitionEvenAndOdd(Arrays.asList(1, 2, 3, 4, 5, 6)));
        System.out.println("40. Partition Scores>=50: " + partitionPassingScores(Arrays.asList(45, 78, 92, 33, 60), 50));
        System.out.println("41. Joined String       : " + joinStrings(Arrays.asList("A", "B", "C"), " - ", "[", "]"));
        System.out.println("42. Custom TreeSet      : " + collectToSortedSet(Arrays.asList("banana", "apple", "cherry")));
        System.out.println("43. Word to Length Map  : " + mapWordsToLength(Arrays.asList("Java", "Spring", "Docker")));
        System.out.println();

        // Section 6
        System.out.println(">>> SECTION 6: MATCHING & LOOKUPS");
        System.out.println("44. Are All Positive    : " + areAllPositive(Arrays.asList(1, 2, 3, 4)));
        System.out.println("45. Contains Any Even   : " + containsAnyEven(Arrays.asList(1, 3, 5, 8)));
        System.out.println("46. Contains No Negatives: " + containsNoNegatives(Arrays.asList(1, 2, 3)));
        System.out.println("47. Find First > 25     : " + findFirstMatching(sampleNumbers, n -> n > 25).orElse(null));
        System.out.println("48. Find Any Even       : " + findAnyMatching(sampleNumbers, n -> n % 2 == 0).orElse(null));
        System.out.println("49. 1st Non-Repeating 'swiss': " + findFirstNonRepeatingChar("swiss").orElse(null));
        System.out.println("50. 1st Repeated Char 'swiss': " + findFirstRepeatedChar("swiss").orElse(null));
        System.out.println();

        // Section 7
        System.out.println(">>> SECTION 7: ADVANCED GENERATORS & CAVEATS");
        System.out.println("51. Chained Predicates  : " + filterWithChainedPredicate(new String[]{"Apple", "Apricot", "A cup", "Art", "banana"}));
        System.out.println("52. First 10 Fibonacci  : " + generateFibonacci(10));
        System.out.println("53. First 10 Primes     : " + generatePrimes(10));
        System.out.println("54. Merge & Distinct    : " + mergeAndRemoveDuplicates(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5)));
        demonstrateListMutability(new String[]{"Apple", "Banana"});
        System.out.println("\n===============================================================");
    }
}
