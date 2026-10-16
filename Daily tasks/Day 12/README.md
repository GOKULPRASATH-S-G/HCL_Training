# HCL Training – Day 12

## Module
Core Java Checkpoint

## Objective
Consolidate core Java fundamentals through domain modeling, generic repository implementation, exception handling, collections, sorting with Comparable/Comparator, Stream API processing, and generic utility methods.

## Technologies
- Java 21
- Maven
- Java Collections Framework (`HashMap`, `ArrayList`)
- Java Stream API
- `Optional<T>`
- Java Generics

## Project Structure
```text
Day 12/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            ├── Student.java
            ├── StudentRepository.java
            └── Main.java
```

## Key Concepts Demonstrated

### 1. Domain Modeling & Encapsulation (`Student.java`)
- Immutable fields (`id`, `name`, `marks`).
- Input validation in constructor:
  - `id` must be positive (> 0).
  - `name` cannot be null or blank.
  - `marks` must be finite and within range `[0, 100]`.
- Implements `Comparable<Student>` with natural ordering based on student `id`.
- Proper overrides of `equals()`, `hashCode()`, and `toString()`.

### 2. Generic Repository Pattern (`StudentRepository.java`)
- Generic interface `CrudRepository<T, ID>` defining standard CRUD signatures:
  - `T save(T item)`
  - `Optional<T> findById(ID id)`
  - `List<T> findAll()`
  - `boolean deleteById(ID id)`
- `StudentRepository` implementation using an internal `HashMap<Integer, Student>`.
- Rejects duplicate student IDs on `save()`.
- Safe retrieval using `Optional<Student>`.

### 3. Sorting & Comparison (`Main.java`)
- **Comparable**: Natural ordering by ID via `students.sort(null)`.
- **Comparator**: Custom multi-key sorting (highest marks first, tie-breaking by name):
  ```java
  Comparator.comparingDouble(Student::getMarks)
          .reversed()
          .thenComparing(Student::getName)
  ```

### 4. Stream API & Functional Operations (`Main.java`)
- **Average Calculation**: Using `mapToDouble()` and `average()`.
- **Filtering & Counting**: Using `filter()` with lambda predicate to count students scoring $\ge 50$.

### 5. Generic Utility Methods (`Main.java`)
- Bounded generic method finding the maximum of three comparable elements:
  ```java
  public static <T extends Comparable<T>> T max(T first, T second, T third)
  ```

---

## How to Build and Run

### 1. Compile
From `Daily tasks/Day 12`:
```powershell
mvn clean compile
```

### 2. Run
```powershell
java -cp target/classes Main
```

---

## Expected Output
```text
=== Core Java Checkpoint ===
Validation: Name cannot be empty

Search ID 102:
Student{id=102, name='Priya', marks=92.0}

Sorted by ID:
Student{id=101, name='Arun', marks=85.5}
Student{id=102, name='Priya', marks=92.0}
Student{id=103, name='Kumar', marks=76.0}

Sorted by marks:
Student{id=102, name='Priya', marks=92.0}
Student{id=101, name='Arun', marks=85.5}
Student{id=103, name='Kumar', marks=76.0}

Average marks: 84.50
Students passed: 3
Highest marks: 92.0
Deleted ID 103: true
Final student count: 2
```
