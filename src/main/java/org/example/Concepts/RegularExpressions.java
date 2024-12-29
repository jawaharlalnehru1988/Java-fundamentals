package org.example.Concepts;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegularExpressions {
    public static void main(String[] args) {

//        1. Literals
        // "apple" matches "apple"


        //2. Meta characters with specific meanings;

        //  .(dot) Matches any single character except a newline
            //Example: a.c matches "abc", "a1c".

//        String regex = "asa.cff";
//        String input = "asagcff";
//        System.out.println(input.matches(regex));

        // *: Matches zero or more of the preceding character
            //Example: a* matches "", "a", "aa".

//        String regex = "ab*";
//        String input = "abb";
//        System.out.println(input.matches(regex));

        // +: Matches one or more of the preceding character
            // Example: a+ matches "a", "aa"

//        String regex = "ab+";
//        String input = "abbbbb";
//        System.out.println(input.matches(regex));

        //?: matches one or zero preceding character
            // Example: a? matches "", "a"

//        String regex = "ab?";
//        String input = "ab";
//        System.out.println(input.matches(regex));

        //^: Matches the beginning ot a string.
            // Example: ^abc matches "abc" at the start.

//        String[] words = {"apple", "apricot", "banana", "cherry", "apartment", "pear"};
//        String regex = "^ch";
//        Pattern pattern = Pattern.compile(regex);
//        for (String word : words) {
//            if (pattern.matcher(word).find()) {
//                System.out.println(word);
//            }
//        }

//        List<String> filteredWords = Arrays.stream(words)
//                .filter(word -> pattern.matcher(word).find())
//                .collect(Collectors.toList());

        //$: Matches the end of the string.
            // Example: abc$ matches "abc" at the end.

//        String[] words = {"apple", "apricot", "banana", "cherry", "apartment", "pear"};
//        String regex = "cot$";
//        Pattern pattern = Pattern.compile(regex);
//        for (String word : words) {
//            if (pattern.matcher(word).find()) {
//                System.out.println(word);
//            }
//        }

//        Use case variations
        String[] words = {"apple", "apricot", "banana", "cherry", "apartment", "pear"};
        String regex = "a.*t";
        Pattern pattern = Pattern.compile(regex);
        for (String word : words) {
            if (pattern.matcher(word).find()) {
                System.out.println(word);
            }
        }


        //[]: Mathces any one character inside the brackets
            // Example: [aeiou] matches "a", "e", "i", "o", "u"

        // |: Matches either the expression before or after
            // Example cat|dog matches "cat" or "dog".

        // \: Escapes meta characters.
            // Example \. matche a literal dot.


//        3. Quantifiers

        // Define the number of occurances of a pattern:

//        {n}: exactly n occurances.
            // Example: a{3} matches "aaa".

        // {n,}: At least n occurances.
            //Example: a{2, } matches "aa", "aaa".

        // {n,m}: Between n and m occurances.
            //Example: a{2, 4} matches "aa", "aaa". "aaaa".

        // 4. Character classes: Represents sets of characters;

//        \d: Matches any digit ([0-9]).
//        \D: Matches any non-digit.
//        \w: Matches any word character ([a-zA-Z0-9_]).
//        \W: Matches any non-word character.
//        \s: Matches any white space.
//        \S: Matches any not white space

//        5. Groups and Backreferences
//        ( ... ): Groups expressions.
              // Example: (abc)+ matches "abc", "abcabc".
//       \n: Backreference to the n-th group.
              // Example: (\\d)\\1 matches repeated digits like "11".




    }
}
