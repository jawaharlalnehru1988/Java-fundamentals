package org.example.Challenges;

public class Mytest {

    public static void main(String[] args) {
        // create a number variable and assign 10 values with duplicate values
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};

        // find the duplicate values in the array

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    System.out.println("Duplicate value: " + numbers[j]);
                }
            }
        }

        // create a variable to store the duplicate value

        // create a variable to store the count of the duplicate value

        // loop through the array



    }

}
