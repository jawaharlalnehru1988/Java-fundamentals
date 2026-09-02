package org.example.Challenges;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ============================================================================
 * INTERVIEW CODING CHALLENGES: OBJECT STREAM & DATA PROCESSING
 * ============================================================================
 * Topics Covered:
 * 1. Filter Objects by Attribute (Age, Salary, Job Role)
 * 2. Transform Object List to Map (e.g. Age -> Person, Name -> Salary)
 * 3. Group Objects by Field (e.g. Group by Job Role or Location)
 * 4. Find Object with Maximum / Minimum Field Value (Highest Paid Employee)
 * 5. Calculate Summary Statistics (Average / Total Salary)
 * ============================================================================
 */
public class ObjectChallenges {

    // ========================================================================
    // CHALLENGE 1: Filter Persons by Age and Salary
    // ========================================================================

    public static List<Person> filterByAgeGreaterThan(List<Person> people, int age) {
        if (people == null) return Collections.emptyList();
        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getAge() > age)
                .collect(Collectors.toList());
    }

    public static List<Person> filterByJobAndSalary(List<Person> people, String job, double minSalary) {
        if (people == null) return Collections.emptyList();
        return people.stream()
                .filter(Objects::nonNull)
                .filter(p -> p.getJob() != null && p.getJob().equalsIgnoreCase(job))
                .filter(p -> p.getSalary() >= minSalary)
                .collect(Collectors.toList());
    }

    // ========================================================================
    // CHALLENGE 2: Convert List of Objects to Map
    // ========================================================================

    /**
     * Converts a List of Person into a Map of Name -> Salary
     */
    public static Map<String, Double> mapNameToSalary(List<Person> people) {
        if (people == null) return Collections.emptyMap();
        return people.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        Person::getName,
                        Person::getSalary,
                        (existing, replacement) -> existing // Merge strategy for duplicate names
                ));
    }

    /**
     * Converts a List of Person into a Map of Age -> Person
     */
    public static Map<Integer, Person> mapAgeToPerson(List<Person> people) {
        if (people == null) return Collections.emptyMap();
        return people.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        Person::getAge,
                        p -> p,
                        (existing, replacement) -> existing
                ));
    }

    // ========================================================================
    // CHALLENGE 3: Group Objects by Attribute (groupingBy)
    // ========================================================================

    /**
     * Groups employees by their job title
     */
    public static Map<String, List<Person>> groupByJob(List<Person> people) {
        if (people == null) return Collections.emptyMap();
        return people.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Person::getJob));
    }

    // ========================================================================
    // CHALLENGE 4: Find Person with Highest Salary
    // ========================================================================

    public static Optional<Person> findHighestPaidPerson(List<Person> people) {
        if (people == null) return Optional.empty();
        return people.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(Person::getSalary));
    }

    // ========================================================================
    // CHALLENGE 5: Calculate Average Salary
    // ========================================================================

    public static double calculateAverageSalary(List<Person> people) {
        if (people == null || people.isEmpty()) return 0.0;
        return people.stream()
                .filter(Objects::nonNull)
                .mapToDouble(Person::getSalary)
                .average()
                .orElse(0.0);
    }

    // ========================================================================
    // MAIN METHOD: Demo & Test Runner for YouTube
    // ========================================================================
    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("      JAVA CODING CHALLENGES: OBJECT DATA PROCESSING DEMO      ");
        System.out.println("===============================================================\n");

        List<Person> staff = List.of(
                new Person("John", 25, "Tester", "Chennai", 35000),
                new Person("Mike", 30, "Developer", "Bangalore", 65000),
                new Person("David", 35, "Manager", "Mumbai", 95000),
                new Person("Sam", 40, "Tester", "Delhi", 42000),
                new Person("Smith", 45, "Developer", "Pune", 78000)
        );

        // 1. Filtering Objects
        System.out.println("--- 1. Filter by Age > 30 ---");
        filterByAgeGreaterThan(staff, 30)
                .forEach(p -> System.out.println("  - " + p.getName() + ", Age: " + p.getAge()));
        System.out.println();

        System.out.println("--- Filter Developers with Salary >= 70,000 ---");
        filterByJobAndSalary(staff, "Developer", 70000)
                .forEach(p -> System.out.println("  - " + p.getName() + " (" + p.getJob() + "), Salary: " + p.getSalary()));
        System.out.println();

        // 2. Map Conversions
        System.out.println("--- 2. Map Name -> Salary ---");
        Map<String, Double> nameSalaryMap = mapNameToSalary(staff);
        nameSalaryMap.forEach((name, salary) -> System.out.println("  " + name + " -> $" + salary));
        System.out.println();

        // 3. Grouping by Job Title
        System.out.println("--- 3. Grouping by Job Role ---");
        Map<String, List<Person>> byJob = groupByJob(staff);
        byJob.forEach((job, members) -> {
            System.out.println("  Role: " + job);
            members.forEach(m -> System.out.println("    * " + m.getName() + " (" + m.getLocation() + ")"));
        });
        System.out.println();

        // 4. Highest Earner
        System.out.println("--- 4. Highest Paid Employee ---");
        findHighestPaidPerson(staff).ifPresent(p ->
                System.out.println("  Top Earner: " + p.getName() + " with salary $" + p.getSalary())
        );
        System.out.println();

        // 5. Average Salary
        System.out.println("--- 5. Average Salary ---");
        System.out.printf("  Average Salary across all staff: $%.2f%n", calculateAverageSalary(staff));
        System.out.println();
    }
}
