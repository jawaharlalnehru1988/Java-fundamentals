package org.example.Challenges;

public class StringChallenges {
    //1. Write a function that takes a string as input and returns the number of vowels in the string
    public static int countVowels(String str){
        if(str == null) return 0;
        int count = 0;
        String vowels = "aeiou";
        for(char ch : str.toLowerCase().toCharArray()){
            if(vowels.contains(String.valueOf(ch))){
//            if(vowels.contains(ch + "")){
                count++;
            }
        }
        return count;
    }

    //2. Write a function that takes an array of strings as input and returns the longest string
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

    //3. Write a function that takes a string as input and returns the string reversed
    public static String reverseString(String str){
        if(str == null) return "";
        StringBuilder reversed = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--){
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    //4. Write a function that takes a string as input and returns a new string with all the vowels removed
//    public static String removeVowels(String str){
//        if(str == null) return "";
//        StringBuilder result = new StringBuilder();
//        String vowels = "aeiou";
//        for(char ch : str.toCharArray()){
//            if(!vowels.contains(ch + "")){
//                result.append(ch);
//            }
//        }
//        return result.toString();
//    }

    //Method 2
    public static String removeVowel(String str){
        if(str == null) return "";

        StringBuilder rmVowel = new StringBuilder();
        String vowel = "aeiou";
        for(String val : str.split("")){
            if(!vowel.contains(val)){
                rmVowel.append(val);
            }
        }

        return rmVowel.toString();

    }

    //5. Write a function that takes a string as input and returns true if the string is a palindrome
//    public static boolean isPalindrome(String str){
//        if(str == null) return false;
//        int left = 0;
//        int right = str.length() - 1;
//        while(left < right){
//            if(str.charAt(left++) != str.charAt(right--)){
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isPalindrome(String str){
        if(str == null) return false;

        for(int left = 0, right = str.length()-1; left < right; left++, right--){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }

        }
        return true;
    }

    //6. Write a function that takes a string as input and returns the first non-repeating character in the string
    public static char firstNonRepeatingChar(String str){
        if(str == null) return ' ';
        int[] freq = new int[26];
        for(char ch : str.toCharArray()){
            freq[ch - 'a']++;
        }
        for(char ch : str.toCharArray()){
            if(freq[ch - 'a'] == 1){
                return ch;
            }
        }
        return ' ';
    }

    //7. Write a function that takes a string as input and returns the number of words in the string

//    public static int countWords(String str){
//        if(str == null) return 0;
//        String[] words = str.trim().split("\\s+");
//        return words.length;
//    }

    //8. Write a function that takes a string as input and the string with all duplicate characters removed
    public static String removeDuplicates(String str){
        if(str == null) return "";
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256];
        for(char ch : str.toCharArray()){
            if(!seen[ch]){
                result.append(ch);
                seen[ch] = true;
            }
        }
        return result.toString();
    }



    public static void main(String[] args) {
        //  Test countVowels
        System.out.println(countVowels("hello"));

//        //  Test longestString
//        String[] arr = {"John", "Doe", "Jane", "Smith"};
//
//        // Test reverseString
//        System.out.println(reverseString("hello"));
//
//        // Test removeVowels
//        System.out.println(removeVowels("hello"));
//
//        // Test isPalindrome
//        System.out.println(isPalindrome("hello"));
//
//        // Test firstNonRepeatingChar
//        System.out.println(firstNonRepeatingChar("hello"));
//
//        // Test countWords
//        System.out.println(countWords("hello world"));





    }
}
