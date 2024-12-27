package org.example.Collections;

import org.example.OOP.Contructor.Student;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListObj {
    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        // Adding elements to the ArrayList
//        names.add("James");
//        numbers.add(1);
//        students.add(new Student("John", 1));
//
//        // Adding elements at a specific index
//        names.add(1, "Jane");
//        numbers.add(1, 2);
//        students.add(1, new Student("Doe", 2));
//
        // Adding multiple elements to the ArrayList
        String[] fruits = {"Apple", "Banana", "Orange"};
        names.addAll(Arrays.asList(fruits));

//        int[] nums = {1, 2, 3};
//        numbers.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        //-----or----

        Integer[] integers = {1, 2, 3};
        numbers.addAll(Arrays.asList(integers));

        Student[] studentArray = {new Student("John", 1), new Student("Doe", 2)};
        students.addAll(Arrays.asList(studentArray));


        // Add multiple elements at a specific index
//        names.addAll(1, Arrays.asList(fruits));
//        numbers.addAll(1, Arrays.stream(nums).boxed().collect(Collectors.toList()));
//        students.addAll(1, Arrays.asList(studentArray));

        // forEach loop to print the elements
//        names.forEach(System.out::println);
//        numbers.forEach(System.out::println);
//        students.forEach(System.out::println);

        //addFirst
//        names.addFirst("Achyuth");
//        numbers.addFirst(10);
//        students.addFirst(new Student("John", 1));
//
        //addLast
//        names.addLast("Mukunda");
//        numbers.addLast(20);
//        students.addLast(new Student("Deva", 2));


        // for loop
//        for (String name : names) {
//            System.out.println(name);
//        }

        // for loop
//        for (Integer number : numbers) {
//            System.out.println(number);
//        }

        // for loop
//        for (Student student : students) {
//            System.out.println(student);
//        }

        // Accessing elements using get() method
//        System.out.println(names.get(0));
//        System.out.println(numbers.get(0));
//        System.out.println(students.get(0));

        // getFirst
//        System.out.println(names.getFirst());
//        System.out.println(numbers.getFirst());
//        System.out.println(students.getFirst());

        // getLast
//        System.out.println(names.getLast());
//        System.out.println(numbers.getLast());
//        System.out.println(students.getLast());


        // Checking the size of the ArrayList
//        System.out.println(names.size());
//        System.out.println(numbers.size());
//        System.out.println(students.size());

        // update element at a specific index
//        names.set(0, "Achyuth");
//        numbers.set(0, 10);
//        students.set(0, new Student("John", 1));

        // Removing all elements from the ArrayList
//        names.clear();
//        numbers.clear();
//        students.clear();


        // Removing elements from the ArrayList
//        names.remove(0);
//        numbers.remove(0);
//        students.remove(0);

        // Removing elements using the remove() method
//        names.remove("Jane");
//        numbers.remove(Integer.valueOf(2));
//        students.remove(new Student("Doe", 2));

        // Removing elements using the removeAll() method
//        names.removeAll(Arrays.asList(fruits));
//        numbers.removeAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
//        students.removeAll(Arrays.asList(studentArray));

        // Removing elements using the removeIf() method
//        names.removeIf(name -> name.startsWith("J"));
//        numbers.removeIf(number -> number % 2 == 0);
//        students.removeIf(student -> student.getName().startsWith("J"));

        // ensuring capacity. Increases the capacity of the ArrayList to at least the specified value
//        names.ensureCapacity(20);
//        numbers.ensureCapacity(20);
//        students.ensureCapacity(20);

        // Trimming the capacity of the ArrayList . Reduces the capacity of the ArrayList to its current size, saving memory.
//        names.trimToSize();
//        numbers.trimToSize();
//        students.trimToSize();


        // hashcode
//        System.out.println(names.hashCode());
//        System.out.println(numbers.hashCode());
//        System.out.println(students.hashCode());

        // Checking if the ArrayList is empty
//        System.out.println(names.isEmpty());
//        System.out.println(numbers.isEmpty());
//        System.out.println(students.isEmpty());



        // iterator on names
//        Iterator<String> iterator = names.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        //iterator on numbers
//        Iterator<Integer> iterator = numbers.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        //iterator on students
//        Iterator<Student> iterator = students.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        // listIterator on names
//        ListIterator<String> listIterator = names.listIterator();
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }

        // listIterator on numbers
//        ListIterator<Integer> listIterator = numbers.listIterator();
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }

        // listIterator on students
//        ListIterator<Student> listIterator = students.listIterator();
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }

        //listIterator on names at a specific index
//        ListIterator<String> listIterator = names.listIterator(1);
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }

        //listIterator on numbers at a specific index
//        ListIterator<Integer> listIterator = numbers.listIterator(1);
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }

        //listIterator on students at a specific index
//        ListIterator<Student> listIterator = students.listIterator(1);
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }


        //replaceAll elements in the ArrayList

//        names.replaceAll(name -> name.toUpperCase());
//        numbers.replaceAll(number -> number * 2);
//        students.replaceAll(student -> new Student(student.getName().toUpperCase(), student.getRollNumber() * 2));

      // retainAll elements in the ArrayList (keeps only the elements that are in the specified collection)

//        names.retainAll(Arrays.asList(fruits));
//        numbers.retainAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
//        students.retainAll(Arrays.asList(studentArray));

        // Sorting the ArrayList
//        names.sort(String::compareTo);
//        numbers.sort(Integer::compareTo);
//        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        // SubList of the ArrayList

//        List<String> subList = names.subList(0, 2);
//        List<Integer> subList = numbers.subList(0, 2);
//        List<Student> subList = students.subList(0, 2);

        // toArray() method
//        String[] namesArray = names.toArray(new String[0]);
//        Integer[] numbersArray = numbers.toArray(new Integer[0]);
//        Student[] studentsArray = students.toArray(new Student[0]);

        // toArray() method
//        Object[] namesArray = names.toArray();
//        Object[] numbersArray = numbers.toArray();
//        Object[] studentsArray = students.toArray();


        // equals() method
//        ArrayList<String> names2 = new ArrayList<>();
//
//        names2.addAll(Arrays.asList(fruits));
//        System.out.println(names.equals(names2));

        // equals() method
//        ArrayList<Integer> numbers2 = new ArrayList<>();
//      numbers2.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
//        System.out.println(numbers.equals(numbers2));

        // equals() method
//        ArrayList<Student> students2 = new ArrayList<>();
//        students2.addAll(Arrays.asList(studentArray));
//        System.out.println(students.equals(students2));

        // clone() method

//        ArrayList<String> names2 = (ArrayList<String>) names.clone();
//        ArrayList<Integer> numbers2 = (ArrayList<Integer>) numbers.clone();
//        ArrayList<Student> students2 = (ArrayList<Student>) students.clone();

        // contains() method

//        System.out.println(names.contains("Apple"));
//        System.out.println(numbers.contains(1));
//        System.out.println(students.contains(new Student("John", 1)));

        // containsAll() method

//        System.out.println(names.containsAll(Arrays.asList(fruits)));
//        System.out.println(numbers.containsAll(Arrays.stream(nums).boxed().collect(Collectors.toList())));
//        System.out.println(students.containsAll(Arrays.asList(studentArray)));

        // indexOf() method

//        System.out.println(names.indexOf("Apple"));
//        System.out.println(numbers.indexOf(1));
//        System.out.println(students.indexOf(new Student("John", 1)));

        // lastIndexOf() method

//        System.out.println(names.lastIndexOf("Apple"));
//        System.out.println(numbers.lastIndexOf(1));
//        System.out.println(students.lastIndexOf(new Student("John", 1)));

        // removeFirst() method

//        names.removeFirst();
//        numbers.removeFirst();
//        students.removeFirst();

        // removeLast() method

//        names.removeLast();
//        numbers.removeLast();
//        students.removeLast();

        // setFirst() method

//        names.setFirst("Achyuth");
//        numbers.setFirst(10);
//        students.setFirst(new Student("John", 1));

        // setLast() method

//        names.setLast("Mukunda");
//        numbers.setLast(20);
//        students.setLast(new Student("Deva", 2));

        // toArray() method

//        Object[] namesArray = names.toArray();
//        Object[] numbersArray = numbers.toArray();
//        Object[] studentsArray = students.toArray();

        // toArray() method

//        String[] namesArray = names.toArray(new String[0]);
//        Integer[] numbersArray = numbers.toArray(new Integer[0]);
//        Student[] studentsArray = students.toArray(new Student[0]);

        // toArray() method

        //stream().forEach()

//        names.stream().forEach(System.out::println);
//        numbers.stream().forEach(System.out::println);
//        students.stream().forEach(System.out::println);

        //stream().map()

//        names.stream().map(String::toUpperCase).forEach(System.out::println);
//        numbers.stream().map(number -> number * 2).forEach(System.out::println);
//        students.stream().map(student -> new Student(student.getName().toUpperCase(), student.getRollNumber() * 2)).forEach(System.out::println);

        //stream().filter()

//        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
//        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
//        students.stream().filter(student -> student.getName().startsWith("J")).forEach(System.out::println);

        //stream().collect()

//        List<String> namesList = names.stream().collect(Collectors.toList());  System.out.println(namesList);
//        List<Integer> numbersList = numbers.stream().collect(Collectors.toList());  System.out.println(numbersList);
//        List<Student> studentsList = students.stream().collect(Collectors.toList());  System.out.println(studentsList);

        //stream().count()

//        System.out.println(names.stream().count());
//        System.out.println(numbers.stream().count());
//        System.out.println(students.stream().count());

        //stream().distinct()

//        names.add("Apple");
//        names.add("Banana");
//        names.add("Apple");
//
//        names.stream().distinct().forEach(System.out::println);

        //stream().dropWhile()

//        names.stream().dropWhile(name -> name.startsWith("A")).forEach(System.out::println);
//        numbers.stream().dropWhile(number -> number % 2 == 0).forEach(System.out::println);
//        students.stream().dropWhile(student -> student.getName().startsWith("J")).forEach(System.out::println);

        //stream().findAny()

//        System.out.println(names.stream().findAny());
//        System.out.println(numbers.stream().findAny());
//        System.out.println(students.stream().findAny());

        //stream().findFirst()

//        System.out.println(names.stream().findFirst());
//        System.out.println(numbers.stream().findFirst());
//        System.out.println(students.stream().findFirst());

        //stream().flatMap()

//        List<String> namesList = new ArrayList<>();
//        namesList.add("Apple");
//        namesList.add("Banana");
//        namesList.add("Orange");
//
//        List<String> namesList2 = new ArrayList<>();
//        namesList2.add("Cherry");
//        namesList2.add("Berry");
//        namesList2.add("Grape");
//
//        List<List<String>> namesList3 = new ArrayList<>();
//        namesList3.add(namesList);
//        namesList3.add(namesList2);
//
//        namesList3.stream().flatMap(Collection::stream).forEach(System.out::println);
//
        //stream().max()

//        System.out.println(names.stream().max(String::compareTo));
//        System.out.println(numbers.stream().max(Integer::compareTo));
//        System.out.println(students.stream().max((s1, s2) -> s1.getName().compareTo(s2.getName())));

        //stream().min()

//        System.out.println(names.stream().min(String::compareTo));
//        System.out.println(numbers.stream().min(Integer::compareTo));
//        System.out.println(students.stream().min((s1, s2) -> s1.getName().compareTo(s2.getName())));

        //stream().noneMatch()

//        System.out.println(names.stream().noneMatch(name -> name.startsWith("Z")));
//        System.out.println(numbers.stream().noneMatch(number -> number == 10));
//        System.out.println(students.stream().noneMatch(student -> student.getName().startsWith("Z")));

        //stream().peek()

//        names.stream().peek(System.out::println).collect(Collectors.toList());
//        numbers.stream().peek(System.out::println).collect(Collectors.toList());
//        students.stream().peek(System.out::println).collect(Collectors.toList());

        //stream().reduce()

//        System.out.println(names.stream().reduce((s1, s2) -> s1 + s2));
//        System.out.println(numbers.stream().reduce((n1, n2) -> n1 + n2));
//        System.out.println(students.stream().reduce((s1, s2) -> new Student(s1.getName() + s2.getName(), s1.getRollNumber() + s2.getRollNumber())));

        //stream().skip()

//        names.stream().skip(2).forEach(System.out::println);
//        numbers.stream().skip(2).forEach(System.out::println);
//        students.stream().skip(2).forEach(System.out::println);

        //stream().sorted()

//        names.stream().sorted().forEach(System.out::println);
//        numbers.stream().sorted().forEach(System.out::println);
//        students.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).forEach(System.out::println);

        //stream().toArray()

//        Object[] namesArray = names.stream().toArray();
//        Object[] numbersArray = numbers.stream().toArray();
//        Object[] studentsArray = students.stream().toArray();

        //stream().anyMatch()

//        System.out.println(names.stream().anyMatch(name -> name.startsWith("A")));
//        System.out.println(numbers.stream().anyMatch(number -> number % 2 == 0));
//        System.out.println(students.stream().anyMatch(student -> student.getName().startsWith("J"));

        //stream().allMatch()

//        System.out.println(names.stream().allMatch(name -> name.startsWith("A")));
//        System.out.println(numbers.stream().allMatch(number -> number % 2 == 0));
//        System.out.println(students.stream().allMatch(student -> student.getName().startsWith("J"));

        //stream().forEachOrdered()

//        names.stream().forEachOrdered(System.out::println);
//        numbers.stream().forEachOrdered(System.out::println);
//        students.stream().forEachOrdered(System.out::println);

        //stream().limit()

//        names.stream().limit(2).forEach(System.out::println);
//        numbers.stream().limit(2).forEach(System.out::println);
//        students.stream().limit(2).forEach(System.out::println);

        //stream().mapToInt()

//        names.stream().mapToInt(String::length).forEach(System.out::println);
//        numbers.stream().mapToInt(Integer::intValue).forEach(System.out::println);
//        students.stream().mapToInt(Student::getRollNumber).forEach(System.out::println);

        //stream().mapToLong()

//        names.stream().mapToLong(String::length).forEach(System.out::println);
//        numbers.stream().mapToLong(Integer::longValue).forEach(System.out::println);
//        students.stream().mapToLong(Student::getRollNumber).forEach(System.out::println);

        //stream().mapToDouble()

//        names.stream().mapToDouble(String::length).forEach(System.out::println);
//        numbers.stream().mapToDouble(Integer::doubleValue).forEach(System.out::println);
//        students.stream().mapToDouble(Student::getRollNumber).forEach(System.out::println);









    }
}


