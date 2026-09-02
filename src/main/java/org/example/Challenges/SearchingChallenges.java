package org.example.Challenges;

import java.util.Arrays;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: SEARCHING ALGORITHMS
 * ============================================================================
 * Topics Covered:
 * 1. Linear Search (Unsorted Array)
 * 2. Binary Search (Iterative & Recursive on Sorted Arrays)
 * ============================================================================
 */
public class SearchingChallenges {

    // ========================================================================
    // CHALLENGE 1: Linear Search
    // ========================================================================

    /**
     * Finds the index of target in an unsorted array.
     * Time Complexity: O(N), Space Complexity: O(1)
     */
    public static int linearSearch(int[] arr, int target) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // ========================================================================
    // CHALLENGE 2: Binary Search (Iterative & Recursive)
    // ========================================================================

    /**
     * Binary Search (Iterative)
     * NOTE: Array MUST be sorted in ascending order.
     * Time Complexity: O(log N), Space Complexity: O(1)
     */
    public static int binarySearchIterative(int[] sortedArr, int target) {
        if (sortedArr == null) return -1;
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            // Avoid integer overflow with low + (high - low) / 2
            int mid = low + (high - low) / 2;

            if (sortedArr[mid] == target) {
                return mid;
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Not found
    }

    /**
     * Binary Search (Recursive)
     * Time Complexity: O(log N), Space Complexity: O(log N) Call Stack
     */
    public static int binarySearchRecursive(int[] sortedArr, int target, int low, int high) {
        if (sortedArr == null || low > high) return -1;

        int mid = low + (high - low) / 2;
        if (sortedArr[mid] == target) {
            return mid;
        } else if (sortedArr[mid] < target) {
            return binarySearchRecursive(sortedArr, target, mid + 1, high);
        } else {
            return binarySearchRecursive(sortedArr, target, low, mid - 1);
        }
    }

    // ========================================================================
    // MAIN METHOD: Demo & Test Runner for YouTube
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("     JAVA CODING CHALLENGES: SEARCHING ALGORITHMS DEMO         ");
        System.out.println("===============================================================\n");

        // 1. Linear Search on Unsorted Data
        System.out.println("--- 1. Linear Search (Unsorted Array) ---");
        int[] unsorted = {45, 5, 32, 9, 68, 255, 0, 6};
        System.out.println("Array: " + Arrays.toString(unsorted));
        System.out.println("Index of 68  : " + linearSearch(unsorted, 68));
        System.out.println("Index of 100 : " + linearSearch(unsorted, 100) + " (Not found)");
        System.out.println();

        // 2. Binary Search on Sorted Data
        System.out.println("--- 2. Binary Search (Sorted Array) ---");
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println("Sorted Array: " + Arrays.toString(sorted));

        int target = 23;
        int iterResult = binarySearchIterative(sorted, target);
        int recResult = binarySearchRecursive(sorted, target, 0, sorted.length - 1);
        System.out.println("Search for " + target + " (Iterative): Found at index " + iterResult);
        System.out.println("Search for " + target + " (Recursive): Found at index " + recResult);

        int missingTarget = 40;
        System.out.println("Search for " + missingTarget + ": Found at index " + binarySearchIterative(sorted, missingTarget));
        System.out.println();
    }
}
