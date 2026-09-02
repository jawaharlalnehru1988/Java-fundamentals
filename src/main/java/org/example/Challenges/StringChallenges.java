package org.example.Challenges;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: STRINGS
 * ============================================================================
 * Topics Covered:
 * 1. Reverse a String (Two Pointers, StringBuilder, Recursion)
 * 2. Check Palindrome (Two Pointers & StringBuilder)
 * 3. Count Vowels and Consonants (Iterative & Stream)
 * 4. Remove Vowels from a String (Loop & Regex)
 * 5. Find the Longest String in an Array
 * 6. Find the First Non-Repeating Character (Frequency Array)
 * 7. Check if Two Strings are Anagrams (Frequency Counting)
 * 8. Remove Duplicate Characters from a String
 * 9. Count Words in a String (Handling edge whitespace)
 * 10. Filter Strings by Substring, Prefix, Suffix & Regex
 * ============================================================================
 */
public class StringChallenges {

    // ========================================================================
    // CHALLENGE 1: Reverse a String
    // ========================================================================

    /**
     * Approach 1A: Using StringBuilder
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static String reverseWithStringBuilder(String str) {
        if (str == null) return "";
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Approach 1B: Two-pointer character array swapping
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static String reverseWithTwoPointers(String str) {
        if (str == null) return "";
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // ========================================================================
    // CHALLENGE 2: Check Palindrome
    // ========================================================================

    /**
     * Check if a string reads the same forwards and backwards (Two Pointers)
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ========================================================================
    // CHALLENGE 3: Count Vowels and Consonants
    // ========================================================================

    /**
     * Returns an array [vowelCount, consonantCount]
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static int[] countVowelsAndConsonants(String str) {
        if (str == null) return new int[]{0, 0};
        int vowels = 0;
        int consonants = 0;
        String vowelSet = "aeiou";

        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                if (vowelSet.indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return new int[]{vowels, consonants};
    }

    // ========================================================================
    // CHALLENGE 4: Remove Vowels from String
    // ========================================================================

    /**
     * Approach 4A: Using StringBuilder iteration
     */
    public static String removeVowels(String str) {
        if (str == null) return "";
        StringBuilder sb = new StringBuilder();
        String vowels = "aeiouAEIOU";
        for (char ch : str.toCharArray()) {
            if (vowels.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * Approach 4B: Using Regex
     */
    public static String removeVowelsRegex(String str) {
        if (str == null) return "";
        return str.replaceAll("(?i)[aeiou]", "");
    }

    // ========================================================================
    // CHALLENGE 5: Find the Longest String in an Array
    // ========================================================================

    /**
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static String findLongestString(String[] arr) {
        if (arr == null || arr.length == 0) return null;
        String longest = arr[0];
        for (String s : arr) {
            if (s != null && s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    // ========================================================================
    // CHALLENGE 6: First Non-Repeating Character
    // ========================================================================

    /**
     * Uses frequency array. Returns character or ' ' if none found.
     * Time Complexity: O(N), Space Complexity: O(1) (fixed 256 size)
     */
    public static char firstNonRepeatingChar(String str) {
        if (str == null || str.isEmpty()) return ' ';
        int[] freq = new int[256];

        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        for (char ch : str.toCharArray()) {
            if (freq[ch] == 1) {
                return ch;
            }
        }
        return ' ';
    }

    // ========================================================================
    // CHALLENGE 7: Check Anagrams
    // ========================================================================

    /**
     * Checks if two strings contain the exact same characters in any order.
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        // Clean whitespace & convert to lowercase
        String s1 = str1.replaceAll("\\s+", "").toLowerCase();
        String s2 = str2.replaceAll("\\s+", "").toLowerCase();
        if (s1.length() != s2.length()) return false;

        int[] charCounts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCounts[s1.charAt(i) - 'a']++;
            charCounts[s2.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) return false;
        }
        return true;
    }

    // ========================================================================
    // CHALLENGE 8: Remove Duplicate Characters from String
    // ========================================================================

    /**
     * Preserves insertion order while eliminating duplicate characters.
     * Time Complexity: O(N), Space Complexity: O(N)
     */
    public static String removeDuplicateCharacters(String str) {
        if (str == null) return "";
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[256];

        for (char ch : str.toCharArray()) {
            if (!seen[ch]) {
                seen[ch] = true;
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // ========================================================================
    // CHALLENGE 9: Count Words in String
    // ========================================================================

    /**
     * Accurately counts words even with multiple consecutive spaces.
     */
    public static int countWords(String str) {
        if (str == null || str.trim().isEmpty()) return 0;
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    // ========================================================================
    // CHALLENGE 10: Filter Strings by Prefix, Suffix, and Regex
    // ========================================================================

    public static List<String> filterByPrefix(String[] arr, String prefix) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(s -> s != null && s.startsWith(prefix))
                .collect(Collectors.toList());
    }

    public static List<String> filterBySuffix(String[] arr, String suffix) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(s -> s != null && s.endsWith(suffix))
                .collect(Collectors.toList());
    }

    public static List<String> filterNumericOnly(String[] arr) {
        if (arr == null) return Collections.emptyList();
        return Arrays.stream(arr)
                .filter(s -> s != null && s.matches("\\d+"))
                .collect(Collectors.toList());
    }

    // ========================================================================
    // MAIN METHOD: Demo & Test Runner for YouTube
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("       JAVA CODING CHALLENGES: STRINGS MASTER DEMO             ");
        System.out.println("===============================================================\n");

        // 1. Reverse String
        System.out.println("--- 1. Reverse String ---");
        String inputStr = "Hello World";
        System.out.println("Original: " + inputStr);
        System.out.println("Reversed (StringBuilder): " + reverseWithStringBuilder(inputStr));
        System.out.println("Reversed (Two Pointers) : " + reverseWithTwoPointers(inputStr));
        System.out.println();

        // 2. Palindrome
        System.out.println("--- 2. Check Palindrome ---");
        System.out.println("'racecar' is palindrome? " + isPalindrome("racecar"));
        System.out.println("'Madam' is palindrome?   " + isPalindrome("Madam"));
        System.out.println("'hello' is palindrome?   " + isPalindrome("hello"));
        System.out.println();

        // 3. Count Vowels & Consonants
        System.out.println("--- 3. Count Vowels and Consonants ---");
        int[] counts = countVowelsAndConsonants("Java Fundamentals 2026");
        System.out.println("In 'Java Fundamentals 2026' -> Vowels: " + counts[0] + ", Consonants: " + counts[1]);
        System.out.println();

        // 4. Remove Vowels
        System.out.println("--- 4. Remove Vowels ---");
        System.out.println("Without vowels (Loop) : " + removeVowels("Programming"));
        System.out.println("Without vowels (Regex): " + removeVowelsRegex("Programming"));
        System.out.println();

        // 5. Longest String
        System.out.println("--- 5. Find Longest String ---");
        String[] fruits = {"Apple", "Banana", "Pomegranate", "Orange", "Fig"};
        System.out.println("Fruits Array: " + Arrays.toString(fruits));
        System.out.println("Longest String: " + findLongestString(fruits));
        System.out.println();

        // 6. First Non-Repeating Character
        System.out.println("--- 6. First Non-Repeating Character ---");
        System.out.println("First non-repeating in 'swiss': " + firstNonRepeatingChar("swiss"));
        System.out.println("First non-repeating in 'leetcode': " + firstNonRepeatingChar("leetcode"));
        System.out.println();

        // 7. Check Anagrams
        System.out.println("--- 7. Check Anagrams ---");
        System.out.println("'listen' & 'silent' are anagrams? " + areAnagrams("listen", "silent"));
        System.out.println("'triangle' & 'integral' are anagrams? " + areAnagrams("triangle", "integral"));
        System.out.println("'apple' & 'banana' are anagrams? " + areAnagrams("apple", "banana"));
        System.out.println();

        // 8. Remove Duplicate Characters
        System.out.println("--- 8. Remove Duplicate Characters ---");
        System.out.println("Deduplicated 'programming': " + removeDuplicateCharacters("programming"));
        System.out.println();

        // 9. Count Words
        System.out.println("--- 9. Count Words in String ---");
        String sentence = "   Java   Streams   and   Lambdas  are powerful!  ";
        System.out.println("Sentence: \"" + sentence + "\"");
        System.out.println("Word Count: " + countWords(sentence));
        System.out.println();

        // 10. String Filtering by Prefix / Suffix / Regex
        System.out.println("--- 10. String Filtering ---");
        String[] mixedList = {"apple", "apricot", "banana", "grape", "123", "456xyz", "999"};
        System.out.println("Starts with 'ap' : " + filterByPrefix(mixedList, "ap"));
        System.out.println("Ends with 'e'    : " + filterBySuffix(mixedList, "e"));
        System.out.println("Numeric Only     : " + filterNumericOnly(mixedList));
        System.out.println();
    }
}
