package org.example.Challenges;

import java.util.Arrays;

public class CommonChallenges {

    // write a method that takes a string and returns the number of vowels in the string
    public static int countVowels(String str){
        if(str == null) return 0;
        int count = 0;
        String vowels = "aeiou";
        for(char ch : str.toLowerCase().toCharArray()){
            if(vowels.contains(ch + "")){
                count++;
            }
        }
        return count;
    }

    // write a function that takes array of strings as input and returns the longest string
    public static String longestString(String[] arr){
        if(arr == null || arr.length == 0) return null;
        String longest = arr[0];
        for(String str : arr){
            if(str.length() > longest.length()){
                longest = str;
            }
        }
        return longest;
    }

    // write a function that takes a string as input and returns the string reversed
    public static String reverseString(String str){
        if(str == null) return "";
        StringBuilder reversed = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--){
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

// Write a function that takes an array of numbers as input and returns a new array that contains only the numbers that are odd.

    public static int[] oddNumbers(int[] arr){
        if(arr == null) return new int[]{};
        int count = 0;
        for(int num : arr){
            if(num % 2 != 0){
                count++;
            }
        }
        int[] oddNumbers = new int[count];
        int index = 0;
        for(int num : arr){
            if(num % 2 != 0){
                oddNumbers[index++] = num;
            }
        }
        return oddNumbers;
    }


    public static void main(String[] args) {

        System.out.println(countVowels("John Doe"));
        System.out.println(longestString(new String[]{"John", "Doe", "Jane", "Smith", "Govindarajulu"}));
        System.out.println(reverseString("John Doe"));
        System.out.println(Arrays.toString(oddNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})));

    }
}
