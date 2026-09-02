# ☕ Core Java OOP Common Interview MCQs (Master Guide)

A comprehensive compilation of **100 standard, essential, and foundational Object-Oriented Programming (OOP) Multiple Choice Questions** with clear, conceptual explanations for quick revision, interview preparation, and YouTube tutorials.

---

## 📑 Table of Contents
1. [Section 1: Classes, Objects & Memory Layout (Q1 – Q10)](#section-1-classes-objects--memory-layout)
2. [Section 2: Constructors & Object Initialization (Q11 – Q20)](#section-2-constructors--object-initialization)
3. [Section 3: The `static` Keyword & Memory Scope (Q21 – Q30)](#section-3-the-static-keyword--memory-scope)
4. [Section 4: Encapsulation & Access Modifiers (Q31 – Q40)](#section-4-encapsulation--access-modifiers)
5. [Section 5: Inheritance & Super Keyword (Q41 – Q50)](#section-5-inheritance--super-keyword)
6. [Section 6: Polymorphism: Overloading & Overriding (Q51 – Q62)](#section-6-polymorphism-overloading--overriding)
7. [Section 7: Abstraction & Abstract Classes (Q63 – Q74)](#section-7-abstraction--abstract-classes)
8. [Section 8: Interfaces & Multiple Inheritance (Q75 – Q86)](#section-8-interfaces--multiple-inheritance)
9. [Section 9: Association, Composition & Aggregation (Q87 – Q94)](#section-9-association-composition--aggregation)
10. [Section 10: Enums & Design Patterns in OOP (Q95 – Q100)](#section-10-enums--design-patterns-in-oop)

---

## Section 1: Classes, Objects & Memory Layout

### Q1. What is a Class in Java?
- A) A physical instance allocated on the JVM Heap
- B) A blueprint, template, or prototype from which objects are created
- C) A primitive data type
- D) A thread executing in the JVM

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A blueprint, template, or prototype from which objects are created**
**Explanation:** A class defines the fields (state) and methods (behavior) that its objects will possess. It acts as a user-defined blueprint.
</details>

---

### Q2. Where are objects physically stored in Java memory?
- A) Call Stack
- B) Heap Memory
- C) CPU Registers
- D) Native Method Stack

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Heap Memory**
**Explanation:** All objects in Java created using the `new` keyword are dynamically allocated on the **Heap**. Reference variables that point to these objects are stored on the **Stack**.
</details>

---

### Q3. What does the `this` keyword refer to in Java?
- A) The parent superclass object
- B) The current instance of the class executing the method or constructor
- C) The static class object in Metaspace
- D) The JVM main thread

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The current instance of the class executing the method or constructor**
**Explanation:** `this` is a reference variable in Java that refers directly to the current object whose method or constructor is being invoked.
</details>

---

### Q4. What happens when an object reference is set to `null`?
```java
CustomerOrder order = new CustomerOrder();
order = null;
```
- A) The object is deleted from memory immediately
- B) The reference variable stops pointing to the object on the Heap, making the object eligible for Garbage Collection
- C) Compilation error
- D) Memory leak error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The reference variable stops pointing to the object on the Heap, making the object eligible for Garbage Collection**
**Explanation:** Setting a reference to `null` severs the link. If no other active references point to that Heap object, the JVM's Garbage Collector will reclaim its memory during the next GC cycle.
</details>

---

### Q5. What are the two primary components of an Object in OOP?
- A) Interfaces and Packages
- B) State (Attributes/Fields) and Behavior (Methods)
- C) Pointers and Addresses
- D) Compilers and Interpreters

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) State (Attributes/Fields) and Behavior (Methods)**
**Explanation:** An object models real-world entities through **State** (data stored in instance variables) and **Behavior** (actions performed through instance methods).
</details>

---

### Q6. Can a class exist without creating any objects of that class?
- A) No, every class must have an object created
- B) Yes, a class is simply code/blueprint loaded into memory; instantiating objects is optional
- C) Only if the class is abstract
- D) Only in Java 21

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, a class is simply code/blueprint loaded into memory; instantiating objects is optional**
**Explanation:** A class can be loaded by the JVM to provide utility functions (e.g. `Math`), constants, or static entry points without ever creating instances.
</details>

---

### Q7. What is an Anonymous Object in Java?
- A) An object created without a class
- B) An object instantiated without assigning it to a named reference variable (e.g. `new Order().process();`)
- C) A corrupted object on the Heap
- D) A private object

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) An object instantiated without assigning it to a named reference variable (e.g. `new Order().process();`)**
**Explanation:** Anonymous objects are used when an object is needed for a single method call and does not need to be stored in a variable for later use.
</details>

---

### Q8. What is the default value of an uninitialized instance variable of type `int`, `double`, `boolean`, and `Object reference`?
- A) `0`, `0.0`, `false`, `null`
- B) `null`, `null`, `null`, `null`
- C) `1`, `1.0`, `true`, `null`
- D) Garbage values

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `0`, `0.0`, `false`, `null`**
**Explanation:** Unlike local variables (which must be initialized before use), instance variables on the Heap are automatically given default values by the JVM upon object creation.
</details>

---

### Q9. What does the `new` operator do in Java?
- A) Declares a variable type
- B) Allocates memory for a new object on the Heap, initializes its fields, and returns a reference to that memory location
- C) Imports a package
- D) Compiles the class file

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Allocates memory for a new object on the Heap, initializes its fields, and returns a reference to that memory location**
**Explanation:** `new` dynamically allocates memory on the Heap and invokes the constructor to initialize the newly allocated object.
</details>

---

### Q10. What is the difference between `==` and `.equals()` when comparing two objects?
- A) `==` compares references (memory addresses); `.equals()` compares logical values/content (when overridden)
- B) `==` compares content; `.equals()` compares addresses
- C) They are completely identical in all classes
- D) `==` only works for Strings

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `==` compares references (memory addresses); `.equals()` compares logical values/content (when overridden)**
**Explanation:** By default, `Object.equals()` uses `==` (reference identity). Classes like `String`, `Integer`, or custom POJOs override `.equals()` to compare meaningful data.
</details>

---

## Section 2: Constructors & Object Initialization

### Q11. What is the primary purpose of a Constructor in Java?
- A) To destroy objects from memory
- B) To initialize the state of a newly created object at the time of instantiation
- C) To inherit methods from another class
- D) To make a class static

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) To initialize the state of a newly created object at the time of instantiation**
**Explanation:** A constructor runs automatically when `new ClassName()` is executed, setting up initial field values and validating parameters.
</details>

---

### Q12. What is the return type of a constructor in Java?
- A) `void`
- B) `int`
- C) Constructors do NOT have any return type (not even `void`)
- D) `Object`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **C) Constructors do NOT have any return type (not even `void`)**
**Explanation:** If you add a return type (e.g. `public void Student()`), the compiler treats it as a regular method, NOT a constructor!
</details>

---

### Q13. When does the Java compiler provide a default (no-argument) constructor?
- A) Always in every class
- B) ONLY when NO other constructor (parameterized or custom) is explicitly defined in the class
- C) Only when the class is public
- D) Only in abstract classes

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) ONLY when NO other constructor (parameterized or custom) is explicitly defined in the class**
**Explanation:** If you define even one parameterized constructor, the compiler removes its default no-arg constructor. If you still need a no-arg constructor, you must write it explicitly.
</details>

---

### Q14. What is Constructor Overloading?
- A) Defining multiple constructors in the same class with the same name but different parameter lists (count, types, or order)
- B) Overriding a parent constructor in a subclass
- C) Calling a constructor from a method
- D) Having more than 10 constructors

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Defining multiple constructors in the same class with the same name but different parameter lists (count, types, or order)**
**Explanation:** Overloading provides multiple ways to initialize an object (e.g. creating a `DatabaseConfig` with all parameters or using defaults).
</details>

---

### Q15. How do you perform Constructor Chaining within the same class?
- A) Using `super()`
- B) Using `this(...)` as the very FIRST statement inside the constructor
- C) By calling the constructor by name like a regular method
- D) Using `new this()`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Using `this(...)` as the very FIRST statement inside the constructor**
**Explanation:** `this(...)` delegates initialization from one constructor to another within the same class, preventing duplicate code. It must be the first line of the constructor body.
</details>

---

### Q16. What is a Copy Constructor?
- A) A constructor generated by the compiler
- B) A constructor that creates a new object by copying the fields from an existing instance of the same class
- C) A constructor that duplicates classes
- D) A constructor used in serialization only

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A constructor that creates a new object by copying the fields from an existing instance of the same class**
**Explanation:** e.g. `public DatabasePoolConfig(DatabasePoolConfig source) { this.host = source.host; ... }`. It is safer and cleaner than `Object.clone()`.
</details>

---

### Q17. Can a constructor be declared `private`?
- A) No, constructors must be public
- B) Yes, private constructors prevent direct instantiation from outside the class (commonly used in Singleton pattern and Utility classes)
- C) Only in abstract classes
- D) Only in interfaces

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, private constructors prevent direct instantiation from outside the class (commonly used in Singleton pattern and Utility classes)**
**Explanation:** Declaring a constructor `private` ensures external classes cannot instantiate it via `new` (e.g. `java.lang.Math` or Singleton classes).
</details>

---

### Q18. What is the rule regarding the position of `this()` or `super()` inside a constructor?
- A) It can be placed anywhere in the constructor body
- B) It MUST be the very first statement in the constructor body
- C) It must be the last statement
- D) It cannot be used inside constructors

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) It MUST be the very first statement in the constructor body**
**Explanation:** The Java language specification mandates that parent/delegated construction happens before any custom subclass logic executes.
</details>

---

### Q19. Can a constructor call both `this()` and `super()` in the same constructor body?
- A) Yes, in any order
- B) No, because both `this()` and `super()` must be the first statement, which is syntactically impossible
- C) Yes, if both are private
- D) Only in Java 21

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, because both `this()` and `super()` must be the first statement, which is syntactically impossible**
**Explanation:** A constructor can contain either `this(...)` (to chain within the class) OR `super(...)` (to call parent constructor), but never both in the same constructor.
</details>

---

### Q20. What is an Instance Initialization Block in Java?
- A) A block marked with `static`
- B) A code block `{ ... }` defined inside a class outside any method that runs every time an object is instantiated, right before the constructor executes
- C) A block inside main method
- D) A database initialization script

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A code block `{ ... }` defined inside a class outside any method that runs every time an object is instantiated, right before the constructor executes**
**Explanation:** Instance initializers run on every `new` call before the constructor body executes, useful for sharing code across all overloaded constructors.
</details>

---

## Section 3: The `static` Keyword & Memory Scope

### Q21. Where are `static` variables stored in Java memory?
- A) On the Thread Call Stack
- B) In the Metaspace (Class Metadata area) / Class storage
- C) Inside each individual object on the Heap
- D) In the Garbage Collector nursery

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) In the Metaspace (Class Metadata area) / Class storage**
**Explanation:** Static variables belong to the **Class** itself, not to individual instances. Only a single shared copy exists in memory.
</details>

---

### Q22. How should a `static` method or variable be accessed according to Java best practices?
- A) Using an object instance (`obj.staticMethod()`)
- B) Directly using the Class Name (`ClassName.staticMethod()`)
- C) Through reflection only
- D) By instantiating a new thread

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Directly using the Class Name (`ClassName.staticMethod()`)**
**Explanation:** While accessing via an instance compiles, it is an anti-pattern because static members belong to the class, not the instance.
</details>

---

### Q23. Why can a `static` method NOT access instance variables or use `this` directly?
- A) Because static methods are private
- B) Because static methods belong to the class and can execute before any object instance exists on the Heap
- C) Because static methods are slower
- D) Java security restrictions

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Because static methods belong to the class and can execute before any object instance exists on the Heap**
**Explanation:** Since a static method can run without an object instance, there is no `this` reference and no specific instance variables to read from.
</details>

---

### Q24. When does a `static` initialization block execute?
- A) Every time a new object is created
- B) Exactly ONCE when the class is first loaded into memory by the JVM ClassLoader
- C) When the garbage collector runs
- D) When the JVM shuts down

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Exactly ONCE when the class is first loaded into memory by the JVM ClassLoader**
**Explanation:** `static { ... }` blocks execute once during class initialization, making them ideal for loading native libraries, drivers, or static configuration files.
</details>

---

### Q25. Can you override a `static` method in Java?
- A) Yes, static methods support full runtime polymorphism
- B) No; defining a static method with the same signature in a subclass results in **Method Hiding**, not Method Overriding
- C) Only if the method is public
- D) Only in interfaces

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No; defining a static method with the same signature in a subclass results in **Method Hiding**, not Method Overriding**
**Explanation:** Method overriding relies on dynamic dispatch at runtime based on the actual object on the Heap. Static methods are resolved at compile-time based on the reference type (Method Hiding).
</details>

---

### Q26. What is a Static Nested Class?
- A) A class that cannot be compiled
- B) A nested class declared with `static` that does NOT hold an implicit reference to an enclosing outer class instance
- C) An inner class that can only have static methods
- D) An anonymous class

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A nested class declared with `static` that does NOT hold an implicit reference to an enclosing outer class instance**
**Explanation:** Unlike non-static inner classes, a static nested class can be instantiated independently (`new Outer.StaticNested()`) without creating an outer instance first.
</details>

---

### Q27. What is a constant in Java and how is it typically declared?
- A) `static String name;`
- B) `public static final <Type> CONSTANT_NAME = value;`
- C) `const int x = 10;`
- D) `private volatile int x;`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `public static final <Type> CONSTANT_NAME = value;`**
**Explanation:** `static` makes it shared across all instances; `final` prevents re-assignment; `public` makes it globally accessible.
</details>

---

### Q28. What happens to static variables when multiple threads access them simultaneously?
- A) Java automatically synchronizes all static variables
- B) Static variables are shared across all threads, making them susceptible to race conditions unless properly synchronized or atomic
- C) Each thread gets its own copy of the static variable
- D) The JVM throws a ConcurrentModificationException

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Static variables are shared across all threads, making them susceptible to race conditions unless properly synchronized or atomic**
**Explanation:** Because static variables live in shared Metaspace/Heap, concurrent writes must use `AtomicInteger`, `synchronized`, or locks for thread safety.
</details>

---

### Q29. Can a top-level class (outer class) be declared as `static` in Java?
- A) Yes, any class can be static
- B) No, only nested/inner classes can be declared `static`
- C) Only if it contains the main method
- D) Only in packages starting with java.*

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, only nested/inner classes can be declared `static`**
**Explanation:** Top-level outer classes can only have `public` or package-private (default) access modifiers.
</details>

---

### Q30. What is a `static import` in Java?
- A) Importing a .class file from disk
- B) A feature allowing static members (methods and fields) to be used without qualifying them with their class name (e.g. `import static java.lang.Math.PI;`)
- C) Importing classes at compile time instead of runtime
- D) Automatically declaring all variables static

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A feature allowing static members (methods and fields) to be used without qualifying them with their class name (e.g. `import static java.lang.Math.PI;`)**
**Explanation:** `static import` lets you write `sqrt(16)` instead of `Math.sqrt(16)`.
</details>

---

## Section 4: Encapsulation & Access Modifiers

### Q31. What is Encapsulation in Object-Oriented Programming?
- A) Inheriting features from a parent class
- B) Bundling data (fields) and methods that operate on that data into a single unit (class) while restricting direct access to internal state (Data Hiding)
- C) Defining multiple methods with the same name
- D) Converting objects into JSON strings

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Bundling data (fields) and methods that operate on that data into a single unit (class) while restricting direct access to internal state (Data Hiding)**
**Explanation:** Encapsulation protects object integrity by preventing external code from placing fields into inconsistent or invalid states.
</details>

---

### Q32. How is Data Hiding achieved in Java?
- A) By making all fields `public`
- B) By declaring fields as `private` and exposing controlled access via `public` getter and setter methods
- C) By encrypting source code files
- D) By making the class `abstract`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) By declaring fields as `private` and exposing controlled access via `public` getter and setter methods**
**Explanation:** `private` fields ensure that external classes cannot read or mutate fields directly without going through validation logic in getters/setters.
</details>

---

### Q33. Which Java access modifier provides the MOST restrictive visibility?
- A) `public`
- B) `protected`
- C) Default (Package-Private)
- D) `private`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **D) `private`**
**Explanation:** `private` members are visible ONLY within the declaring class itself.
</details>

---

### Q34. What is the visibility scope of `protected` members in Java?
- A) Visible only within the same class
- B) Visible within the same package AND by subclasses in different packages
- C) Visible everywhere in the entire application
- D) Visible only in sub-packages

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Visible within the same package AND by subclasses in different packages**
**Explanation:** `protected` allows access across the same package and to derived child classes through inheritance, even if those child classes reside in a different package.
</details>

---

### Q35. What is the visibility scope of Default (Package-Private) access (no modifier specified)?
- A) Accessible everywhere
- B) Accessible ONLY within classes in the same package
- C) Accessible only to subclasses
- D) Accessible only in the same class

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Accessible ONLY within classes in the same package**
**Explanation:** If no access modifier is declared, Java defaults to package-private access (accessible to all classes in that same package).
</details>

---

### Q36. Arrange Java access modifiers from MOST restrictive to LEAST restrictive:
- A) `private` -> `default` (package-private) -> `protected` -> `public`
- B) `public` -> `protected` -> `default` -> `private`
- C) `private` -> `protected` -> `default` -> `public`
- D) `default` -> `private` -> `protected` -> `public`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `private` -> `default` (package-private) -> `protected` -> `public`**
**Explanation:**
- `private`: Class only
- `default`: Package only
- `protected`: Package + Subclasses in other packages
- `public`: Anywhere
</details>

---

### Q37. What is the main benefit of validating values inside a Setter method?
- A) It speeds up JVM execution
- B) It enforces business invariants and prevents illegal or corrupted object state (e.g. rejecting negative salary or under-age registration)
- C) It eliminates the need for constructors
- D) It automatically saves data to a database

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) It enforces business invariants and prevents illegal or corrupted object state (e.g. rejecting negative salary or under-age registration)**
**Explanation:** Setters act as gatekeepers to ensure objects always remain in a valid, consistent state.
</details>

---

### Q38. How can you create a Read-Only property in an encapsulated class?
- A) Provide a public setter without a getter
- B) Provide a public getter but NO setter method
- C) Make all fields public
- D) Mark the class as volatile

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Provide a public getter but NO setter method**
**Explanation:** Omitting the setter prevents external code from mutating the property after object creation.
</details>

---

### Q39. What is Defensive Copying in Encapsulation?
- A) Backing up code to Git
- B) Returning a copy (or unmodifiable view) of a mutable object/collection from a getter so callers cannot mutate the internal state directly
- C) Copying classes at runtime
- D) Making fields public

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Returning a copy (or unmodifiable view) of a mutable object/collection from a getter so callers cannot mutate the internal state directly**
**Explanation:** e.g. Returning `Collections.unmodifiableList(items)` instead of the raw internal list prevents callers from clearing or modifying the list externally.
</details>

---

### Q40. Can a class declared with `public` modifier be saved in a file with a different name?
- A) Yes, file name does not matter
- B) No, a `public` top-level class MUST match the filename exactly (e.g. `public class Order` must be in `Order.java`)
- C) Only in Eclipse
- D) Only in Windows

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, a `public` top-level class MUST match the filename exactly (e.g. `public class Order` must be in `Order.java`)**
**Explanation:** The Java compiler enforces that a public class name must match its source filename.
</details>

---

## Section 5: Inheritance & Super Keyword

### Q41. What type of relationship does Inheritance represent in OOP?
- A) HAS-A relationship
- B) IS-A relationship
- C) USES-A relationship
- D) PART-OF relationship

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) IS-A relationship**
**Explanation:** Inheritance models specialization (e.g. `CustomerAccount IS-A BaseUserAccount`, `Manager IS-A Employee`).
</details>

---

### Q42. Which keyword is used by a class to inherit from another class in Java?
- A) `implements`
- B) `extends`
- C) `inherits`
- D) `using`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `extends`**
**Explanation:** A class uses `extends` to inherit fields and methods from a superclass (e.g. `class Child extends Parent`).
</details>

---

### Q43. Does Java support Multiple Inheritance of Classes (e.g. `class C extends A, B`)?
- A) Yes, always
- B) No, Java disallows multiple class inheritance to prevent ambiguity (Diamond Problem)
- C) Yes, if both parent classes are abstract
- D) Only in Java 21

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, Java disallows multiple class inheritance to prevent ambiguity (Diamond Problem)**
**Explanation:** Multiple inheritance of state/classes causes ambiguity if both parents define the same method/field. Java achieves multiple inheritance of *type* cleanly through **Interfaces**.
</details>

---

### Q44. What are the three primary forms of class inheritance supported in Java?
- A) Single, Multilevel, Hierarchical
- B) Multiple, Hybrid, Circular
- C) Dynamic, Static, Abstract
- D) Relational, Polymorphic, Binary

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Single, Multilevel, Hierarchical**
**Explanation:**
- **Single**: `B extends A`
- **Multilevel**: `C extends B extends A`
- **Hierarchical**: `B extends A` and `C extends A`
</details>

---

### Q45. What is the ultimate root superclass of every class in Java?
- A) `java.lang.Class`
- B) `java.lang.Object`
- C) `java.lang.System`
- D) `java.lang.Root`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `java.lang.Object`**
**Explanation:** Every class in Java directly or indirectly inherits from `java.lang.Object`, gaining standard methods like `toString()`, `equals()`, `hashCode()`, and `getClass()`.
</details>

---

### Q46. What does `super(...)` do inside a subclass constructor?
- A) Destroys the parent object
- B) Invokes the constructor of the immediate superclass (parent class)
- C) Calls a static method
- D) Creates an interface

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Invokes the constructor of the immediate superclass (parent class)**
**Explanation:** `super(...)` passes arguments up to initialize the inherited superclass fields before subclass initialization occurs.
</details>

---

### Q47. What happens if a subclass constructor does NOT explicitly call `super()` or `this()`?
- A) The code fails to compile
- B) The Java compiler automatically inserts a call to `super()` (the no-argument parent constructor) as the first statement
- C) The parent class is never initialized
- D) A runtime exception is thrown

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The Java compiler automatically inserts a call to `super()` (the no-argument parent constructor) as the first statement**
**Explanation:** If the parent class does not have a no-argument constructor and the subclass doesn't explicitly call `super(args)`, a compile-time error occurs.
</details>

---

### Q48. Can a subclass inherit `private` members of its superclass?
- A) Yes, all members are inherited unconditionally
- B) No, `private` members are not directly accessible in subclasses (though they can be accessed indirectly via inherited public/protected getters and setters)
- C) Only if they are static
- D) Only within the same package

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, `private` members are not directly accessible in subclasses (though they can be accessed indirectly via inherited public/protected getters and setters)**
**Explanation:** `private` access restricts visibility strictly to the declaring class.
</details>

---

### Q49. What does the `super.methodName()` syntax accomplish?
- A) Calls a static method on the interface
- B) Explicitly invokes the superclass's version of an overridden method from within the subclass
- C) Creates a new parent object
- D) Restarts the method

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Explicitly invokes the superclass's version of an overridden method from within the subclass**
**Explanation:** Used when a subclass overrides a method but still wants to reuse the parent's base logic before adding its own enhancements.
</details>

---

### Q50. What happens if a class is marked with the `final` keyword (e.g. `public final class String`)?
- A) It cannot have any constructors
- B) It CANNOT be extended/subclassed by any other class
- C) All its methods become private
- D) It cannot be instantiated

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) It CANNOT be extended/subclassed by any other class**
**Explanation:** `final` classes prevent inheritance (used for immutability and security, such as `java.lang.String` and `java.lang.Math`).
</details>

---

## Section 6: Polymorphism: Overloading & Overriding

### Q51. What does Polymorphism mean in Object-Oriented Programming?
- A) Many classes inside one file
- B) "Many Forms" — The ability of a single interface, reference, or method call to behave differently based on the underlying object
- C) Multiple variables having the same name
- D) Compiling code into bytecode

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) "Many Forms" — The ability of a single interface, reference, or method call to behave differently based on the underlying object**
**Explanation:** Polymorphism allows writing flexible code where a general reference (e.g. `PaymentGatewayProvider`) can execute specific behaviors (`Stripe`, `PayPal`, `Razorpay`) dynamically.
</details>

---

### Q52. What are the two types of Polymorphism in Java?
- A) Static (Compile-Time / Overloading) and Dynamic (Runtime / Overriding)
- B) Public and Private
- C) Abstract and Concrete
- D) Synchronous and Asynchronous

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Static (Compile-Time / Overloading) and Dynamic (Runtime / Overriding)**
**Explanation:**
- **Compile-Time**: Method Overloading (resolved at compile time by compiler).
- **Runtime**: Method Overriding (resolved at runtime via Dynamic Method Dispatch).
</details>

---

### Q53. What is Method Overloading (Compile-Time Polymorphism)?
- A) Overriding parent methods in child classes
- B) Defining multiple methods in the SAME class with the SAME name but DIFFERENT parameter lists (different count, data types, or sequence)
- C) Changing the return type only
- D) Calling methods in an infinite loop

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Defining multiple methods in the SAME class with the SAME name but DIFFERENT parameter lists (different count, data types, or sequence)**
**Explanation:** Method overloading allows a method like `initiatePayment()` to accept different inputs (Card vs ACH Wire vs UPI).
</details>

---

### Q54. Can two methods be overloaded by changing ONLY their return type?
```java
public int calculate(int a, int b) { return a + b; }
public double calculate(int a, int b) { return a + b; } // Is this valid overloading?
```
- A) Yes, return type alone distinguishes overloaded methods
- B) No, return type alone is NOT sufficient; the parameter list MUST differ
- C) Only in abstract classes
- D) Only if one is static

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, return type alone is NOT sufficient; the parameter list MUST differ**
**Explanation:** The compiler cannot determine which method to invoke if caller writes `calculate(5, 10)` without assigning the return value.
</details>

---

### Q55. What is Method Overriding (Runtime Polymorphism)?
- A) Calling a method multiple times
- B) When a subclass provides a specific implementation for a method that is already defined in its superclass (with identical name, parameters, and return type)
- C) Defining methods in an interface
- D) Renaming a parent method

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) When a subclass provides a specific implementation for a method that is already defined in its superclass (with identical name, parameters, and return type)**
**Explanation:** Overriding allows a subclass to tailor or replace inherited behavior.
</details>

---

### Q56. What is Dynamic Method Dispatch in Java?
- A) A mechanism where an overridden method call is resolved at RUNTIME based on the actual object on the Heap, rather than the reference type
- B) A compiler optimization for fast math
- C) A method dispatching threads
- D) Static binding of methods

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A mechanism where an overridden method call is resolved at RUNTIME based on the actual object on the Heap, rather than the reference type**
**Explanation:** If `PaymentGateway p = new StripeGateway(); p.process();` is called, Java checks the actual object (`StripeGateway`) at runtime and executes Stripe's overridden `process()` method.
</details>

---

### Q57. What is the purpose of the `@Override` annotation?
- A) It forces the method to run faster
- B) It informs the compiler that the method is intended to override a superclass method, generating a compile error if signatures don't match
- C) It makes the method public
- D) It prevents other classes from overriding the method

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) It informs the compiler that the method is intended to override a superclass method, generating a compile error if signatures don't match**
**Explanation:** `@Override` catches subtle typos (e.g. misspelling method names or mismatching parameter types) at compile time.
</details>

---

### Q58. Can you override a `final` method in a subclass?
- A) Yes, with @Override
- B) No, a method declared as `final` CANNOT be overridden by any subclass
- C) Only if the subclass is in the same package
- D) Only in Java 21

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, a method declared as `final` CANNOT be overridden by any subclass**
**Explanation:** `final` locks the method implementation so subclasses cannot alter its behavior (used for critical security algorithms).
</details>

---

### Q59. Can the access modifier of an overridden method in a subclass be MORE restrictive than the parent class?
- A) Yes, a public method can be made private in the subclass
- B) No, an overriding method cannot reduce the visibility of the inherited method (e.g. `protected` can become `public`, but `public` cannot become `protected` or `private`)
- C) Yes, any modifier is allowed
- D) Only in abstract classes

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, an overriding method cannot reduce the visibility of the inherited method (e.g. `protected` can become `public`, but `public` cannot become `protected` or `private`)**
**Explanation:** Reducing visibility violates the Liskov Substitution Principle (subclasses must fulfill all public contracts of their superclass).
</details>

---

### Q60. What is Upcasting in Java?
- A) Converting a subclass reference to a superclass reference type (e.g. `BaseUserAccount user = new CustomerAccount();`)
- B) Casting an int to a double
- C) Converting a superclass to a subclass
- D) Throwing an exception upwards

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Converting a subclass reference to a superclass reference type (e.g. `BaseUserAccount user = new CustomerAccount();`)**
**Explanation:** Upcasting is always safe and implicit in Java because a `CustomerAccount` IS-A `BaseUserAccount`.
</details>

---

### Q61. What is Downcasting in Java and what operator should be used before downcasting?
- A) Casting a superclass reference down to a subclass type, which should be guarded using the `instanceof` operator to prevent `ClassCastException`
- B) Casting a float to an int
- C) Deleting subclass fields
- D) Upgrading Java versions

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Casting a superclass reference down to a subclass type, which should be guarded using the `instanceof` operator to prevent `ClassCastException`**
**Explanation:** Downcasting (`StripeGateway s = (StripeGateway) gateway;`) allows accessing subclass-specific methods, but must be checked with `if (gateway instanceof StripeGateway)` first.
</details>

---

### Q62. What are Covariant Return Types in method overriding (Java 5+)?
- A) Overridden methods returning different primitive types
- B) An overriding method in a subclass can return a subtype of the return type declared in the superclass method
- C) Methods returning void
- D) Methods with generic wildcard returns

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) An overriding method in a subclass can return a subtype of the return type declared in the superclass method**
**Explanation:** If parent method returns `BaseUserAccount`, the overriding child method can return `CustomerAccount`.
</details>

---

## Section 7: Abstraction & Abstract Classes

### Q63. What is Abstraction in Object-Oriented Programming?
- A) Writing short code
- B) Hiding internal implementation complexity and exposing only the essential interface to the user
- C) Encrypting database passwords
- D) Storing classes in JAR files

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Hiding internal implementation complexity and exposing only the essential interface to the user**
**Explanation:** Abstraction lets you focus on *what* an object does rather than *how* it does it (e.g. pressing a button to send a notification without needing to know low-level network socket protocols).
</details>

---

### Q64. Can you instantiate an Abstract Class directly using the `new` keyword?
```java
abstract class NotificationDispatcher { ... }
NotificationDispatcher obj = new NotificationDispatcher(); // Is this valid?
```
- A) Yes, always valid
- B) No, abstract classes are incomplete and CANNOT be instantiated directly with `new`
- C) Only if it has no abstract methods
- D) Only in main method

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, abstract classes are incomplete and CANNOT be instantiated directly with `new`**
**Explanation:** An abstract class serves as a base class. You must create a concrete subclass that implements all abstract methods to instantiate an object.
</details>

---

### Q65. What is an Abstract Method?
- A) A method that runs in the background
- B) A method declared with the `abstract` keyword that has NO implementation (no method body `{ ... }`) and ends with a semicolon `;`
- C) A private method
- D) A method with a return type of void

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A method declared with the `abstract` keyword that has NO implementation (no method body `{ ... }`) and ends with a semicolon `;`**
**Explanation:** Abstract methods define a contract that all concrete subclasses must implement.
</details>

---

### Q66. Can an Abstract Class contain concrete (fully implemented) methods?
- A) No, all methods in an abstract class must be abstract
- B) Yes, abstract classes support Partial Abstraction (can contain both abstract methods and concrete methods with full implementations)
- C) Only if they are static
- D) Only in Java 8+

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, abstract classes support Partial Abstraction (can contain both abstract methods and concrete methods with full implementations)**
**Explanation:** Abstract classes allow sharing common base logic (e.g. `dispatchWithRetry()`) while forcing subclasses to implement specific variations (`deliverMessage()`).
</details>

---

### Q67. Can an Abstract Class have a Constructor?
- A) No, because abstract classes cannot be instantiated
- B) Yes, abstract classes CAN have constructors, which are invoked by subclass constructors via `super(...)`
- C) Only if the constructor is private
- D) Only in interfaces

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, abstract classes CAN have constructors, which are invoked by subclass constructors via `super(...)`**
**Explanation:** Abstract class constructors initialize common fields inherited by all concrete subclasses.
</details>

---

### Q68. If a class contains at least ONE abstract method, must the class itself be declared `abstract`?
- A) No, normal classes can have abstract methods
- B) Yes, any class containing one or more abstract methods MUST be declared with the `abstract` keyword
- C) Only if the method is public
- D) Only in packages

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, any class containing one or more abstract methods MUST be declared with the `abstract` keyword**
**Explanation:** A non-abstract class cannot have unimplemented abstract methods.
</details>

---

### Q69. Can an abstract class have `0` abstract methods (all concrete methods)?
- A) No, it must have at least one abstract method
- B) Yes, a class with zero abstract methods can still be declared `abstract` to prevent direct instantiation
- C) Only if it implements an interface
- D) Compilation error

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, a class with zero abstract methods can still be declared `abstract` to prevent direct instantiation**
**Explanation:** Making a fully concrete class `abstract` is a design technique to force developers to subclass it.
</details>

---

### Q70. Can an abstract method be declared as `private` or `final`?
- A) Yes, any modifier is valid
- B) No, because abstract methods MUST be overridden by subclasses, whereas `private` and `final` prevent method overriding (causing a compile error)
- C) Only `final` is allowed
- D) Only `private` is allowed

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, because abstract methods MUST be overridden by subclasses, whereas `private` and `final` prevent method overriding (causing a compile error)**
**Explanation:** `abstract` requires overriding; `private`/`final` forbids overriding. They are fundamentally contradictory.
</details>

---

### Q71. Can an abstract class have `static` methods?
- A) No, abstract classes cannot have static members
- B) Yes, abstract classes can have static methods that are called directly on the abstract class name
- C) Only if the methods are abstract
- D) Only in Java 21

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, abstract classes can have static methods that are called directly on the abstract class name**
**Explanation:** e.g. `NotificationDispatcher.getDefaultTimeout()` is fully valid.
</details>

---

### Q72. What happens if a subclass does NOT implement all inherited abstract methods?
- A) The unimplemented methods are ignored
- B) The subclass MUST also be declared as `abstract`, otherwise a compile-time error occurs
- C) The code crashes at runtime
- D) The JVM creates dummy methods

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The subclass MUST also be declared as `abstract`, otherwise a compile-time error occurs**
**Explanation:** A class can only be concrete if every inherited abstract method has a concrete implementation.
</details>

---

### Q73. What Design Pattern is commonly built using an Abstract Class with a concrete workflow method?
- A) Singleton Pattern
- B) Template Method Pattern
- C) Observer Pattern
- D) Decorator Pattern

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Template Method Pattern**
**Explanation:** The Template Method pattern defines the skeleton of an algorithm in an abstract class method (e.g. `dispatchWithRetry`), deferring specific steps to subclasses.
</details>

---

### Q74. Can an abstract class have instance variables (fields)?
- A) No, only interfaces can have fields
- B) Yes, abstract classes can declare instance variables, constants, and protected state shared by subclasses
- C) Only static variables are allowed
- D) Only primitive variables

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, abstract classes can declare instance variables, constants, and protected state shared by subclasses**
**Explanation:** Unlike interfaces (which only allow `public static final` constants), abstract classes hold full instance state.
</details>

---

## Section 8: Interfaces & Multiple Inheritance

### Q75. What is an Interface in Java?
- A) A graphical user interface window
- B) A pure contract or blueprint of a class specifying WHAT methods must be implemented without holding instance state
- C) A type of array
- D) A database table

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A pure contract or blueprint of a class specifying WHAT methods must be implemented without holding instance state**
**Explanation:** An interface defines a set of method signatures that implementing classes must fulfill.
</details>

---

### Q76. Which keyword is used by a class to implement an interface?
- A) `extends`
- B) `implements`
- C) `inherits`
- D) `using`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `implements`**
**Explanation:** A class uses `implements` (e.g. `class AmazonS3StorageService implements CloudBlobStorage`).
</details>

---

### Q77. Can a single Java class implement MULTIPLE interfaces?
- A) No, Java only allows implementing 1 interface
- B) Yes, a class can implement multiple interfaces separated by commas (Multiple Inheritance of Type)
- C) Only if the class is abstract
- D) Only up to 3 interfaces

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, a class can implement multiple interfaces separated by commas (Multiple Inheritance of Type)**
**Explanation:** e.g. `class Service implements CloudBlobStorage, AuditableResource, EncryptableResource`.
</details>

---

### Q78. What are the default modifiers for fields declared in an Interface?
- A) `private int x;`
- B) `public static final` (Constants)
- C) `protected volatile`
- D) Package-private

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `public static final` (Constants)**
**Explanation:** All variables in an interface are implicitly `public`, `static`, and `final`. You cannot declare instance variables in an interface.
</details>

---

### Q79. What are the default modifiers for standard methods declared in an Interface?
- A) `public abstract`
- B) `private static`
- C) `protected abstract`
- D) Package-private

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) `public abstract`**
**Explanation:** Every method in an interface (unless declared `default`, `static`, or `private`) is implicitly `public` and `abstract`.
</details>

---

### Q80. What are `default` methods in Java Interfaces (introduced in Java 8)?
- A) Methods with default package visibility
- B) Methods declared with the `default` keyword that provide a concrete implementation directly inside the interface for backward compatibility
- C) Methods that return null
- D) Private methods only

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Methods declared with the `default` keyword that provide a concrete implementation directly inside the interface for backward compatibility**
**Explanation:** `default` methods allow adding new methods to existing interfaces without breaking all previously written implementing classes.
</details>

---

### Q81. Can an Interface have `static` methods in Java (Java 8+)?
- A) No, interfaces cannot have static methods
- B) Yes, interfaces can define static utility methods that are called directly on the interface name (e.g. `CloudBlobStorage.isValidBlobKey(key)`)
- C) Only if they are private
- D) Only in Java 21

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, interfaces can define static utility methods that are called directly on the interface name (e.g. `CloudBlobStorage.isValidBlobKey(key)`)**
**Explanation:** Static interface methods provide cohesive helper functions related to the interface contract.
</details>

---

### Q82. Can an Interface have `private` methods in Java (Java 9+)?
- A) No, private methods are forbidden in interfaces
- B) Yes, private methods allow sharing common helper logic between multiple `default` methods inside the interface without exposing them publicly
- C) Only if the interface is abstract
- D) Only static private methods

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, private methods allow sharing common helper logic between multiple `default` methods inside the interface without exposing them publicly**
**Explanation:** Introduced in Java 9 to prevent code duplication across default methods within the same interface.
</details>

---

### Q83. What is a Functional Interface (`@FunctionalInterface`) in Java?
- A) An interface with only default methods
- B) An interface that contains EXACTLY ONE Single Abstract Method (SAM), making it eligible for Lambda expressions
- C) An interface that cannot be implemented
- D) An interface with 10 methods

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) An interface that contains EXACTLY ONE Single Abstract Method (SAM), making it eligible for Lambda expressions**
**Explanation:** Examples: `Runnable`, `Callable`, `Comparator`, `PayloadCompressionEngine`. They can be implemented concisely using Lambdas (`data -> compress(data)`).
</details>

---

### Q84. Can an interface `extend` another interface in Java?
- A) No, interfaces use `implements`
- B) Yes, an interface uses `extends` to inherit from one or more other interfaces
- C) Only if both are functional interfaces
- D) Only in the same file

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, an interface uses `extends` to inherit from one or more other interfaces**
**Explanation:** An interface can extend multiple parent interfaces (e.g. `interface AdvancedStorage extends CloudBlobStorage, AuditableResource`).
</details>

---

### Q85. What is a Marker Interface (Tagging Interface) in Java?
- A) An interface with only static methods
- B) An empty interface with NO fields and NO methods used to tag/mark a class for special JVM or framework handling (e.g. `Serializable`, `Cloneable`, `Remote`)
- C) An interface that draws UI marks
- D) A deprecated interface

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) An empty interface with NO fields and NO methods used to tag/mark a class for special JVM or framework handling (e.g. `Serializable`, `Cloneable`, `Remote`)**
**Explanation:** Marker interfaces provide type metadata so runtime checks (`if (obj instanceof Serializable)`) can authorize specific operations.
</details>

---

### Q86. What is the primary architectural difference between an Abstract Class and an Interface?
- A) Abstract classes can maintain instance state and constructors; Interfaces represent pure capability contracts and support multiple inheritance
- B) Interfaces are faster
- C) Abstract classes cannot have concrete methods
- D) Interfaces can have private constructors

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) Abstract classes can maintain instance state and constructors; Interfaces represent pure capability contracts and support multiple inheritance**
**Explanation:** Use an Abstract Class when building a hierarchy with shared code/state; use an Interface to define capabilities across unrelated classes.
</details>

---

## Section 9: Association, Composition & Aggregation

### Q87. What type of relationship is modeled by Association in OOP?
- A) IS-A relationship
- B) HAS-A relationship
- C) EXTENDS relationship
- D) IMPLEMENTS relationship

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) HAS-A relationship**
**Explanation:** Association defines how objects are connected and communicate (e.g. `CustomerOrder HAS-A ShippingAddress`, `Car HAS-A Engine`).
</details>

---

### Q88. What is Composition in Java OOP?
- A) An IS-A relationship using extends
- B) A Strong "HAS-A" (Part-Of) relationship where the child component's lifecycle is completely owned and managed by the parent object
- C) An interface extending another interface
- D) Multiple classes in one package

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A Strong "HAS-A" (Part-Of) relationship where the child component's lifecycle is completely owned and managed by the parent object**
**Explanation:** In Composition, if the parent is destroyed, all its internal composed components are destroyed with it (e.g. `CustomerOrder` owning `OrderItem`s and `ShippingAddress`).
</details>

---

### Q89. What is Aggregation in Java OOP?
- A) A Weak "HAS-A" relationship where the associated objects have independent lifecycles outside the container object
- B) Inheritance of abstract classes
- C) Compiling code into JARs
- D) A strong part-of relationship

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) A Weak "HAS-A" relationship where the associated objects have independent lifecycles outside the container object**
**Explanation:** In Aggregation, child objects exist independently (e.g. `ApiGatewayCluster` references independent `MicroserviceEndpoint`s; deleting the gateway does not delete the microservices).
</details>

---

### Q90. What does the industry design principle "Favor Composition over Inheritance" mean?
- A) Never use classes
- B) Build flexible, decoupled systems by assembling components via HAS-A relationships rather than creating deep, fragile IS-A inheritance hierarchies
- C) Only use interfaces
- D) Inheritance is deprecated in Java

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Build flexible, decoupled systems by assembling components via HAS-A relationships rather than creating deep, fragile IS-A inheritance hierarchies**
**Explanation:** Inheritance tightly couples subclasses to their parents (fragile base class problem), whereas Composition allows swapping components at runtime with zero ripple effects.
</details>

---

### Q91. In Composition, how is the child object typically created?
- A) Injected from a global static variable
- B) Instantiated directly inside the constructor or field declaration of the parent class (e.g. `this.address = new ShippingAddress(...)`)
- C) Passed as a command line argument
- D) Created by the Garbage Collector

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Instantiated directly inside the constructor or field declaration of the parent class (e.g. `this.address = new ShippingAddress(...)`)**
**Explanation:** Instantiating the child inside the parent ensures the parent controls the child's exact lifecycle.
</details>

---

### Q92. In Aggregation, how is the associated object typically passed into the container class?
- A) Instantiated with private constructors
- B) Passed in from the outside via constructor parameters or setter methods (Dependency Injection)
- C) Hardcoded in the Metaspace
- D) Created by the JVM

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Passed in from the outside via constructor parameters or setter methods (Dependency Injection)**
**Explanation:** Because aggregated objects exist independently, they are passed in from outside callers.
</details>

---

### Q93. Which real-world example best represents Composition?
- A) `Department` and `Professor` (Professors exist even if department closes)
- B) `CustomerOrder` and `OrderItem` (Order items cannot exist without an order)
- C) `Driver` and `Car` (Driver exists independently of car)
- D) `Student` and `Course`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `CustomerOrder` and `OrderItem` (Order items cannot exist without an order)**
**Explanation:** Order items have no meaning and cannot exist without their parent order.
</details>

---

### Q94. Which real-world example best represents Aggregation?
- A) `CustomerOrder` and `OrderItem`
- B) `ApiGatewayCluster` and `MicroserviceEndpoint` (Microservices run independently across Kubernetes nodes)
- C) `HumanBody` and `Heart`
- D) `House` and `Room`

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) `ApiGatewayCluster` and `MicroserviceEndpoint` (Microservices run independently across Kubernetes nodes)**
**Explanation:** The microservice services exist on their own pods; the gateway merely aggregates routing to them.
</details>

---

## Section 10: Enums & Design Patterns in OOP

### Q95. What is an `enum` in Java?
- A) A primitive number type
- B) A special class type in Java representing a fixed set of type-safe constants extending `java.lang.Enum`
- C) An interface with strings
- D) A thread pool

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) A special class type in Java representing a fixed set of type-safe constants extending `java.lang.Enum`**
**Explanation:** Java Enums provide full compile-time type safety over traditional `int` or `String` constants.
</details>

---

### Q96. Can a Java Enum have fields, custom constructors, and methods?
- A) No, enums can only contain plain names
- B) Yes, Java Enums are full classes and can have custom fields, constructors (implicitly private), getters, and business methods
- C) Only static methods
- D) Only in Java 17+

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Yes, Java Enums are full classes and can have custom fields, constructors (implicitly private), getters, and business methods**
**Explanation:** e.g. `HttpStatus(200, "OK")` with `getCode()` and `isSuccess()`.
</details>

---

### Q97. Can an Enum extend another class using `extends` in Java?
- A) Yes, enums can extend any class
- B) No, because all Java Enums already implicitly extend `java.lang.Enum`, and Java does not support multiple class inheritance
- C) Only if the parent class is abstract
- D) Only in packages

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) No, because all Java Enums already implicitly extend `java.lang.Enum`, and Java does not support multiple class inheritance**
**Explanation:** However, enums CAN implement one or more interfaces!
</details>

---

### Q98. How do Java Enums implement the Strategy Pattern (Constant-Specific Method Implementation)?
- A) By declaring an abstract method in the enum body and having each enum constant override that abstract method uniquely
- B) Using reflection
- C) By using public constructors
- D) Through subclassing

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **A) By declaring an abstract method in the enum body and having each enum constant override that abstract method uniquely**
**Explanation:** e.g. `PaymentProcessingTier` where `STANDARD`, `ENTERPRISE`, and `MICRO_TRANSACTION` each implement `calculateProcessingFee(amount)` uniquely without `if/else` ladders.
</details>

---

### Q99. What are `EnumSet` and `EnumMap` in Java?
- A) Deprecated legacy collections
- B) Highly optimized, specialized collection implementations backed by bitmasks (`EnumSet`) and compact arrays (`EnumMap`) for enum keys
- C) Synchronized thread maps
- D) Database query drivers

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) Highly optimized, specialized collection implementations backed by bitmasks (`EnumSet`) and compact arrays (`EnumMap`) for enum keys**
**Explanation:** `EnumSet` performs bitwise operations in $O(1)$ time; `EnumMap` provides array-index lookup speed with zero hash collisions.
</details>

---

### Q100. Why is an Enum considered the cleanest and safest way to implement the Singleton Design Pattern in Java (Joshua Bloch - Effective Java)?
- A) It runs in Metaspace only
- B) The JVM guarantees that enum constants are instantiated exactly once, thread-safely, and are inherently protected against serialization and reflection attacks
- C) Enums consume zero bytes of memory
- D) Enums don't require compilation

<details>
<summary><b>View Answer & Explanation</b></summary>

**Correct Answer:** **B) The JVM guarantees that enum constants are instantiated exactly once, thread-safely, and are inherently protected against serialization and reflection attacks**
**Explanation:** Java handles enum instantiation internally, preventing multiple instances even when deserializing or attempting reflection constructor hacks.
</details>

---

## 🏆 Scoring & Readiness Benchmark

| Score Range | Proficiency Level | Evaluation |
| :--- | :--- | :--- |
| **90 – 100** | 🌟 **Master Level** | Complete mastery of Object-Oriented Programming, ready to teach and ace senior developer interviews! |
| **75 – 89** | 🚀 **Strong Practitioner** | Solid grasp of OOP; review nuanced differences in Abstraction vs Interfaces and Composition lifecycle. |
| **60 – 74** | 📈 **Intermediate** | Good foundation; review access modifiers, constructor chaining, and Dynamic Method Dispatch. |
| **Below 60** | 💡 **Learner** | Revisit the 9 module demos in `org.example.OOP` and run the video demonstration scripts! |
