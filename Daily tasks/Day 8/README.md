# HCL Training – Day 8

## Module
Collections Framework — Maps, Sorting & the equals/hashCode Contract

## Java Task
### Employee Directory

The Employee Directory demonstrates key aspects of the Java Collections Framework, including key-value mapping with `HashMap` and `TreeMap`, frequency counting with modern Map APIs, natural and custom object ordering using `Comparable` and `Comparator`, and practical demonstrations of the `equals()` and `hashCode()` contract.

### Concepts Demonstrated
- Direct O(1) key-based lookups using `HashMap` indexed by employee ID
- Frequency counting using `Map.merge()` with `Integer::sum`
- Sorted key storage and department grouping using `TreeMap` with `computeIfAbsent()`
- Natural ordering implementation with `Comparable<Employee>` based on employee ID
- Multi-criteria custom sorting using chained `Comparator` operations (salary descending, name ascending, ID ascending)
- Stream sorting and limiting to extract top records
- Practical violation demonstration of the `equals()` and `hashCode()` contract using `HashSet`
- Understanding how missing `hashCode()` breaks hash-based collection uniqueness

## Project Task
### Pet Adoption & Veterinary Clinic Portal

The project task applies `Map` lookups for fast entity resolution, `TreeMap` for sorted reporting, and `Comparable` / `Comparator` sorting for ranking pets by name, age, and vaccination schedules.

## Status

Day 8 Collections Framework implementation completed.
HashMap, TreeMap, Comparable, and Comparator sorting verified.
Equals and hashCode contract violation demonstration validated.
