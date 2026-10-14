# HCL Training – Day 9

## Module
Generics, Wildcards & Resource Management (Try-with-Resources)

## Java Task
### Generic Toolkit & Resource Management

The Day 9 tasks explore compile-time type safety, reusability, and deterministic resource lifecycle management in Java. The exercises cover creating parameterized generic classes and methods, applying upper and lower bounded wildcards, managing system resources with the `AutoCloseable` interface, and handling file I/O safely using modern `java.nio.file` APIs.

### Concepts Demonstrated
- **Generic Classes with Multiple Type Parameters**: Implementing `Pair<K, V>` to encapsulate key-value associations without runtime type casting or type-erasure issues.
- **Bounded Type Parameters**: Enforcing numeric constraints with `Box<T extends Number>` to safely call `Number` operations like `doubleValue()`.
- **Generic Static Methods with Comparable Bounds**: Writing `GenericToolkit.max()` constrained by `<T extends Comparable<T>>` to evaluate maximums across arbitrary comparable types (integers, doubles, strings).
- **Wildcards & PECS Principle (Producer Extends, Consumer Super)**:
  - Upper-bounded wildcards (`List<? extends Number>`) in `WildCardDemo.sum()` for flexible read-only producer collections.
  - Lower-bounded wildcards (`List<? super Integer>`) in `WildCardDemo.addNumbers()` for write-safe consumer collections.
- **Deterministic Resource Management (`AutoCloseable`)**:
  - Implementing custom resources using `AutoCloseable` in `ResourceDemo`.
  - Leveraging the `try-with-resources` construct to guarantee automatic closing in reverse order of initialization, preventing resource leaks without explicit `finally` blocks.
- **Modern File I/O**:
  - Reading structured data from `products.csv` using `java.nio.file.Path` and `Files.newBufferedReader()`.
  - Combining try-with-resources with buffered stream reading for safe, leak-free file processing.

## Project Task
### Pet Adoption & Veterinary Clinic Portal

The project task applies generics to create decoupled, type-safe data access abstractions (`Repository<T, ID>` and `InMemoryRepository<T, ID>`), employs wildcards for querying collections of medical and pet records, and leverages `try-with-resources` for loading product catalogs and seed data without leaving file handles open.

## Status

Day 9 Generics, Wildcards, and Resource Management implementation completed.
Maven project configuration (`pom.xml`) verified with Java 21.
Compile-time type safety (`Pair`, `Box`, `GenericToolkit`, `WildCardDemo`) validated.
Deterministic resource cleanup (`ResourceDemo`) and CSV file reading (`CsvReaderDemo`) verified.
