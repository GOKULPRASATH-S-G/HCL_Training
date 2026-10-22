
# Day 13 - Functional Programming

## Concepts Covered
- Lambda expressions
- Functional interfaces
- Predicate, Function, Consumer and Supplier
- Predicate composition: and(), or(), negate()
- Function composition: andThen(), compose()
- Method references
- Custom @FunctionalInterface

## Hands-on Task
Product Filter Engine:
- Filter by price and stock availability
- Filter products by category
- Transform product names
- Print products using Consumer
- Generate a default product using Supplier

## Run
mvn clean compile
java -cp target/classes FunctionalInterfaceDemo
java -cp target/classes FilterEngine

## Deliverable
FilterEngine.java
