# Java Interview Coding Challenges Master Guide

This package contains organized, production-grade, and deduplicated coding interview challenges for Java developers. Each class includes dual implementations (Classic Loops/Two-Pointers vs Modern Java 8+ Streams), time/space complexity notes, and ready-to-run formatted `main()` test runners for YouTube demonstrations.

---

## 📁 Challenges Index

| File | Primary Topics & Highlights |
| :--- | :--- |
| [`StringChallenges.java`](./StringChallenges.java) | Reverse string, Palindrome, Vowels/Consonants counter, Remove vowels, Longest string, First non-repeating char, Anagrams, Remove duplicate chars, Word counter, Prefix/Suffix/Regex filtering. |
| [`ArrayChallenges.java`](./ArrayChallenges.java) | Dual-paradigm solutions (Imperative Loops/Pointers vs Java 8+ Streams) for: Find duplicates (HashSet vs groupingBy), Remove duplicates (LinkedHashSet, Two-Pointers, `distinct()`), Filter Evens/Odds & Partitioning, Range/Threshold filtering, Min/Max (`IntSummaryStatistics`), Reversal (In-Place vs Stream), Sum/Average, Search & Predicate matching. |
| [`TwoPointerChallenges.java`](./TwoPointerChallenges.java) | Top Two-Pointer interview patterns: Converging pointers (Two Sum II, Valid Palindrome, Container With Most Water, Reverse Vowels, Squares of Sorted Array, 3Sum, Trapping Rain Water), Fast & Slow / Read & Write pointers (Move Zeroes, Remove Element), and Backward Merging. |
| [`StreamChallenges.java`](./StreamChallenges.java) | **55 Comprehensive Stream API Problems**: String & regex filtering, FlatMap & Transformations, Multi-level sorting & slicing (Top N, 2nd highest/lowest), Reductions & `IntSummaryStatistics`, GroupingBy, Partitioning, Character & Word frequencies, First non-repeating/repeating chars, Fibonacci & Prime generators, Stream mutability (`Stream.toList()` vs `Collectors.toList()`). |
| [`RecursionChallenges.java`](./RecursionChallenges.java) | Factorial, Fibonacci series, Sum of digits, Exponentiation (Standard vs Fast $O(\log N)$), Recursive string reversal. |
| [`SearchingChallenges.java`](./SearchingChallenges.java) | Linear search on unsorted arrays, Binary search (Iterative and Recursive) on sorted arrays with boundary overflow safety. |
| [`ObjectChallenges.java`](./ObjectChallenges.java) | Filtering Person objects by age/salary, Converting List to Map (`Name -> Salary`, `Age -> Person`), `Collectors.groupingBy` on fields, Finding max earner with `maxBy`, Calculating averages. |
| [`Person.java`](./Person.java) | Reusable POJO model with Lombok (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`). |
| [`TrickyJavaMCQs.md`](./TrickyJavaMCQs.md) | **105 Deep-Dive Tricky Java Interview MCQs**: Testing JVM internals, Integer cache, floating-point NaN quirks, String Pool, Class init order, try/finally behaviors, Generics PECS & type erasure, HashMap treeification & ConcurrentHashMap CAS, Stream laziness & parallel traps, volatile & Java Memory Model. |

---

## 🚀 How to Run Demos

Run the `main` method in any of the challenge files. Each will output clearly formatted sections, making it effortless to record coding walkthroughs or explain concepts step-by-step.
