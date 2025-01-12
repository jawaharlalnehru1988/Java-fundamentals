package org.example.ScannerClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your name: ");
//        String name = scanner.next();
//        System.out.println("Enter your age: ");
//        int age = scanner.nextInt();
//
//        System.out.println("Name: " + name + ", Age: " + age);
//        scanner.close();

//        String data = "42 true 3.14 Hare krishna";
//
//        Scanner scanner = new Scanner(data);
//        int number = scanner.nextInt();
//        boolean flag = scanner.nextBoolean();
//        double pi = scanner.nextDouble();
//        String firstName = scanner.next();
//        String lastName = scanner.next();
//
//        System.out.println("Number: " + number);
//        System.out.println("Boolean: " + flag);
//        System.out.println("Double: " + pi);
//        System.out.println("Name: " + firstName + " " + lastName);
//
//        scanner.close();

//        try{
//            File file = new File("input.txt");
//            Scanner scanner = new Scanner(file);
//
//            while (scanner.hasNextLine()){
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//                scanner.close();
//        } catch (FileNotFoundException e){
//            System.out.println("file not found " );
//            e.printStackTrace();
//        }

//        String input = "apple banana cherry";
//        Scanner scanner = new Scanner(input);
//
//        while (scanner.hasNext()){
//            String token = scanner.next();
//            System.out.println(token);
//        }
//        scanner.close();

//        String input = "First Line\nSecond Line\nThird Line";
//        Scanner scanner = new Scanner(input);
//
//        while (scanner.hasNextLine()){
//            String line = scanner.nextLine();
//            System.out.println(line);
//        }
//
//        scanner.close();

//        String input = "apple,banana,cherry";
//
//        Scanner scanner = new Scanner(input);
//
//        scanner.useDelimiter(",");
//        while(scanner.hasNext()){
//            String str = scanner.next();
//            System.out.println(str);
//        }
//            scanner.close();

        String input = "apple1orange2banana3";
        Scanner scanner = new Scanner(input);

        scanner.useDelimiter("\\d");

        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }

        scanner.close();

    }
}
