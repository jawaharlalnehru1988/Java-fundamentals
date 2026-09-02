# Java Interview Coding Challenges Master Guide

This package contains organized, production-grade, and deduplicated coding interview challenges for Java developers. Each class includes dual implementations (Classic Loops/Two-Pointers vs Modern Java 8+ Streams), time/space complexity notes, and ready-to-run formatted `main()` test runners for YouTube demonstrations.

---

## 📁 Challenges Index

| File | Primary Topics & Highlights |
| :--- | :--- |
| [`StringChallenges.java`](./StringChallenges.java) | Reverse string, Palindrome, Vowels/Consonants counter, Remove vowels, Longest string, First non-repeating char, Anagrams, Remove duplicate chars, Word counter, Prefix/Suffix/Regex filtering. |
| [`ArrayChallenges.java`](./ArrayChallenges.java) | Find duplicates (HashSet, Streams, Loops), In-place duplicate removal (Two Pointers), Filter Evens/Odds, Range/Threshold filtering, Min & Max finding, In-place array reversal. |
| [`StreamAndFilterChallenges.java`](./StreamAndFilterChallenges.java) | Filter by length range, Clean null/empty/blank strings, Case-insensitive matching, Uppercase & Suffix mapping, Custom & Chained `Predicate<T>` (`and`, `or`, `negate`), `Stream.toList()` vs `Collectors.toList()` mutability caveats. |
| [`RecursionChallenges.java`](./RecursionChallenges.java) | Factorial, Fibonacci series, Sum of digits, Exponentiation (Standard vs Fast $O(\log N)$), Recursive string reversal. |
| [`SearchingChallenges.java`](./SearchingChallenges.java) | Linear search on unsorted arrays, Binary search (Iterative and Recursive) on sorted arrays with boundary overflow safety. |
| [`ObjectChallenges.java`](./ObjectChallenges.java) | Filtering Person objects by age/salary, Converting List to Map (`Name -> Salary`, `Age -> Person`), `Collectors.groupingBy` on fields, Finding max earner with `maxBy`, Calculating averages. |
| [`Person.java`](./Person.java) | Reusable POJO model with Lombok (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`). |

---

## 🚀 How to Run Demos

Run the `main` method in any of the challenge files. Each will output clearly formatted sections, making it effortless to record coding walkthroughs or explain concepts step-by-step.
