package org.example.Challenges;

import java.util.Arrays;
import java.util.List;

public class ObjectChallenges {

    public static double calculateAveAgeImpr(List<Person> people){
        int totalAge = 0;

        for(Person person: people){
            totalAge += person.getAge();
        }

        return people.isEmpty() ? 0 : (double) totalAge/people.size();
    }

    public static double calculateAveAgeStream(List<Person> people){
        return people.stream().mapToInt(Person::getAge).average().orElse(0);
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Achyuth", 30),
                new Person("Mukunda", 10),
                new Person("Narayana", 70),
                new Person("Murari", 35)
        );

        //Imperative method
        double averageAge = ObjectChallenges.calculateAveAgeImpr(people);
        System.out.println(averageAge   );
        //Stream with lambda expression
        double averageAgeStrem = ObjectChallenges.calculateAveAgeStream(people);
        System.out.println(averageAgeStrem );
    }
}
