package org.example.Challenges;

import java.util.List;

public class FilteringChallenges {
    public static void main(String[] args) {
        // 1. Create a list of persons
        List<Person> people = List.of(
                new Person("Achyuth", 30),
                new Person("Mukunda", 10),
                new Person("Narayana", 70),
                new Person("Murari", 35)
        );
        // 2. Filter out persons with age less than 18

//            people.stream()
//                    .filter(person -> person.getAge() > 18)
//                    .forEach(person -> System.out.println(person.getName()));

        // 3. Filter out persons with age greater than 60

//            people.stream()
//                    .filter(person -> person.getAge() < 60)
//                    .forEach(person -> System.out.println(person.getName()));
        // 4. Print the names of the persons

//            people.stream()
//                    .map(Person::getName)
//                    .forEach(System.out::println);

        // 5. Print the names of the persons in uppercase

//            people.stream().map(person -> person.getName().toUpperCase()).forEach(System.out::println);

            // 6. Print the names of the persons in uppercase whose age is less than 18
//            people.stream().filter(person -> person.getAge() < 18).map(person -> person.getName().toUpperCase()).forEach(System.out::println);

        // 7. Print the names of the persons in uppercase whose age is greater than 60
//            people.stream().filter(person -> person.getAge() > 60).map(person -> person.getName().toUpperCase()).forEach(System.out::println);

            // 8. Print the names of the persons in uppercase whose age is between 18 and 60 with for loop
            for (Person person : people){
                if(person.getAge() > 18 && person.getAge() < 60){
                    System.out.println(person.getName().toUpperCase());
                }

            }

    }

}
