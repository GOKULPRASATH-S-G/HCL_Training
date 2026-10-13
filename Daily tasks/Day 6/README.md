# HCL Training – Day 6

## Module
Exception Handling & AI-Assisted Debugging

## Java Task
### Order Processor

The Order Processor demonstrates robust error handling and fault-tolerant programming in Java by creating custom checked exceptions, validating input parameters, enforcing inventory constraints, and managing execution lifecycles with structured exception handling.

### Concepts Demonstrated
- Understanding the Java exception hierarchy (checked vs. unchecked exceptions)
- Creating domain-specific custom checked exceptions extending `Exception`
- Separating validation errors from business rule violations
- Declaring exceptions in method signatures using `throws`
- Explicitly raising exceptions when business rules are violated using `throw`
- Defensive parameter validation to guard against null, blank, or invalid numerical inputs
- Business invariant enforcement against operational limits (inventory thresholds)
- Structured error handling using `try-catch-finally` blocks
- Granular exception catching for specific, actionable error messages
- Deterministic transaction cleanup using `finally` blocks

### AI-Assisted Debugging Practices
- Reading and analyzing Java stack traces to locate points of failure
- Identifying root cause errors (`NumberFormatException`, `IllegalArgumentException`)
- Formulating debugging hypotheses using AI tools
- Verifying AI suggestions against source code requirements
- Validating bug fixes through targeted test scenarios

## Project Task
### Pet Adoption & Veterinary Clinic Portal

The project task applies custom checked exceptions (`AdoptionException`) and unchecked exceptions (`PetNotFoundException`, `BusinessRuleException`) to safeguard pet status transitions, prevent invalid adoptions, and manage clinical errors cleanly.

## Status

Day 6 custom exception hierarchy implementation completed.
Validation guards, inventory threshold checks, and `try-catch-finally` flow verified.
AI debugging workflows and stack trace analysis documented.
