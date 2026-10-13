# HCL Training – Day 7

## Module
Collections Framework — Queues & FIFO Data Structures

## Java Task
### Library Waitlist

The Library Waitlist demonstrates the Java Collections Framework by implementing a First-In, First-Out (FIFO) book reservation pipeline for high-demand titles using the `Queue` interface backed by `LinkedList`.

### Concepts Demonstrated
- Understanding the Java Collections Framework hierarchy
- Working with the `java.util.Queue` interface contract
- Utilizing `java.util.LinkedList` as a FIFO queue implementation
- Enqueuing elements to the tail of the line using `offer()`
- Dequeuing and serving elements from the head of the line using `poll()`
- Inspecting the next element in line without removing it using `peek()`
- Bounded capacity management and overflow protection
- Preventing duplicate entries in the waitlist
- Mid-queue element removal for cancellation handling
- Calculating 1-based queue position for patrons
- Creating defensive copies with `Collections.unmodifiableList` to prevent external collection mutation
- Graceful handling of edge conditions (empty queues, saturated capacity)

## Project Task
### Pet Adoption & Veterinary Clinic Portal

The project task applies FIFO queue structures to manage the fair, sequential review of pending adoption applications and daily veterinary clinic patient triage check-ins without starvation.

## Status

Day 7 Collections Framework implementation completed.
FIFO queue operations (`offer`, `poll`, `peek`) verified.
Capacity limits, duplicate rejection, and cancellation handling validated.
