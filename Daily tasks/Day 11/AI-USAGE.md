
# AI Usage - Day 11

## Objective
Use AI to assist with Java code generation and code review.

## Prompt Comparison
- Vague prompt: Create a Student class in Java.
- Improved prompt: Create a Java 21 Student POJO with private final fields for ID, name, age, and marks; a constructor; getters; and a readable toString(). Create a StudentService using Map<Integer, Student> with methods to add students, find by ID using Optional, list students, and calculate average marks. Validate null input, positive IDs, nonblank names, ages from 1–120, marks from 0–100, and duplicate IDs. Use no raw types or unchecked casts. Include a runnable Main class and test invalid inputs.

## Code Generated
- Student.java
- StudentService.java
- Main.java

## Review Performed
1. Checked null input.
2. Checked student ID validity.
3. Checked blank names.
4. Checked age and marks boundaries.
5. Checked duplicate IDs.
6. Verified lookup and average calculations.

## Developer Verification
Compiled using Maven and tested normal and invalid inputs.
AI-generated code was reviewed and tested before acceptance.

## Limitations
This is an in-memory demonstration. Student data is not persisted
after the program exits.
