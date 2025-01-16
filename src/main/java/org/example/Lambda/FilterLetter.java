package org.example.Lambda;
import java.util.*;
import java.util.stream.Collectors;

public class  FilterLetter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Hari", "Krishna", "mukunda", "murari", "jagannath", "Achyuth", "Anantha", "Adhi");
//
        List<String> filteredNames = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
        System.out.println(filteredNames);

//        List<Person> people = Arrays.asList(
//                new Person("Ram", 73),
//                new Person("Krishna", 42),
//                new Person("Ram kumar", 54)
//        );
//
//        Collections.sort(people, (p1, p2)-> Integer.compare(p2.age, p1.age) );
//        for (Person person : people){
//            System.out.println(person);
//        }

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//         List<Integer> newNumber = numbers.stream().map(age -> age * age).collect(Collectors.toList());
//        System.out.println(newNumber);

//        List<Integer> numbers = Arrays.asList(10, 45, 32, 67, 5, 89);
//        int MaxNum = numbers.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
//        int MinNum = numbers.stream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
//
//        System.out.println("maximum: " + MaxNum);
//        System.out.println("minimun: " + MinNum);

//        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 10,15, 3, 20, 80));
//
//        numbers.removeIf(num -> num < 10);
//        System.out.println(numbers);

//        List<String> words = Arrays.asList("Hi", "Hello", "World", "Java", "code");
//        List<String> newWord = words.stream().filter(name -> name.length() > 3).collect(Collectors.toList());
//        System.out.println(newWord);

//        List<String> words = Arrays.asList("Java", "is", "awesome");
//        String word = words.stream().reduce("", (acc, worded) -> acc + " " + worded );
//        System.out.println(word);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 3, 7, 8);
//        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());
//        System.out.println(distinctNumbers);
//        //sort the distinct numbers

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> sortedNumbers = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedNumbers);

//        List<Person> people = Arrays.asList(
//                new Person("Radhanath", 16),
//                new Person("Gopinath", 18),
//                new Person("Tulasi Das", 16),
//                new Person("Maruthi", 18)
//        );
//
//        int totalAge = 0;
//
//        for(Person person: people){
//            totalAge += person.getAge();
//        }
//
//        if(people.isEmpty()){
//            System.out.println( "no value are there");
//        } else {
//            System.out.println( (double) totalAge/ people.size());
//        }

    }
}
