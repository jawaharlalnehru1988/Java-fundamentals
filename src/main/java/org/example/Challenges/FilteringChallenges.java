package org.example.Challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringChallenges {

    public static String[] fruits = {"Apple", "Banana", "pomogranate", "orange", "grape", "cherry", "fig"};
    // Problem: Find all strings with a length greater than a certain value.

    // With for loop

//    public static List<String> findFruitsForloop(String[] strArr, int value){
//        if (strArr == null) return null;
//
//        List<String> filteredStr = new ArrayList<>();
//
//        for (int i = 0; i < strArr.length; i++) {
//            if (strArr[i].length() > value) {
//                filteredStr.add(strArr[i]);
//            }
//        }
//
//        return filteredStr;
//
//    }
//


//    public static List<String> findFruitsForloop(String[] strArr, int value){
//        if (strArr == null) return null;
//
//        List<String> filteredStr = new ArrayList<>();
//
//    for(String str: strArr){
//        if (str.length() > value) {
//            filteredStr.add(str);
//        }
//    }
//        return filteredStr;
//
//    }

//    exception handling

    //Filter Strings by Length with exception handling
//    public static List<String> findFruitsForloop(String[] strArr, int value){
//        if (strArr == null) return null;
//
//        List<String> filteredStr = Arrays.stream(strArr).filter(str -> str.length() > value).toList();
//
//        try {
//            filteredStr.add("NewFruit");
//        } catch (UnsupportedOperationException e){
//            System.out.println("Add operation not supported: " + e.getMessage());
//        }
//
//        try {
//            filteredStr.remove(0);
//        } catch (UnsupportedOperationException e){
//            System.out.println("Remove operation not supported: " + e.getMessage());
//        }
//
//        try {
//            filteredStr.set(0, "updateFruit");
//        } catch (UnsupportedOperationException e){
//            System.out.println("Updation operation not supported: " + e.getMessage());
//        }
//        return filteredStr;
//    }

    //Filter Empty Strings
//public static String[] flowers = {"jasmine", "", "champe", "", "lotus"};
//
//    public static String[] filterflowers(String[] floArr){
//        if (floArr == null) {
//            return null;
//        }
//           List<String> resultStr = Arrays.stream(floArr).filter(s -> !s.isEmpty()).toList();
//                String[] finalArr = resultStr.toArray(new String[0]);
//                return finalArr;
//
//    }

   //Filter Strings Containing a Specific Substring
//public static String[] fruitArr = {"apple", "banana", "apricot", "grape"};
//
//    public static String[] getSubstrinFruit(String[] floArr) {
//        if (floArr == null) return null;
//        List<String> filtArr = Arrays.stream(floArr).filter(s -> s.contains("an")).toList();
//        String[] resultant = filtArr.stream().toArray(String[]::new);
//        return resultant;
//    }

    // Filter Strings by Regex: Problem: Find strings that match a certain pattern (e.g., numeric strings).

//    public static String[] strings = {"123", "abc", "456", "789xyz"};
//
//    public static String[] removeNums(String[] strArr){
//        if(strArr == null) return null;
//
//        List<String> valueStr = Arrays.stream(strArr).filter(s -> s.matches("\\d+")).toList();
//        String[] strings1 = valueStr.stream().toArray(String[]::new);
//        return strings1;
//
//    }

//    Filter Strings Ignoring Case: Find all strings equal to "apple" (case-insensitive).
//   public static String[] strings = {"apple", "Apple", "banana", "APPLE"};
//
//   public static List<String> filterIgnoreCase(String[] strArr){
//       if(strArr == null) return null;
//
////       return Arrays.stream(strArr).filter(s -> s.equalsIgnoreCase("apple")).toList();
//
//       List<String> rest = new ArrayList<>();
//       for (String str: strArr){
//           if (str.equalsIgnoreCase("apple")) {
//           rest.add(str);
//           }
//       }
//       return rest;
//
//   }


    //Filter Palindromic Strings  : Filter all the strings that are palindromes

//   public static String[] strings = {"madam", "apple", "racecar", "banana"};
//
//   public static String[] filterPalindrome(String[] strarr){
//       if (strarr == null) return null;
//
//       List<String> filered = Arrays.stream(strarr).filter(s -> new StringBuilder(s).reverse().toString().equals(s)).toList();
//       return filered.stream().toArray(String[]::new);
//
//   }


//    public static String[] strings = {"a", "apple", "banana", "cat", "dog"};
//
//    public static String[] rangeString(String[] arr){
//        if(arr == null) return null;
//
//        List<String> rangestr = Arrays.stream(arr).filter(s -> s.length() > 2 && s.length() < 7).toList();
//        return rangestr.stream().toArray(String[]::new);
//    }

//    public static String[] strings = {"hari kumar", "ram", "raghu veer", "chandra"};
//
//    public static String[] removeSpacedStr(String[] str){
//        if (str == null || str.length == 0) return null;
//
//        List<String> arr = Arrays.stream(str).filter(s -> !s.contains(" ")).toList();
//        return arr.stream().toArray(String[]::new);
//    }

// Filter based on custom predicate

//    public static String[] strings = {"apple", "banana", "cherry"};
//
//   public static String[] filterOnPredicate(String[] str){
//       if(str == null) return null;
//       Predicate<String> fruit = s -> s.length() > 5;
//
//       List<String> result = Arrays.stream(str).filter(fruit).toList();
//       return result.stream().toArray(String[]::new);
//   }

// Remove all null strings
//    public static String[] strings = {"apple", null, "banana", null, "grape"};
//
//    public static String[] removeNull(String[] str){
//        if(str == null) return null;
//
//        List<String> list = Arrays.stream(str).filter(Objects::nonNull).toList();
//        return list.toArray(String[]::new);
//
//    }

    // Filter even numbers

//    public static int[] numbers = {1, 2, 3, 4, 5, 6};

//    public static int[] filterEven(int[] nums){
//        if(nums == null) return null;
//
//        List<Integer> numList = new ArrayList<>();
//
//        for (int num : nums){
//            if (num % 2 == 0)
//            numList.add(num);
//        }
//        return numList.stream().mapToInt(Integer::intValue).toArray();
//    }

//    2. Filter Odd Numbers

//    public static int[] numbers = {1, 2, 3, 4, 5, 6};
//
//    public static int[] filterOdd(int[] nums){
//        if(nums == null) return null;
//
//        List<Integer> listNum = Arrays.stream(nums).filter(n -> n % 2 != 0).boxed().collect(Collectors.toList());
//
//        return listNum.stream().mapToInt(Integer::intValue).toArray();
//    }

//    3. Filter Numbers Greater Than a Value

//    public static int[] numbers = {1, 5, 10, 15, 20};
//
//    public static int[] greatThanNum(int[] nums){
//        if (nums == null && nums.length == 0) return null;
//
//
//        List<Integer> resultNum = Arrays.stream(nums).filter( n -> n > 10).boxed().toList();
//            return resultNum.stream().mapToInt(Integer::intValue).toArray();
//
//    }

//    4. Filter Numbers in a Range
//    public static Integer[] nums= {5, 10, 15, 20, 30};
//
//    public static Integer[] rangeFilter(Integer[] nums){
//        if(nums == null) return null;
//
//        Predicate<Integer> rangeVal = n -> n > 10 && n < 30;
//        List<Integer> filterRange = Arrays.stream(nums).filter(rangeVal).toList();
//
//        return filterRange.toArray(Integer[]::new);
//    }

    //5. Remove Duplicate Numbers

//    public static int[] numbers = {1, 2, 2, 3, 4, 4, 5};
//
//    public static int[] removeDuplicate(int[] nums){
//        if(nums == null) return null;
//
//        List<Integer> numList = Arrays.stream(nums).distinct().boxed().toList();
//
//
////        List<Integer> numList = new ArrayList<>();
////
////        for (int num : nums){
////            if(!numList.contains(num)){
////                numList.add(num);
////            }
////        }
//
//        return numList.stream().mapToInt(Integer::intValue).toArray();
//    }

    public static int[] numbers = {-3, -2, 0, 1, 2, 3};

    public static int[] negativeFilter(int[] nums){
        if(nums == null) return null;

        List<Integer> newNums = Arrays.stream(nums).filter(n -> n > 0).boxed().toList();
        return newNums.stream().mapToInt(Integer::intValue).toArray();
    }





    public static void main(String[] args) {

        // test the filter which is with
//        List<String> resultArr1 = findFruitsForloop(fruits, 5);
//        System.out.println(resultArr1);

        // test the filter flower method

//        System.out.println(Arrays.toString(filterflowers(flowers)));

//        System.out.println(Arrays.toString(getSubstrinFruit(fruitArr)));

//        System.out.println(Arrays.toString(removeNums(strings)));

//        System.out.println(filterIgnoreCase(strings));

//        System.out.println(Arrays.toString(filterPalindrome(strings)));

//        System.out.println(Arrays.toString(rangeString(strings)));

//        System.out.println(Arrays.toString(removeSpacedStr(strings)));

//        System.out.println(Arrays.toString(filterOnPredicate(strings)));

//        System.out.println(Arrays.toString(removeNull(strings)));

//        System.out.println(Arrays.toString(filterEven(numbers)));

//        System.out.println(Arrays.toString(filterOdd(numbers)));

//        System.out.println(Arrays.toString(greatThanNum(numbers)));

//        System.out.println(Arrays.toString(rangeFilter(nums)));

//        System.out.println(Arrays.toString(removeDuplicate(numbers)));

//        System.out.println(Arrays.toString(negativeFilter(numbers)));










    }
}
