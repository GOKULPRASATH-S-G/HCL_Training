# HCL Training – Day 5

## Module
Inheritance, Polymorphism & Interfaces

## Java Task
### Payment Processing Hierarchy

The Payment Processing Hierarchy demonstrates how Java inheritance, abstract classes, interfaces, and polymorphism enable flexible and extensible software designs.

### Concepts Demonstrated
- Inheritance hierarchy using `extends` to share common state and behavior
- Abstract classes (`abstract class`) defining foundational domain models
- Abstract methods enforcing required implementations across concrete subclasses
- Invoking superclass constructors using `super(...)`
- Dynamic polymorphism (method overriding with `@Override`) for distinct payment behaviors
- Static polymorphism (method overloading) to support optional transaction references
- Interface contracts (`interface`) to define pluggable capabilities
- Implementing interfaces using `implements` for refundable payment channels
- Storing diverse subclass instances in a single polymorphic array
- Dynamic method dispatch where method execution is resolved at runtime
- Type checking using `instanceof` to identify supported capabilities
- Safe object downcasting to invoke interface-specific operations

## Project Task
### Pet Adoption & Veterinary Clinic Portal

The project task applies inheritance hierarchies and polymorphism to model application users, featuring an abstract `User` base class specialized by `Adopter`, `ShelterStaff`, and `Veterinarian` roles with polymorphic behaviors.

## Status

Day 5 inheritance hierarchy implementation completed.
Abstract classes, method overriding, and interface contracts verified.
Dynamic method dispatch and runtime type checking validated.
