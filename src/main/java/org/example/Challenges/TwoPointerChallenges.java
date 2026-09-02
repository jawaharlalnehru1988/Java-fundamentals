package org.example.Challenges;

import java.util.*;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: TWO-POINTER PATTERN
 * ============================================================================
 * The Two-Pointer technique is one of the most frequently asked algorithmic patterns
 * in technical interviews. It typically reduces time complexity from O(N^2) to O(N)
 * and space complexity to O(1).
 *
 * Core Two-Pointer Variants:
 *  1. Opposite-Direction (Converging): Left starts at 0, Right starts at N-1.
 *  2. Same-Direction (Fast & Slow / Read & Write): Both start at 0 at different speeds.
 *  3. Backward Direction (Merging): Pointers start at the ends of arrays and fill backwards.
 *
 * Challenges Covered:
 *  - Challenge 1: Two Sum II (Sorted Array) - Converging Pointers
 *  - Challenge 2: Valid Palindrome (Ignoring Non-Alphanumeric) - Converging Pointers
 *  - Challenge 3: Container With Most Water - Greedy Converging Pointers
 *  - Challenge 4: Move Zeroes to End (In-Place) - Fast & Slow Pointers
 *  - Challenge 5: Remove Specific Element In-Place - Read & Write Pointers
 *  - Challenge 6: Reverse Vowels in a String - Converging Pointers
 *  - Challenge 7: Squares of a Sorted Array - Converging Pointers
 *  - Challenge 8: Merge Two Sorted Arrays In-Place - Backward Three Pointers
 *  - Challenge 9: 3Sum (Triplets summing to zero) - Sort + Two Pointers
 *  - Challenge 10: Trapping Rain Water - Converging Two Pointers with Max Tracking
 * ============================================================================
 */
public class TwoPointerChallenges {

    // ========================================================================
    // CHALLENGE 1: Two Sum II - Input Array is Sorted (LeetCode #167)
    // ========================================================================

    /**
     * Problem: Given a 1-indexed sorted array of integers, find two numbers that add up to a target.
     * Strategy: Left pointer at 0, Right pointer at length - 1.
     *           - If sum == target -> found!
     *           - If sum < target  -> move left++ (to increase sum)
     *           - If sum > target  -> move right-- (to decrease sum)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @return 1-based indices [index1, index2] or empty array if no pair found
     */
    public static int[] twoSumSorted(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[0];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            if (currentSum == target) {
                return new int[]{left + 1, right + 1}; // 1-based index
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    // ========================================================================
    // CHALLENGE 2: Valid Palindrome (LeetCode #125)
    // ========================================================================

    /**
     * Problem: Determine if a string is a palindrome, considering only alphanumeric
     *          characters and ignoring cases.
     * Strategy: Two pointers from start and end, skipping non-alphanumeric chars.
     * Time Complexity: O(N)
     * Space Complexity: O(1) auxiliary
     */
    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // ========================================================================
    // CHALLENGE 3: Container With Most Water (LeetCode #11)
    // ========================================================================

    /**
     * Problem: Given array of heights, find two lines that together with x-axis forms a container
     *          such that it contains the maximum water.
     * Strategy: Area = min(height[left], height[right]) * (right - left).
     *           Always move the pointer pointing to the shorter line inward.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int minH = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, minH * width);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    // ========================================================================
    // CHALLENGE 4: Move Zeroes to End (LeetCode #283)
    // ========================================================================

    /**
     * Problem: Move all 0's to the end of array while maintaining relative order of non-zero elements.
     * Strategy: Fast & Slow Pointer (Write Pointer).
     *           Slow pointer keeps track of where the next non-zero should be placed.
     * Time Complexity: O(N)
     * Space Complexity: O(1) in-place
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int writeIndex = 0;

        // Step 1: Move all non-zero elements to front
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != 0) {
                nums[writeIndex++] = nums[readIndex];
            }
        }

        // Step 2: Fill remaining positions with zeros
        while (writeIndex < nums.length) {
            nums[writeIndex++] = 0;
        }
    }

    // ========================================================================
    // CHALLENGE 5: Remove Element In-Place (LeetCode #27)
    // ========================================================================

    /**
     * Problem: Remove all instances of `val` in-place and return new length.
     * Strategy: Read & Write pointer.
     * Time Complexity: O(N)
     * Space Complexity: O(1) in-place
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int writeIndex = 0;
        for (int readIndex = 0; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != val) {
                nums[writeIndex++] = nums[readIndex];
            }
        }
        return writeIndex;
    }

    // ========================================================================
    // CHALLENGE 6: Reverse Vowels in a String (LeetCode #345)
    // ========================================================================

    /**
     * Problem: Reverse only all the vowels in the string.
     * Strategy: Two converging pointers swapping vowels.
     * Time Complexity: O(N)
     * Space Complexity: O(N) for char array
     */
    public static String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    // ========================================================================
    // CHALLENGE 7: Squares of a Sorted Array (LeetCode #977)
    // ========================================================================

    /**
     * Problem: Given a sorted integer array with possible negatives, return an array of the
     *          squares of each number sorted in non-decreasing order.
     * Strategy: Since negatives squared become positive, the largest squares are at the ends!
     *           Compare squares at left and right, place the larger one at the back of result.
     * Time Complexity: O(N)
     * Space Complexity: O(N) for result array
     */
    public static int[] sortedSquares(int[] nums) {
        if (nums == null) return new int[0];
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int resultIndex = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[resultIndex] = leftSquare;
                left++;
            } else {
                result[resultIndex] = rightSquare;
                right--;
            }
            resultIndex--;
        }
        return result;
    }

    // ========================================================================
    // CHALLENGE 8: Merge Two Sorted Arrays In-Place (LeetCode #88)
    // ========================================================================

    /**
     * Problem: Merge nums2 into nums1 as one sorted array. nums1 has size m + n.
     * Strategy: Three pointers starting from the BACK (m-1, n-1, and m+n-1).
     *           Prevents overwriting unprocessed elements in nums1!
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public static void mergeSortedArraysInPlace(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int pMerge = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[pMerge--] = nums1[p1--];
            } else {
                nums1[pMerge--] = nums2[p2--];
            }
        }
        // Fill remaining elements from nums2 if any (nums1 elements are already in place)
        while (p2 >= 0) {
            nums1[pMerge--] = nums2[p2--];
        }
    }

    // ========================================================================
    // CHALLENGE 9: 3Sum - Triplets Sum to Zero (LeetCode #15)
    // ========================================================================

    /**
     * Problem: Find all unique triplets [nums[i], nums[j], nums[k]] such that i != j != k and nums[i] + nums[j] + nums[k] == 0.
     * Strategy: Sort the array first O(N log N), iterate each element as anchor, and use two-pointer search on remainder.
     *           Carefully skip duplicates to avoid identical triplets.
     * Time Complexity: O(N^2)
     * Space Complexity: O(1) auxiliary (ignoring output)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // If current number > 0, sum of 3 positive numbers can never be 0
            if (nums[i] > 0) break;

            // Skip duplicate anchor values
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left & right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // ========================================================================
    // CHALLENGE 10: Trapping Rain Water (LeetCode #42 - Hard)
    // ========================================================================

    /**
     * Problem: Compute how much water it can trap after raining.
     * Strategy: Optimal Two Pointers with leftMax and rightMax tracking.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int trapRainWater(int[] height) {
        if (height == null || height.length < 3) return 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    // ========================================================================
    // MAIN METHOD: Demo & Test Runner for Walkthroughs & Interviews
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("      JAVA CODING CHALLENGES: TWO-POINTER ALGORITHMS           ");
        System.out.println("===============================================================\n");

        // 1. Two Sum II
        System.out.println("--- 1. Two Sum II (Sorted Array) ---");
        int[] sortedNumbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Input: " + Arrays.toString(sortedNumbers) + ", Target: " + target);
        System.out.println("Result (1-based indices): " + Arrays.toString(twoSumSorted(sortedNumbers, target)));
        System.out.println();

        // 2. Valid Palindrome
        System.out.println("--- 2. Valid Palindrome ---");
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "race a car";
        System.out.println("\"" + test1 + "\" -> isPalindrome? " + isPalindrome(test1));
        System.out.println("\"" + test2 + "\" -> isPalindrome? " + isPalindrome(test2));
        System.out.println();

        // 3. Container With Most Water
        System.out.println("--- 3. Container With Most Water ---");
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Heights: " + Arrays.toString(heights));
        System.out.println("Max Water Area: " + maxArea(heights));
        System.out.println();

        // 4. Move Zeroes
        System.out.println("--- 4. Move Zeroes to End ---");
        int[] zeroArray = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(zeroArray));
        moveZeroes(zeroArray);
        System.out.println("After : " + Arrays.toString(zeroArray));
        System.out.println();

        // 5. Remove Element In-Place
        System.out.println("--- 5. Remove Element In-Place ---");
        int[] elemArray = {3, 2, 2, 3};
        System.out.println("Original: " + Arrays.toString(elemArray) + ", Remove: 3");
        int newLen = removeElement(elemArray, 3);
        System.out.println("New length: " + newLen + " -> " + Arrays.toString(Arrays.copyOf(elemArray, newLen)));
        System.out.println();

        // 6. Reverse Vowels
        System.out.println("--- 6. Reverse Vowels ---");
        String v1 = "hello";
        String v2 = "leetcode";
        System.out.println("\"" + v1 + "\" -> " + reverseVowels(v1));
        System.out.println("\"" + v2 + "\" -> " + reverseVowels(v2));
        System.out.println();

        // 7. Squares of Sorted Array
        System.out.println("--- 7. Squares of a Sorted Array ---");
        int[] sortedWithNeg = {-4, -1, 0, 3, 10};
        System.out.println("Input : " + Arrays.toString(sortedWithNeg));
        System.out.println("Output: " + Arrays.toString(sortedSquares(sortedWithNeg)));
        System.out.println();

        // 8. Merge Sorted Arrays In-Place
        System.out.println("--- 8. Merge Two Sorted Arrays In-Place ---");
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        System.out.println("Nums1: " + Arrays.toString(nums1) + " (m=3), Nums2: " + Arrays.toString(nums2) + " (n=3)");
        mergeSortedArraysInPlace(nums1, 3, nums2, 3);
        System.out.println("Merged Nums1: " + Arrays.toString(nums1));
        System.out.println();

        // 9. 3Sum
        System.out.println("--- 9. 3Sum (Triplets Sum to 0) ---");
        int[] threeSumInput = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(threeSumInput));
        System.out.println("Unique Triplets: " + threeSum(threeSumInput));
        System.out.println();

        // 10. Trapping Rain Water
        System.out.println("--- 10. Trapping Rain Water ---");
        int[] elevationMap = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Elevation Map: " + Arrays.toString(elevationMap));
        System.out.println("Trapped Water: " + trapRainWater(elevationMap) + " units");
        System.out.println("\n===============================================================");
    }
}
