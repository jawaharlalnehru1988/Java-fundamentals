# 🧠 100+ Deep-Dive Tricky Java Interview MCQs (Master Guide)

A comprehensive compilation of **105 advanced, tricky, and deep-dive Multiple Choice Questions** designed to test subtle JVM behaviors, language specifications, edge cases, and architectural nuances in Java.

---

## 📑 Table of Contents
1. [Section 1: Primitives, Autoboxing, Promotion & Literals (Q1 – Q15)](#section-1-primitives-autoboxing-promotion--literals)
2. [Section 2: String Pool, Concatenation & Immutability (Q16 – Q30)](#section-2-string-pool-concatenation--immutability)
3. [Section 3: OOP, Inheritance, Polymorphism & Init Order (Q31 – Q45)](#section-3-oop-inheritance-polymorphism--init-order)
4. [Section 4: Exception Handling, Try-With-Resources & Finally (Q46 – Q60)](#section-4-exception-handling-try-with-resources--finally)
5. [Section 5: Generics, Wildcards & Type Erasure (Q61 – Q72)](#section-5-generics-wildcards--type-erasure)
6. [Section 6: Collections Framework & Map Internals (Q73 – Q85)](#section-6-collections-framework--map-internals)
7. [Section 7: Stream API, Lambdas & Functional Interfaces (Q86 – Q95)](#section-7-stream-api-lambdas--functional-interfaces)
8. [Section 8: Concurrency, Multithreading & Memory Model (Q96 – Q105)](#section-8-concurrency-multithreading--memory-model)

---

## Section 1: Primitives, Autoboxing, Promotion & Literals

### Q1. What is the output of the following code snippet?
```java
Integer a = 127;
Integer b = 127;
Integer c = 128;
Integer d = 128;
System.out.println((a == b) + " " + (c == d));
```
- A) `true true`
- B) `false false`
- C) `true false`
- D) `false true`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `true false`**
**Explanation:** Java caches Integer objects in the range `[-128, 127]` via the `IntegerCache`. When autoboxing `127`, both `a` and `b` reference the exact same object from the pool (`a == b` is `true`). For `128`, which is outside the cached range, two distinct heap objects are created, so `c == d` evaluates reference identity and returns `false`.
</details>

---

### Q2. What is printed by the following division operations?
```java
System.out.println(1.0 / 0.0);
System.out.println(0.0 / 0.0);
```
- A) Throws `ArithmeticException` on both lines
- B) `Infinity` followed by `NaN`
- C) `Infinity` followed by `Infinity`
- D) `NaN` followed by `ArithmeticException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `Infinity` followed by `NaN`**
**Explanation:** In IEEE 754 floating-point arithmetic (used by `float` and `double` in Java), division by zero does NOT throw `ArithmeticException`. Non-zero float divided by zero produces `Double.POSITIVE_INFINITY`, whereas `0.0 / 0.0` is undefined and yields `Double.NaN` (Not a Number).
</details>

---

### Q3. What is the result of comparing `Double.NaN`?
```java
double d = Double.NaN;
System.out.println(d == Double.NaN);
System.out.println(Double.isNaN(d));
```
- A) `true true`
- B) `false false`
- C) `false true`
- D) `true false`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `false true`**
**Explanation:** According to the IEEE 754 standard and Java Language Specification (JLS), `NaN` is not equal to any value, including itself (`NaN == NaN` is always `false`). The only reliable way to test for `NaN` is using `Double.isNaN(d)`.
</details>

---

### Q4. What is the output of the following code?
```java
int x = 010;
int y = 0x10;
int z = 0b10;
System.out.println(x + y + z);
```
- A) `30`
- B) `26`
- C) `32`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `26`**
**Explanation:** A leading `0` denotes an octal literal (`010` in base 8 is `8`). `0x` denotes hexadecimal (`0x10` in base 16 is `16`). `0b` denotes binary (`0b10` in base 2 is `2`). Total sum = `8 + 16 + 2 = 26`.
</details>

---

### Q5. What happens when running this code?
```java
short s1 = 1;
short s2 = 2;
short s3 = s1 + s2;
System.out.println(s3);
```
- A) Prints `3`
- B) Compilation error on line 3: Type mismatch (cannot convert from int to short)
- C) Prints `0`
- D) Runtime `ClassCastException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Compilation error on line 3: Type mismatch (cannot convert from int to short)**
**Explanation:** In Java binary numeric promotion, arithmetic operators (`+`, `-`, `*`, `/`) automatically promote operands smaller than `int` (`byte`, `short`, `char`) to `int`. Hence, `s1 + s2` evaluates to an `int`, which cannot be assigned to `short s3` without an explicit cast `(short)(s1 + s2)`.
</details>

---

### Q6. What does the compound assignment operator do in this case?
```java
short s = 5;
s += 10;
s = s + 10;
```
- A) Both assignments compile without issue
- B) `s += 10` causes compilation error, but `s = s + 10` compiles
- C) `s += 10` compiles (implicit cast), but `s = s + 10` causes a compilation error
- D) Both lines cause compilation errors

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `s += 10` compiles (implicit cast), but `s = s + 10` causes a compilation error**
**Explanation:** Compound assignment operators (`E1 op= E2`) automatically inject an implicit narrowing cast equivalent to `E1 = (T)(E1 op E2)`. Thus `s += 10` is equivalent to `s = (short)(s + 10)`. The plain `s = s + 10` attempts to assign an `int` to `short` and fails compilation.
</details>

---

### Q7. What will be the output of this increment expression?
```java
int i = 5;
i = i++ + ++i;
System.out.println(i);
```
- A) `11`
- B) `12`
- C) `13`
- D) `10`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `12`**
**Explanation:** Evaluation proceeds left-to-right:
1. `i++` evaluates to `5` (current value), then `i` becomes `6`.
2. `++i` increments `i` from `6` to `7`, and evaluates to `7`.
3. Sum = `5 + 7 = 12`. Finally, `i` is assigned `12`.
</details>

---

### Q8. What is printed by this character arithmetic?
```java
char c = 'A';
System.out.println(c + 1);
System.out.println(++c);
```
- A) `66` followed by `B`
- B) `B` followed by `B`
- C) `66` followed by `66`
- D) `A1` followed by `B`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `66` followed by `B`**
**Explanation:** In `c + 1`, binary numeric promotion converts `'A'` (ASCII 65) to `int 65`, producing `66`. The pre-increment `++c` mutates the `char` variable directly without changing its type, incrementing it to `'B'`.
</details>

---

### Q9. What will this method print?
```java
public static void check(Integer x, int y) {
    System.out.println("Integer, int");
}
public static void check(int x, Integer y) {
    System.out.println("int, Integer");
}
public static void main(String[] args) {
    check(10, 20);
}
```
- A) `Integer, int`
- B) `int, Integer`
- C) Compilation error: reference to check is ambiguous
- D) Runtime `NoSuchMethodError`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) Compilation error: reference to check is ambiguous**
**Explanation:** Java compiler needs to autobox one parameter to match either method. Because both require exactly one autoboxing conversion and neither is strictly more specific than the other, the compiler flags it as ambiguous.
</details>

---

### Q10. What is printed by boolean logic with assignment?
```java
boolean a = false;
boolean b = true;
if (a = b) {
    System.out.println("Condition 1");
} else {
    System.out.println("Condition 2");
}
```
- A) `Condition 2`
- B) `Condition 1`
- C) Compilation error: cannot use assignment in if statement
- D) Runtime exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `Condition 1`**
**Explanation:** In `if (a = b)`, `=` is the assignment operator (not `==`). It assigns the value of `b` (`true`) to `a`, and the entire expression evaluates to the assigned value (`true`). Hence, the `if` branch executes.
</details>

---

### Q11. What is the value of `Integer.MIN_VALUE` when negated (`-Integer.MIN_VALUE`)?
```java
System.out.println(-Integer.MIN_VALUE == Integer.MIN_VALUE);
```
- A) `false`
- B) `true`
- C) Throws `ArithmeticException`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `true`**
**Explanation:** `Integer.MIN_VALUE` is `-2147483648`. In 2's complement 32-bit arithmetic, `Integer.MAX_VALUE` is `2147483647`. Negating `-2147483648` overflows because `+2147483648` cannot be represented as a 32-bit signed integer; it wraps back to `-2147483648`.
</details>

---

### Q12. What does `0.1 + 0.2 == 0.3` evaluate to in Java?
```java
System.out.println(0.1 + 0.2 == 0.3);
```
- A) `true`
- B) `false`
- C) Compilation error
- D) Undefined

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `false`**
**Explanation:** In binary floating-point representation, `0.1` and `0.2` cannot be represented with exact precision, causing rounding errors. `0.1 + 0.2` produces `0.30000000000000004`, which is not equal to `0.3`. For exact financial calculations, `BigDecimal` must be used.
</details>

---

### Q13. What is the result of shifting negative numbers using unsigned right shift `>>>`?
```java
int x = -1;
System.out.println(x >>> 31);
```
- A) `-1`
- B) `1`
- C) `0`
- D) `2147483647`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `1`**
**Explanation:** `-1` in binary is 32 ones (`11111111 11111111 11111111 11111111`). The unsigned right shift `>>>` shifts bits to the right and zero-fills the most significant bits. Shifting by 31 positions leaves only a single `1` bit in the least significant position (`1`).
</details>

---

### Q14. What will happen when boxing a `null` `Boolean` in an `if` statement?
```java
Boolean flag = null;
if (flag) {
    System.out.println("True");
}
```
- A) Prints nothing
- B) Throws `NullPointerException` at runtime
- C) Compilation error
- D) Prints `False`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `NullPointerException` at runtime**
**Explanation:** The `if` statement expects a primitive `boolean`. The JVM attempts to unbox `flag` by calling `flag.booleanValue()`. Since `flag` is `null`, invoking any method on it triggers a runtime `NullPointerException`.
</details>

---

### Q15. Which primitive type cannot be cast to any other primitive type in Java?
- A) `byte`
- B) `char`
- C) `boolean`
- D) `float`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `boolean`**
**Explanation:** In Java, `boolean` represents a truth value and is completely incompatible with all numeric types (`byte`, `short`, `int`, `long`, `char`, `float`, `double`). A `boolean` cannot be cast to or from any numeric primitive.
</details>

---

## Section 2: String Pool, Concatenation & Immutability

### Q16. What is the output of this String equality check?
```java
String s1 = "Java";
String s2 = "Ja" + "va";
String s3 = "Ja";
String s4 = s3 + "va";
System.out.println((s1 == s2) + " " + (s1 == s4));
```
- A) `true true`
- B) `false false`
- C) `true false`
- D) `false true`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `true false`**
**Explanation:** `"Ja" + "va"` consists of two compile-time constant string literals; the Java compiler computes this at compile time as `"Java"`, resolving `s2` to the exact same String Pool instance as `s1` (`s1 == s2` is `true`). In contrast, `s3 + "va"` uses a non-final variable `s3`, so string concatenation occurs at runtime creating a new heap object (`s1 == s4` is `false`).
</details>

---

### Q17. What happens when `final` is used for compile-time concatenation?
```java
final String s1 = "Ja";
final String s2 = "va";
String s3 = s1 + s2;
String s4 = "Java";
System.out.println(s3 == s4);
```
- A) `false`
- B) `true`
- C) Compilation error
- D) Runtime Exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `true`**
**Explanation:** Because `s1` and `s2` are both declared `final` and initialized with constant expressions, the compiler treats `s1 + s2` as a compile-time constant expression. The compiler folds `s1 + s2` into `"Java"`, pointing `s3` to the String Pool.
</details>

---

### Q18. What does `String.intern()` do in this snippet?
```java
String s1 = new String("Hello");
String s2 = s1.intern();
String s3 = "Hello";
System.out.println((s1 == s2) + " " + (s2 == s3));
```
- A) `false true`
- B) `true true`
- C) `false false`
- D) `true false`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `false true`**
**Explanation:** `new String("Hello")` creates a new object on the Java heap, so `s1` refers to the heap object. Calling `s1.intern()` returns the canonical reference from the String Constant Pool. `s3` also points to the String Pool literal. Hence, `s1 == s2` is `false`, while `s2 == s3` is `true`.
</details>

---

### Q19. What is the output of string concatenation with null?
```java
String s = null;
s = s + "Java";
System.out.println(s);
```
- A) Throws `NullPointerException`
- B) `Java`
- C) `nullJava`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `nullJava`**
**Explanation:** When using the string concatenation operator `+`, if an operand is `null`, Java converts it to the literal string `"null"`. Thus `null + "Java"` results in `"nullJava"`.
</details>

---

### Q20. What is printed by this StringBuilder comparison?
```java
StringBuilder sb1 = new StringBuilder("ABC");
StringBuilder sb2 = new StringBuilder("ABC");
System.out.println(sb1.equals(sb2));
```
- A) `true`
- B) `false`
- C) Compilation error
- D) Runtime exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `false`**
**Explanation:** `StringBuilder` (and `StringBuffer`) does NOT override the `equals()` method from `java.lang.Object`. Therefore, `sb1.equals(sb2)` performs reference identity comparison (`sb1 == sb2`), which evaluates to `false` because they are two distinct objects in memory.
</details>

---

### Q21. How many objects are created by the statement: `String s = new String("Hello");` assuming "Hello" is not in the pool?
- A) 1
- B) 2
- C) 0
- D) 3

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) 2**
**Explanation:** 
1. The literal `"Hello"` is created and stored in the String Constant Pool.
2. The `new String(...)` constructor allocates a second, distinct `String` object on the heap that wraps the character data.
</details>

---

### Q22. What is the output of the following chained substring operations?
```java
String str = "Interview";
System.out.println(str.substring(3, 3).isEmpty());
```
- A) Throws `StringIndexOutOfBoundsException`
- B) `false`
- C) `true`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `true`**
**Explanation:** `substring(beginIndex, endIndex)` is valid when `0 <= beginIndex <= endIndex <= length()`. When `beginIndex == endIndex`, it returns an empty string `""`. `"".isEmpty()` returns `true`.
</details>

---

### Q23. What does `String.replace()` vs `String.replaceAll()` do?
```java
String s = "a.b.c";
System.out.println(s.replace(".", "-") + " " + s.replaceAll(".", "-"));
```
- A) `a-b-c a-b-c`
- B) `a-b-c -----`
- C) `----- a-b-c`
- D) `----- -----`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `a-b-c -----`**
**Explanation:** `replace()` treats the target as a literal character sequence and replaces all literal `.` with `-`, giving `a-b-c`. In contrast, `replaceAll()` treats the first argument as a Regular Expression, where `.` matches ANY character. Thus, every character (`a`, `.`, `b`, `.`, `c`) is replaced by `-`, yielding `-----`.
</details>

---

### Q24. What is the result of using `+` operator on primitive numbers before strings?
```java
System.out.println(10 + 20 + "Java" + 30 + 40);
```
- A) `30Java3040`
- B) `1020Java3040`
- C) `30Java70`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `30Java3040`**
**Explanation:** Evaluated left-to-right:
1. `10 + 20` -> integer addition = `30`.
2. `30 + "Java"` -> string concatenation = `"30Java"`.
3. `"30Java" + 30` -> string concatenation = `"30Java30"`.
4. `"30Java30" + 40` -> string concatenation = `"30Java3040"`.
</details>

---

### Q25. What happens when calling `str.concat(null)`?
```java
String str = "Hello";
str.concat(null);
```
- A) Results in `"Hellonull"`
- B) Throws `NullPointerException`
- C) Results in `"Hello"`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `NullPointerException`**
**Explanation:** Unlike the `+` operator which converts `null` to the string `"null"`, the `String.concat(String str)` method explicitly checks `if (str.length() == 0)` and throws a `NullPointerException` if the argument is `null`.
</details>

---

### Q26. Is `String` thread-safe in Java?
- A) No, because it does not use `synchronized` keyword
- B) Yes, because it is immutable
- C) Only when marked `volatile`
- D) No, multiple threads can alter its internal byte array

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, because it is immutable**
**Explanation:** Because `String` objects are immutable in Java (their internal value array is `final` and cannot be modified after construction), multiple threads can safely read and share instances without any external synchronization.
</details>

---

### Q27. What is printed by calling `toString()` on a `char[]` array?
```java
char[] chars = {'a', 'b', 'c'};
System.out.println(chars);
System.out.println("" + chars);
```
- A) `abc` followed by `abc`
- B) `[C@...` followed by `[C@...`
- C) `abc` followed by `[C@...`
- D) `abc` followed by `[a, b, c]`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `abc` followed by `[C@...`**
**Explanation:** `PrintStream.println(char[])` has an overloaded version specifically for `char[]` that prints the characters as a string (`abc`). However, `"" + chars` invokes `Object.toString()` on the array object, which prints its type signature and identity hashcode (`[C@...`).
</details>

---

### Q28. What will be printed by the following code?
```java
String s1 = "abc";
StringBuffer s2 = new StringBuffer(s1);
System.out.println(s1.equals(s2));
```
- A) `true`
- B) `false`
- C) Compilation error
- D) Runtime `ClassCastException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `false`**
**Explanation:** `String.equals(Object anObject)` first checks `if (this == anObject)` and then `if (anObject instanceof String)`. Since `s2` is a `StringBuffer` (not an instance of `String`), the check immediately returns `false`.
</details>

---

### Q29. What is the capacity of a default `StringBuilder` after adding 17 characters?
```java
StringBuilder sb = new StringBuilder(); // default capacity 16
sb.append("12345678901234567"); // 17 characters
System.out.println(sb.capacity());
```
- A) `17`
- B) `32`
- C) `34`
- D) `16`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `34`**
**Explanation:** Default initial capacity is `16`. When appending characters that exceed the current capacity, `StringBuilder` grows using the formula: `(oldCapacity * 2) + 2` = `(16 * 2) + 2 = 34`.
</details>

---

### Q30. What does Java 11 `String.isBlank()` return for whitespace strings?
```java
String s = "   \n\t  ";
System.out.println(s.isEmpty() + " " + s.isBlank());
```
- A) `true true`
- B) `false true`
- C) `true false`
- D) `false false`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `false true`**
**Explanation:** `isEmpty()` checks if length is strictly `0` (`false`). `isBlank()` (introduced in Java 11) checks if the string is empty or contains only Unicode whitespace code points (`true`).
</details>

---

## Section 3: OOP, Inheritance, Polymorphism & Init Order

### Q31. What is the output of the following inheritance snippet?
```java
class Parent {
    int x = 10;
    void print() { System.out.println("Parent"); }
}
class Child extends Parent {
    int x = 20;
    void print() { System.out.println("Child"); }
}
public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.x);
        p.print();
    }
}
```
- A) `20 Child`
- B) `10 Child`
- C) `10 Parent`
- D) `20 Parent`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `10 Child`**
**Explanation:** In Java, **methods are overridden dynamically at runtime** based on the actual object type (`Child`), so `p.print()` prints `"Child"`. However, **variables are NOT polymorphic** (they are shadowed/hidden). Field access is resolved at compile-time based on the reference type (`Parent`), so `p.x` accesses `Parent.x` which is `10`.
</details>

---

### Q32. Can static methods be overridden in Java?
```java
class SuperClass {
    public static void display() { System.out.println("Super"); }
}
class SubClass extends SuperClass {
    public static void display() { System.out.println("Sub"); }
}
public class Main {
    public static void main(String[] args) {
        SuperClass obj = new SubClass();
        obj.display();
    }
}
```
- A) Prints `Sub` (Static methods are overridden)
- B) Prints `Super` (Method hiding, resolved at compile-time)
- C) Compilation error
- D) Runtime `IllegalAccessError`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Prints `Super` (Method hiding, resolved at compile-time)**
**Explanation:** Static methods belong to the class, not instances. They cannot be overridden; they are only **hidden**. Calls to static methods are bound at compile-time based on the declared reference type (`SuperClass`), printing `"Super"`.
</details>

---

### Q33. What is the order of initialization when a class is instantiated?
```java
class A {
    static { System.out.print("S1 "); }
    { System.out.print("I1 "); }
    public A() { System.out.print("C1 "); }
}
class B extends A {
    static { System.out.print("S2 "); }
    { System.out.print("I2 "); }
    public B() { System.out.print("C2 "); }
}
public class InitDemo {
    public static void main(String[] args) {
        new B();
    }
}
```
- A) `S1 S2 I1 C1 I2 C2`
- B) `S1 I1 C1 S2 I2 C2`
- C) `S2 S1 I2 C2 I1 C1`
- D) `I1 C1 I2 C2 S1 S2`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `S1 S2 I1 C1 I2 C2`**
**Explanation:**
1. Parent static blocks execute first (`S1`), followed by child static blocks (`S2`).
2. Parent instance initializer blocks execute (`I1`), then parent constructor (`C1`).
3. Child instance initializer blocks execute (`I2`), then child constructor (`C2`).
</details>

---

### Q34. What is a Covariant Return Type in Java?
- A) A subclass method overriding a superclass method can return a subtype of the superclass method's return type
- B) A method can return multiple return types separated by commas
- C) A method can return `void` instead of an object
- D) A constructor can return a subclass instance

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A subclass method overriding a superclass method can return a subtype of the superclass method's return type**
**Explanation:** Since Java 5, overriding methods are allowed to return a more specific subtype than declared in the parent class (known as covariant returns). For example, if parent returns `Number`, child override can return `Integer`.
</details>

---

### Q35. What happens when an overridden method reduces access privileges?
```java
class Base {
    public void show() {}
}
class Derived extends Base {
    protected void show() {} // trying to reduce to protected
}
```
- A) Compiles successfully
- B) Compilation error: cannot reduce visibility of inherited method
- C) Runtime `SecurityException`
- D) Warning only

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Compilation error: cannot reduce visibility of inherited method**
**Explanation:** In Java method overriding, an overriding method cannot assign weaker access privileges than the overridden method in the superclass (e.g., `public` cannot be reduced to `protected` or `private`). It can only maintain or widen visibility.
</details>

---

### Q36. What is the output of this constructor chaining program?
```java
class Alpha {
    Alpha() {
        System.out.print("A ");
    }
}
class Beta extends Alpha {
    Beta() {
        this("B ");
        System.out.print("C ");
    }
    Beta(String s) {
        System.out.print(s);
    }
}
public class TestChain {
    public static void main(String[] args) {
        new Beta();
    }
}
```
- A) `A B C`
- B) `B C A`
- C) `A C B`
- D) `C B A`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `A B C`**
**Explanation:**
1. `new Beta()` calls `this("B ")`.
2. `Beta(String)` implicitly invokes `super()` (`Alpha()`), printing `"A "`.
3. `Beta(String)` completes, printing `"B "`.
4. `Beta()` resumes, printing `"C "`. Output: `"A B C "`.
</details>

---

### Q37. What happens if a class does NOT provide a no-arg constructor, but the subclass has a default constructor?
```java
class SuperClass {
    SuperClass(int x) {}
}
class SubClass extends SuperClass {
    // default no-arg constructor inserted by compiler
}
```
- A) SubClass automatically inherits `SuperClass(int x)`
- B) Compilation error in SubClass: implicit super constructor is undefined
- C) Compiles and runs fine
- D) Runtime `NoSuchMethodError`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Compilation error in SubClass: implicit super constructor is undefined**
**Explanation:** When no constructor is defined in `SubClass`, the compiler generates a default no-arg constructor that calls `super()`. Since `SuperClass` defined a parameterized constructor, the compiler removed its default no-arg constructor, making `super()` unavailable.
</details>

---

### Q38. Can an abstract class have constructors in Java?
- A) No, because abstract classes cannot be instantiated
- B) Yes, to initialize fields and allow constructor chaining from subclasses
- C) Only if all methods are concrete
- D) Only `private` constructors are allowed

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, to initialize fields and allow constructor chaining from subclasses**
**Explanation:** Abstract classes cannot be instantiated directly via `new AbstractClass()`, but they CAN have constructors. These constructors are called during subclass instantiation via `super()` to initialize state.
</details>

---

### Q39. What happens if an interface has two default methods with the exact same signature and a class implements both?
```java
interface Left { default void go() { System.out.println("Left"); } }
interface Right { default void go() { System.out.println("Right"); } }
class Center implements Left, Right {}
```
- A) Prints `Left` (first implemented interface wins)
- B) Compilation error: class Center inherits unrelated defaults for go()
- C) Prints `Right`
- D) Randomly calls either `Left` or `Right`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Compilation error: class Center inherits unrelated defaults for go()**
**Explanation:** This is the Diamond Problem with default methods. The compiler forces `Center` to explicitly override `go()` and disambiguate which interface implementation to call (e.g., `Left.super.go();`).
</details>

---

### Q40. Which of the following is true about `final` variables?
- A) A blank final instance variable must be initialized in all constructors or instance initializers
- B) A final variable can be re-assigned if its value is null
- C) Marking an array `final` makes all its elements immutable
- D) A final local variable must be initialized at declaration time

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A blank final instance variable must be initialized in all constructors or instance initializers**
**Explanation:** If an instance field is marked `final` without an inline initial value (blank final), the compiler strictly requires every constructor (or instance init block) to assign it exactly once.
</details>

---

### Q41. Can a `private` method in a parent class be overridden by a subclass?
- A) Yes, if the subclass marks it public
- B) No, private methods are not visible to subclasses and cannot be overridden
- C) Yes, if the `@Override` annotation is omitted
- D) Only if the parent class is in the same package

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, private methods are not visible to subclasses and cannot be overridden**
**Explanation:** `private` methods are bound statically at compile time and are not inherited by subclasses. Defining a method with the same signature in a subclass simply creates a new independent method; it does not override the parent's private method.
</details>

---

### Q42. What is the output of this polymorphic method call?
```java
class Vehicle {
    void drive() { System.out.print("Vehicle "); }
}
class Car extends Vehicle {
    void drive() { System.out.print("Car "); }
    void turbo() { System.out.print("Turbo "); }
}
public class Demo {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.drive();
        // ((Car)v).turbo();
    }
}
```
- A) `Vehicle`
- B) `Car`
- C) Compilation error
- D) `Vehicle Car`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `Car`**
**Explanation:** Due to dynamic method dispatch, Java invokes the runtime instance's method (`Car.drive()`), outputting `"Car "`.
</details>

---

### Q43. What happens when a method is invoked inside a constructor on an uninitialized subclass?
```java
class Base {
    Base() { test(); }
    void test() { System.out.println("Base"); }
}
class Sub extends Base {
    int value = 42;
    void test() { System.out.println("Sub: " + value); }
}
public class App {
    public static void main(String[] args) {
        new Sub();
    }
}
```
- A) `Base`
- B) `Sub: 42`
- C) `Sub: 0`
- D) `NullPointerException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `Sub: 0`**
**Explanation:**
1. `new Sub()` calls `super()` (`Base()`).
2. `Base()` calls `test()`. Because `test()` is polymorphic and the object is `Sub`, `Sub.test()` executes.
3. At this moment, `Sub`'s field initializers have NOT yet run! `value` holds its default primitive value `0`.
4. Output is `"Sub: 0"`. (Anti-pattern: Never call overridable methods in constructors!)
</details>

---

### Q44. What does the `strictfp` keyword do in Java?
- A) Restricts access to variables
- B) Forces floating-point calculations to adhere strictly to IEEE 754 across all platforms
- C) Disallows casting between primitives
- D) Enforces strict exception checking

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Forces floating-point calculations to adhere strictly to IEEE 754 across all platforms**
**Explanation:** `strictfp` ensured that floating-point operations produced identical bit-for-bit results on all CPU architectures (though in Java 17+, all floating point operations are strictly IEEE 754 by default).
</details>

---

### Q45. Which of the following members of an interface are implicitly `public static final`?
- A) All fields
- B) All methods
- C) Default methods
- D) Private methods

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) All fields**
**Explanation:** Every field declared in an interface in Java is automatically and implicitly `public static final` (constants).
</details>

---

## Section 4: Exception Handling, Try-With-Resources & Finally

### Q46. What will be returned by this method?
```java
public static int testFinally() {
    try {
        return 10;
    } finally {
        return 20;
    }
}
```
- A) `10`
- B) `20`
- C) Compilation error: duplicate return statement
- D) Throws `IllegalStateException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `20`**
**Explanation:** A `return` statement in a `finally` block overrides and discards any previous return statement or unhandled exception originating from the `try` or `catch` block.
</details>

---

### Q47. What happens if `System.exit(0)` is called inside a `try` block?
```java
try {
    System.out.println("Try");
    System.exit(0);
} finally {
    System.out.println("Finally");
}
```
- A) `Try` followed by `Finally`
- B) `Try` only
- C) `Finally` only
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `Try` only**
**Explanation:** `System.exit(0)` immediately shuts down the Java Virtual Machine. When the JVM halts, the execution thread terminates instantly and the `finally` block is never reached.
</details>

---

### Q48. What is the output of modifying a returned primitive inside a `finally` block?
```java
public static int getNumber() {
    int x = 100;
    try {
        return x;
    } finally {
        x = 200;
    }
}
```
- A) `200`
- B) `100`
- C) `0`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `100`**
**Explanation:** The `return x;` expression evaluates `x` (`100`) and places that value on the operand stack as the pending return value. The `finally` block then executes and changes local variable `x` to `200`, but without a `return` statement in `finally`, the previously saved return value (`100`) is returned.
</details>

---

### Q49. What is the closing order in a Try-With-Resources statement with multiple resources?
```java
class Res implements AutoCloseable {
    String name;
    Res(String name) { this.name = name; }
    public void close() { System.out.print(name + " "); }
}
public class TryRes {
    public static void main(String[] args) {
        try (Res r1 = new Res("R1"); Res r2 = new Res("R2")) {
            System.out.print("Body ");
        }
    }
}
```
- A) `Body R1 R2`
- B) `Body R2 R1`
- C) `R1 R2 Body`
- D) `R2 R1 Body`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `Body R2 R1`**
**Explanation:** In Java Try-With-Resources, resources are closed in the **reverse order of their creation/declaration** (LIFO - Last In First Out). Hence, `r2` is closed first, then `r1`.
</details>

---

### Q50. Can an overriding method declare a broader checked exception than the parent method?
```java
class Super {
    void process() throws IOException {}
}
class Sub extends Super {
    void process() throws Exception {} // declares broader Exception
}
```
- A) Yes, this is allowed
- B) No, compilation error: Sub.process() cannot throw broader Exception
- C) Only if it is a runtime exception
- D) Yes, if marked public

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, compilation error: Sub.process() cannot throw broader Exception**
**Explanation:** According to the Liskov Substitution Principle and JLS rules on method overriding, a subclass method cannot throw checked exceptions that are broader (superclasses) than those declared by the superclass method. It can throw fewer, narrower (subclasses), or no checked exceptions.
</details>

---

### Q51. What happens in a multi-catch block when an exception subclass is listed alongside its superclass?
```java
try {
    // some code
} catch (IOException | Exception e) { // compilation check
    e.printStackTrace();
}
```
- A) Compiles and catches both
- B) Compilation error: The exception IOException is already caught by the alternative Exception
- C) Runtime `IllegalArgumentException`
- D) Only catches IOException

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Compilation error: The exception IOException is already caught by the alternative Exception**
**Explanation:** In Java multi-catch (`catch (A | B e)`), the alternative exception types must be disjoint (neither can be a subclass/subtype of the other). Listing both `IOException` and `Exception` is redundant and illegal.
</details>

---

### Q52. What type of variable is the exception parameter `e` in a multi-catch block?
```java
catch (IOException | SQLException e) {
    // is e final?
}
```
- A) Mutable variable
- B) Implicitly `final` (cannot be reassigned)
- C) Thread-local variable
- D) Volatile variable

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Implicitly `final` (cannot be reassigned)**
**Explanation:** The exception parameter in a multi-catch statement is implicitly `final`. Any attempt to reassign `e = new IOException();` results in a compilation error.
</details>

---

### Q53. What is a "Suppressed Exception" in Java?
- A) An exception caught by an empty catch block
- B) An exception thrown while closing a resource in try-with-resources when an exception was already thrown in the try block
- C) An unchecked exception ignored by the compiler
- D) An exception disabled using JVM flags

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) An exception thrown while closing a resource in try-with-resources when an exception was already thrown in the try block**
**Explanation:** In try-with-resources, if an exception is thrown in the `try` block and another exception is thrown during `close()`, the primary exception is thrown to the caller and the second exception is attached as a suppressed exception (retrievable via `e.getSuppressed()`).
</details>

---

### Q54. What happens when an `Error` (e.g. `OutOfMemoryError`) is thrown?
- A) It cannot be caught with a `try-catch` block
- B) It can be caught with `catch (Throwable t)` or `catch (Error e)`, but is usually not recommended
- C) It automatically terminates the operating system
- D) The JVM converts it to a checked exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) It can be caught with `catch (Throwable t)` or `catch (Error e)`, but is usually not recommended**
**Explanation:** Errors inherit from `java.lang.Throwable` and can syntactically be caught using `catch (Error e)` or `catch (Throwable t)`. However, doing so is generally discouraged because Errors represent serious, unrecoverable JVM conditions.
</details>

---

### Q55. Which exception is thrown when attempting to modify an unmodifiable list created by `List.of()`?
- A) `IllegalStateException`
- B) `UnsupportedOperationException`
- C) `IllegalArgumentException`
- D) `IndexOutOfBoundsException`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `UnsupportedOperationException`**
**Explanation:** Methods that attempt structural modification (`add`, `remove`, `set`) on unmodifiable collections throw `java.lang.UnsupportedOperationException`.
</details>

---

### Q56. What is the difference between `throw` and `throws`?
- A) `throw` is used to declare an exception in method signature; `throws` throws an instance
- B) `throw` explicitly throws an exception instance; `throws` declares checked exceptions that a method might propagate
- C) Both are identical and interchangeable
- D) `throw` is for checked exceptions only; `throws` is for unchecked exceptions

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `throw` explicitly throws an exception instance; `throws` declares checked exceptions that a method might propagate**
**Explanation:** `throw` is a statement used inside a method body to instantiate and throw a `Throwable` object (`throw new RuntimeException()`), whereas `throws` is a keyword in the method signature indicating potential checked exceptions.
</details>

---

### Q57. What is printed by this exception handling code?
```java
try {
    throw new NullPointerException();
} catch (Exception e) {
    System.out.print("Caught ");
    throw new RuntimeException();
} finally {
    System.out.print("Finally ");
}
```
- A) `Caught Finally` followed by RuntimeException uncaught
- B) `Caught` followed by RuntimeException uncaught (Finally does not run)
- C) `Finally` only
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `Caught Finally` followed by RuntimeException uncaught**
**Explanation:** The `catch` block executes and prints `"Caught "`. It then throws a new `RuntimeException`. Before the method finishes propagating the exception up the call stack, the `finally` block executes, printing `"Finally "`.
</details>

---

### Q58. Does `catch (NullPointerException | RuntimeException e)` compile?
- A) Yes
- B) No, because NullPointerException is a subclass of RuntimeException
- C) Yes, but only in Java 21+
- D) Yes, if marked with @SafeVarargs

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, because NullPointerException is a subclass of RuntimeException**
**Explanation:** As per JLS multi-catch rules, alternatives cannot have a subclass-superclass relationship.
</details>

---

### Q59. Which class is the direct superclass of all Exception and Error classes in Java?
- A) `java.lang.Object`
- B) `java.lang.Throwable`
- C) `java.lang.RuntimeException`
- D) `java.lang.Exception`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `java.lang.Throwable`**
**Explanation:** `Throwable` is the root of the Java exception hierarchy. `Exception` and `Error` both directly extend `Throwable`.
</details>

---

### Q60. Can a `finally` block exist without a `catch` block?
- A) No, every try must have both catch and finally
- B) Yes, a `try-finally` block is completely valid
- C) Only if the method declares `throws Exception`
- D) Only in abstract classes

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, a `try-finally` block is completely valid**
**Explanation:** A `try` block must be followed by at least one `catch` block OR a `finally` block (or be a try-with-resources statement). `try { ... } finally { ... }` is legal and commonly used for cleanup.
</details>

---

## Section 5: Generics, Wildcards & Type Erasure

### Q61. What is Type Erasure in Java?
- A) Deleting unused class files at runtime
- B) The process where generic type information is checked at compile-time and removed (erased) from bytecode
- C) Replacing objects with null pointers during garbage collection
- D) Converting primitives to wrappers

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The process where generic type information is checked at compile-time and removed (erased) from bytecode**
**Explanation:** Java generics are implemented via Type Erasure to maintain backward compatibility with older JVM versions. Type parameters are replaced by their bounds (or `Object` if unbounded) in compiled bytecode.
</details>

---

### Q62. Why does the following code fail to compile?
```java
public void print(List<String> list) {}
public void print(List<Integer> list) {}
```
- A) Generics do not allow method overloading
- B) Both methods have the same erasure `print(List)` in bytecode
- C) List cannot be used as a parameter type
- D) Return types must be specified as String and Integer

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Both methods have the same erasure `print(List)` in bytecode**
**Explanation:** After type erasure, both methods have the identical signature: `print(java.util.List)`. Because two methods in the same class cannot have identical parameter types and names, the compiler flags a signature collision error.
</details>

---

### Q63. Is `List<Object>` a supertype of `List<String>` in Java?
- A) Yes, because Object is the superclass of String
- B) No, Java generic types are invariant (`List<String>` is NOT a `List<Object>`)
- C) Only when marked covariant with `extends`
- D) Yes, through implicit generic casting

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, Java generic types are invariant (`List<String>` is NOT a `List<Object>`)**
**Explanation:** In Java, generics are invariant. If `List<String>` were a subtype of `List<Object>`, you could assign it to `List<Object>` and add an `Integer` to a list of strings, breaking type safety.
</details>

---

### Q64. What is the PECS rule in Java Generics?
- A) Producer Extends, Consumer Super
- B) Parameter Extends, Consumer Static
- C) Polymorphic Extends, Cast Super
- D) Private Extends, Class Super

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Producer Extends, Consumer Super**
**Explanation:** Coined by Joshua Bloch (Effective Java): Use `<? extends T>` when you only READ (produce) data from a collection, and use `<? super T>` when you WRITE (consume) data into a collection.
</details>

---

### Q65. Can you create a generic array directly in Java (`new T[10]`)?
- A) Yes, if T extends Object
- B) No, because arrays are reified and need runtime type information, which is erased in generics
- C) Yes, using the `@SuppressWarnings` annotation
- D) Only for primitive types

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, because arrays are reified and need runtime type information, which is erased in generics**
**Explanation:** Arrays in Java know their component type at runtime (`reified`), whereas generics are erased at compile-time. Hence, `new T[10]` is illegal because the JVM cannot determine what array type to allocate at runtime.
</details>

---

### Q66. What can be added to a `List<? extends Number>`?
- A) `Integer` and `Double`
- B) `Number` objects
- C) Only `null`
- D) Any subclass of Number

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) Only `null`**
**Explanation:** `List<? extends Number>` could be a `List<Integer>`, `List<Double>`, or `List<BigDecimal>`. The compiler cannot guarantee type safety for any specific numeric type being added, so it forbids adding ANY object except `null`.
</details>

---

### Q67. What can be read from a `List<? super Integer>`?
- A) `Integer`
- B) `Number`
- C) `Object` only
- D) Cannot read anything

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `Object` only**
**Explanation:** `List<? super Integer>` could be a `List<Integer>`, `List<Number>`, or `List<Object>`. The only common guaranteed supertype when reading from the list is `Object`.
</details>

---

### Q68. What is a Bridge Method in Java?
- A) A method connecting Java with native C code
- B) A synthetic method generated by the compiler to preserve polymorphism when a class inherits a parameterized class/interface
- C) A method used in Design Patterns to bridge two classes
- D) A default interface method

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A synthetic method generated by the compiler to preserve polymorphism when a class inherits a parameterized class/interface**
**Explanation:** When a subclass extends a generic class or implements a generic interface (e.g. `Comparable<String>`), type erasure would cause signature mismatch in bytecode. The compiler automatically creates a synthetic "bridge method" (e.g., `compareTo(Object)` calling `compareTo(String)`).
</details>

---

### Q69. What is Heap Pollution in Java Generics?
- A) When the JVM garbage collector runs out of memory
- B) When a variable of a parameterized type refers to an object that is not of that parameterized type
- C) Allocating too many static objects
- D) Memory fragmentation in Metaspace

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) When a variable of a parameterized type refers to an object that is not of that parameterized type**
**Explanation:** Heap pollution occurs when unchecked casts or raw types cause a generic reference (e.g. `List<String>`) to point to a heap object containing different types (e.g. `Integer`), leading to `ClassCastException` on read.
</details>

---

### Q70. Can a static method access generic type parameters of its enclosing class?
```java
class Container<T> {
    public static void print(T item) {} // is this valid?
}
```
- A) Yes, static methods inherit class type parameters
- B) No, compilation error: Cannot make a static reference to non-static type T
- C) Only if T is bounded
- D) Yes, if marked synchronized

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, compilation error: Cannot make a static reference to non-static type T**
**Explanation:** The class-level type parameter `T` is tied to instance creation (`new Container<String>()`). Static methods belong to the class without an instance, so they cannot use `T`. Static methods must declare their own generic parameters: `public static <E> void print(E item)`.
</details>

---

### Q71. What does the wildcard `<?>` represent?
- A) Unknown type (equivalent to `<? extends Object>`)
- B) Any primitive type
- C) An error in generic specification
- D) Thread-safe generic reference

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Unknown type (equivalent to `<? extends Object>`)**
**Explanation:** `<?>` is an unbounded wildcard representing an unknown type. It is shorthand for `<? extends Object>`.
</details>

---

### Q72. Can primitive types (`int`, `double`) be used as generic type arguments in Java?
- A) Yes, directly
- B) No, Java generics require reference types (objects)
- C) Only in Java 21+
- D) Yes, if boxed manually

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, Java generics require reference types (objects)**
**Explanation:** Because type erasure erases type parameters to `Object` (or bounds), generic type arguments must be reference types. Primitive wrappers (`Integer`, `Double`) must be used instead.
</details>

---

## Section 6: Collections Framework & Map Internals

### Q73. What is the internal data structure of `HashMap` in Java 8+?
- A) Array of Singly Linked Lists only
- B) Array of Nodes (buckets) that convert from LinkedList to Balanced Red-Black Tree when a bucket size reaches 8
- C) Circular Doubly Linked List
- D) B-Tree

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Array of Nodes (buckets) that convert from LinkedList to Balanced Red-Black Tree when a bucket size reaches 8**
**Explanation:** In Java 8+, `HashMap` uses an array of buckets. When hash collisions cause a bucket list length to reach the `TREEIFY_THRESHOLD` (8) and total table capacity is at least 64, the linked list is converted into a Red-Black Tree (`TreeNode`), improving worst-case search from $O(N)$ to $O(\log N)$.
</details>

---

### Q74. What is the default initial capacity and load factor of a `HashMap`?
- A) Capacity: 10, Load Factor: 0.5
- B) Capacity: 16, Load Factor: 0.75
- C) Capacity: 32, Load Factor: 0.8
- D) Capacity: 8, Load Factor: 0.75

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Capacity: 16, Load Factor: 0.75**
**Explanation:** By default, `HashMap` starts with a bucket array capacity of `16` (always a power of 2) and a default load factor of `0.75` (resizes/doubles when $16 \times 0.75 = 12$ entries are added).
</details>

---

### Q75. What happens if an object used as a `HashMap` key is mutated after insertion?
- A) The HashMap automatically recalculates its bucket position
- B) The object may no longer be found when calling `get(key)` because its hash code and bucket index have changed
- C) Throws `ConcurrentModificationException`
- D) The entry is deleted automatically

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The object may no longer be found when calling `get(key)` because its hash code and bucket index have changed**
**Explanation:** If key mutation changes the result of `hashCode()`, subsequent lookups will search in the wrong bucket, resulting in `get()` returning `null` (memory leak). Keys in HashMaps should always be immutable (e.g. `String`, `Integer`, or records).
</details>

---

### Q76. What is the contract between `equals()` and `hashCode()` in Java?
- A) If two objects are equal according to `equals()`, they MUST have the same `hashCode()`
- B) If two objects have the same `hashCode()`, they MUST be equal according to `equals()`
- C) `hashCode()` is only required if `compareTo()` is overridden
- D) There is no required relationship

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) If two objects are equal according to `equals()`, they MUST have the same `hashCode()`**
**Explanation:** The fundamental contract in `java.lang.Object`: If `o1.equals(o2)` is `true`, then `o1.hashCode() == o2.hashCode()` must be `true`. The inverse is not required (different objects can share hash codes, known as a collision).
</details>

---

### Q77. What will happen when modifying an array backed by `Arrays.asList()`?
```java
String[] arr = {"A", "B", "C"};
List<String> list = Arrays.asList(arr);
list.set(0, "Z");
System.out.println(arr[0]);
```
- A) `A`
- B) `Z`
- C) Throws `UnsupportedOperationException`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `Z`**
**Explanation:** `Arrays.asList(arr)` returns a fixed-size wrapper list directly backed by the original array. Modifying elements via `set()` directly alters the underlying array `arr`. However, structural modifications (`add`, `remove`) throw `UnsupportedOperationException`.
</details>

---

### Q78. What happens when iterating over a `List` and removing elements using `list.remove()`?
```java
List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
for (Integer num : list) {
    if (num == 2) list.remove(num);
}
```
- A) Removes element 2 successfully
- B) Throws `ConcurrentModificationException`
- C) Throws `IndexOutOfBoundsException`
- D) Skips element 3 silently

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `ConcurrentModificationException`**
**Explanation:** The enhanced for-loop uses an `Iterator` behind the scenes. Modifying the list directly via `list.remove()` alters `modCount` without updating the iterator's `expectedModCount`, causing `ConcurrentModificationException` on the next iteration. Elements must be removed using `iterator.remove()` or `list.removeIf()`.
</details>

---

### Q79. Which collection maintains insertion order while providing $O(1)$ lookup performance?
- A) `TreeSet`
- B) `HashSet`
- C) `LinkedHashSet`
- D) `PriorityQueue`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) `LinkedHashSet`**
**Explanation:** `LinkedHashSet` combines a hash table for $O(1)$ lookups with a doubly linked list running through all its entries to maintain predictable insertion order.
</details>

---

### Q80. What does `ConcurrentHashMap` use in Java 8+ to achieve thread safety?
- A) A single lock on the entire map
- B) Segment-level locking with ReentrantLocks
- C) CAS (Compare-And-Swap) operations for empty buckets and `synchronized` locks on the head node of colliding buckets
- D) ReadWriteLock on each entry

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) CAS (Compare-And-Swap) operations for empty buckets and `synchronized` locks on the head node of colliding buckets**
**Explanation:** Java 8 replaced segment locking with node-level synchronization. For inserting into an empty bucket, lock-free CAS is used. If a collision occurs, only the first node of that specific bucket is locked using `synchronized`.
</details>

---

### Q81. Does `ConcurrentHashMap` allow `null` keys or `null` values?
- A) Allows null keys and null values
- B) Allows null values but not null keys
- C) Forbids BOTH null keys and null values (throws NullPointerException)
- D) Allows exactly one null key

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) Forbids BOTH null keys and null values (throws NullPointerException)**
**Explanation:** `ConcurrentHashMap` strictly prohibits both `null` keys and `null` values. In concurrent environments, `map.get(key) == null` would be ambiguous: it could mean the key is not present or the key maps to `null`.
</details>

---

### Q82. What is the difference between `Fail-Fast` and `Fail-Safe` iterators?
- A) Fail-Fast operates directly on the collection and throws `ConcurrentModificationException` on concurrent change; Fail-Safe works on a clone/snapshot
- B) Fail-Fast is thread-safe; Fail-Safe is not
- C) Fail-Fast never throws exceptions
- D) Fail-Safe iterators are deprecated

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Fail-Fast operates directly on the collection and throws `ConcurrentModificationException` on concurrent change; Fail-Safe works on a clone/snapshot**
**Explanation:** Fail-Fast iterators (e.g. `ArrayList`, `HashMap`) abort immediately on structural modification during iteration. Fail-Safe / weakly consistent iterators (e.g. `CopyOnWriteArrayList`, `ConcurrentHashMap`) iterate over a snapshot or tolerate concurrent modifications without throwing.
</details>

---

### Q83. What ordering does a `PriorityQueue` guarantee in Java?
- A) Strict FIFO (First-In, First-Out)
- B) Elements ordered according to natural sorting or specified `Comparator` (head is the least/min element)
- C) LIFO (Stack order)
- D) Insertion order

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Elements ordered according to natural sorting or specified `Comparator` (head is the least/min element)**
**Explanation:** `PriorityQueue` is backed by a binary min-heap. The element at the head of the queue is always the smallest/highest priority element.
</details>

---

### Q84. What happens when inserting `null` into a `TreeSet` with natural ordering in Java 8+?
- A) It is placed at index 0
- B) Throws `NullPointerException`
- C) Replaces the root node
- D) Silently ignored

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `NullPointerException`**
**Explanation:** `TreeSet` compares elements using `Comparable.compareTo()`. Invoking `compareTo()` on or with `null` immediately triggers a `NullPointerException`.
</details>

---

### Q85. How does `CopyOnWriteArrayList` handle write operations?
- A) Acquires a read lock
- B) Creates a fresh copy of the underlying array whenever a mutating operation (`add`, `set`, `remove`) is performed
- C) Blocks all reading threads until write finishes
- D) Writes to a separate buffer file

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Creates a fresh copy of the underlying array whenever a mutating operation (`add`, `set`, `remove`) is performed**
**Explanation:** `CopyOnWriteArrayList` makes a new clone of the array on every write. Reading operations require no locking and never throw `ConcurrentModificationException`, making it ideal for read-heavy, write-rare scenarios (e.g., event listeners).
</details>

---

## Section 7: Stream API, Lambdas & Functional Interfaces

### Q86. What is the output of the following Stream without a terminal operation?
```java
List<String> list = Arrays.asList("a", "b", "c");
list.stream().filter(s -> {
    System.out.print(s + " ");
    return true;
});
```
- A) `a b c `
- B) Prints nothing
- C) Compilation error
- D) Runtime exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Prints nothing**
**Explanation:** Streams in Java are **lazy**. Intermediate operations (like `filter`, `map`, `peek`) are not evaluated until a **terminal operation** (like `collect`, `forEach`, `count`) is invoked on the stream.
</details>

---

### Q87. Can a Stream be reused after a terminal operation has been executed?
```java
Stream<String> stream = Stream.of("A", "B", "C");
stream.forEach(System.out::print);
stream.forEach(System.out::print);
```
- A) Prints `ABCABC`
- B) Throws `IllegalStateException: stream has already been operated upon or closed`
- C) Prints `ABC` only
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `IllegalStateException: stream has already been operated upon or closed`**
**Explanation:** A Java Stream is single-use. Once a terminal operation is called, the stream pipeline is considered consumed and closed. Any subsequent operation on that same stream instance throws `IllegalStateException`.
</details>

---

### Q88. What is the difference between `map` and `flatMap` in Java Streams?
- A) `map` is for primitives; `flatMap` is for objects
- B) `map` performs 1-to-1 transformation; `flatMap` performs 1-to-N transformation and flattens nested streams/collections into a single stream
- C) `flatMap` is deprecated in Java 17
- D) `map` runs in parallel; `flatMap` is sequential

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `map` performs 1-to-1 transformation; `flatMap` performs 1-to-N transformation and flattens nested streams/collections into a single stream**
**Explanation:** `Function<T, R>` transforms each element into another object (`Stream<R>`), whereas `Function<T, Stream<R>>` in `flatMap` unpacks/flattens multiple streams into a single consolidated `Stream<R>`.
</details>

---

### Q89. What is the output of this stream reduction?
```java
int result = Stream.of(1, 2, 3, 4)
                   .reduce(10, (a, b) -> a + b);
System.out.println(result);
```
- A) `10`
- B) `20`
- C) `14`
- D) `0`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `20`**
**Explanation:** The identity element is `10`. Evaluation: `(((10 + 1) + 2) + 3) + 4 = 20`.
</details>

---

### Q90. What happens when `Collectors.toMap()` encounters duplicate keys without a merge function?
```java
List<String> list = Arrays.asList("apple", "banana", "apricot");
Map<Character, String> map = list.stream()
    .collect(Collectors.toMap(s -> s.charAt(0), s -> s));
```
- A) Overwrites the earlier key
- B) Throws `IllegalStateException: Duplicate key`
- C) Stores duplicates in a list
- D) Silently ignores the second entry

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `IllegalStateException: Duplicate key`**
**Explanation:** Both `"apple"` and `"apricot"` produce the same key `'a'`. Without a binary merge function `(existing, replacement) -> replacement`, `Collectors.toMap` throws `IllegalStateException`.
</details>

---

### Q91. What is the return type of a `@FunctionalInterface` abstract method with two arguments and a boolean return?
- A) `Function<T, R>`
- B) `BiPredicate<T, U>`
- C) `BiFunction<T, U, Boolean>`
- D) Both B and C are valid functional representations

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **D) Both B and C are valid functional representations**
**Explanation:** `BiPredicate<T, U>` is the specialized functional interface taking two arguments and returning primitive `boolean` (`(t, u) -> boolean`). `BiFunction<T, U, Boolean>` also accepts two parameters and returns boxed `Boolean`.
</details>

---

### Q92. What will `findFirst()` vs `findAny()` return on a parallel stream?
- A) Both always return the exact same element
- B) `findFirst()` guarantees returning the first element in encounter order; `findAny()` is free to return any matching element for maximum parallel performance
- C) `findAny()` throws an exception if multiple matches exist
- D) `findFirst()` cannot be used with parallel streams

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `findFirst()` guarantees returning the first element in encounter order; `findAny()` is free to return any matching element for maximum parallel performance**
**Explanation:** In parallel streams, `findFirst()` incurs a performance penalty to preserve deterministic encounter order, while `findAny()` non-deterministically returns whichever thread finds a match first.
</details>

---

### Q93. What does `IntStream.range(1, 5)` vs `IntStream.rangeClosed(1, 5)` generate?
- A) `[1, 2, 3, 4]` vs `[1, 2, 3, 4, 5]`
- B) `[1, 2, 3, 4, 5]` vs `[1, 2, 3, 4]`
- C) `[2, 3, 4]` vs `[1, 2, 3, 4, 5]`
- D) Both generate `[1, 2, 3, 4, 5]`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `[1, 2, 3, 4]` vs `[1, 2, 3, 4, 5]`**
**Explanation:** `range(start, end)` is half-open (exclusive of end: $1 \le x < 5$), while `rangeClosed(start, end)` is inclusive ($1 \le x \le 5$).
</details>

---

### Q94. Can local variables referenced inside a lambda expression be modified?
```java
int count = 0;
Runnable r = () -> {
    count++; // is this valid?
};
```
- A) Yes, lambdas have full access to mutate local variables
- B) No, compilation error: Variable used in lambda expression should be final or effectively final
- C) Only if count is marked volatile
- D) Yes, in Java 17+

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, compilation error: Variable used in lambda expression should be final or effectively final**
**Explanation:** Java lambdas capture values, not variable references. To prevent concurrency and stack frame lifecycle issues, any local variable accessed within a lambda must be explicitly `final` or effectively final (never re-assigned).
</details>

---

### Q95. What does `Collectors.partitioningBy()` always return?
- A) `Map<String, List<T>>`
- B) `Map<Boolean, List<T>>`
- C) `List<List<T>>`
- D) `Set<T>`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `Map<Boolean, List<T>>`**
**Explanation:** `partitioningBy(Predicate<T>)` classifies stream elements into exactly two groups based on a boolean predicate, always returning a map with keys `true` and `false`.
</details>

---

## Section 8: Concurrency, Multithreading & Memory Model

### Q96. What does the `volatile` keyword guarantee in Java?
- A) Mutual exclusion and atomicity of compound operations (like `count++`)
- B) Visibility of variable changes across threads (reads/writes bypass CPU caches directly to main memory) and instruction reordering prevention (happens-before relationship)
- C) Prevents deadlock
- D) Makes the variable immutable

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Visibility of variable changes across threads (reads/writes bypass CPU caches directly to main memory) and instruction reordering prevention (happens-before relationship)**
**Explanation:** `volatile` guarantees memory visibility (any write is immediately visible to other threads) and memory barrier ordering. It does **NOT** provide atomicity for compound operations like `count++` (which requires `AtomicInteger` or synchronization).
</details>

---

### Q97. What happens when `Thread.start()` is called twice on the same `Thread` instance?
```java
Thread t = new Thread(() -> System.out.println("Running"));
t.start();
t.start();
```
- A) Spawns two threads
- B) Throws `IllegalThreadStateException` at runtime
- C) Re-runs the thread after completion
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Throws `IllegalThreadStateException` at runtime**
**Explanation:** A thread in Java can only be started once in its lifecycle. Once it enters the `RUNNABLE` or `TERMINATED` state, calling `start()` again throws `IllegalThreadStateException`.
</details>

---

### Q98. What is the difference between `wait()` and `sleep()`?
- A) `wait()` releases the monitor lock and belongs to `Object`; `sleep()` keeps the lock and belongs to `Thread`
- B) `sleep()` releases the lock; `wait()` does not
- C) Both must be called inside a `synchronized` block
- D) `wait()` cannot be interrupted

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `wait()` releases the monitor lock and belongs to `Object`; `sleep()` keeps the lock and belongs to `Thread`**
**Explanation:** `Object.wait()` must be called inside a synchronized context and releases the monitor lock so other threads can enter. `Thread.sleep()` pauses the current thread without releasing any acquired locks.
</details>

---

### Q99. What happens when synchronizing on a String literal?
```java
synchronized ("LOCK") {
    // critical section
}
```
- A) Ideal practice for global locking
- B) Dangerous anti-pattern because String literals are interned in the global pool, potentially causing unintended blocking across completely unrelated libraries
- C) Throws `IllegalMonitorStateException`
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Dangerous anti-pattern because String literals are interned in the global pool, potentially causing unintended blocking across completely unrelated libraries**
**Explanation:** String literals share instances across the entire JVM via the String Pool. If two independent classes synchronize on `"LOCK"`, they unintentionally contend for the same monitor lock.
</details>

---

### Q100. Why is the Double-Checked Locking singleton pattern flawed without `volatile`?
```java
if (instance == null) {
    synchronized (Singleton.class) {
        if (instance == null) {
            instance = new Singleton();
        }
    }
}
```
- A) Throws NullPointerException
- B) Due to instruction reordering by the JIT compiler, another thread might see a non-null but partially constructed `instance`
- C) Double check is illegal syntax
- D) Synchronized block will not acquire the lock

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Due to instruction reordering by the JIT compiler, another thread might see a non-null but partially constructed `instance`**
**Explanation:** The creation `instance = new Singleton()` involves 3 steps: (1) allocate memory, (2) run constructor, (3) assign reference. Without `volatile`, steps 2 and 3 can be reordered. A second thread can observe `instance != null` before construction finishes, accessing corrupt state.
</details>

---

### Q101. What is a Deadlock in Java?
- A) When a thread is executing an infinite loop
- B) When two or more threads are blocked forever, each waiting for a lock held by the other
- C) When the CPU reaches 100% utilization
- D) When a thread throws an uncaught Exception

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) When two or more threads are blocked forever, each waiting for a lock held by the other**
**Explanation:** Deadlock occurs when Thread 1 holds Lock A and requests Lock B, while Thread 2 holds Lock B and requests Lock A. Neither thread can proceed, freezing execution indefinitely.
</details>

---

### Q102. What is the difference between `Callable<V>` and `Runnable`?
- A) `Callable` can return a value and throw checked exceptions; `Runnable` cannot
- B) `Runnable` is for thread pools; `Callable` is only for single threads
- C) `Callable` is deprecated
- D) `Runnable` returns a `Future`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `Callable` can return a value and throw checked exceptions; `Runnable` cannot**
**Explanation:** `Runnable.run()` returns `void` and cannot throw checked exceptions. `Callable<V>.call()` returns a typed result `V` and declares `throws Exception`.
</details>

---

### Q103. What is a Virtual Thread (introduced in Java 21 Project Loom)?
- A) A thread that executes inside a Docker container
- B) A lightweight user-mode thread managed by the JVM that drastically reduces the resource footprint of the thread-per-request model
- C) A simulated thread for testing
- D) A thread with priority 10

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A lightweight user-mode thread managed by the JVM that drastically reduces the resource footprint of the thread-per-request model**
**Explanation:** Traditional OS platform threads have large memory stacks (~1MB) and high context-switching costs. Virtual threads are lightweight user-space threads scheduled by the JVM on a small pool of carrier OS threads, allowing millions of concurrent threads.
</details>

---

### Q104. What does `CompletableFuture.supplyAsync()` use by default if no Executor is provided?
- A) `Executors.newSingleThreadExecutor()`
- B) `ForkJoinPool.commonPool()`
- C) `Executors.newCachedThreadPool()`
- D) Spawns a new unmanaged Thread

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `ForkJoinPool.commonPool()`**
**Explanation:** Unless an explicit `Executor` is supplied as the second argument, `CompletableFuture` executes async tasks asynchronously on the global `ForkJoinPool.commonPool()`.
</details>

---

### Q105. What is the purpose of `ThreadLocal` in Java?
- A) Creates a global lock shared across all threads
- B) Provides thread-confined isolated copies of variables so that each thread reading or writing the variable accesses its own independently initialized copy
- C) Restricts thread execution to a local machine
- D) Automatically synchronizes variable updates

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Provides thread-confined isolated copies of variables so that each thread reading or writing the variable accesses its own independently initialized copy**
**Explanation:** `ThreadLocal<T>` allocates variable storage on a per-thread basis (stored in each thread's `ThreadLocalMap`). It is widely used in frameworks for context propagation (e.g., Spring security context, transaction tokens, database connections). Always remember to call `.remove()` after use in thread pools to prevent memory leaks!
</details>

---

## 🏆 Scoring & Proficiency Benchmark

| Score Range | Proficiency Level | Evaluation |
| :--- | :--- | :--- |
| **95 – 105** | 🌟 **Java Grandmaster** | Deep mastery of JVM internals, memory model, and language specifications. |
| **80 – 94** | 🚀 **Senior Java Engineer** | Solid comprehension of concurrency, generics, collections, and streams. |
| **60 – 79** | 📈 **Intermediate Developer** | Good foundation; review edge cases on autoboxing, type erasure, and threading. |
| **Below 60** | 💡 **Learner / Junior** | Re-read the explanations, run the code snippets in the IDE, and practice! |
