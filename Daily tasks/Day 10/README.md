# HCL Training – Day 10

## Module
JVM Memory Management, Heap/Stack & Garbage Collection

## Java Task
### Memory Lab (`MemoryLab.java`)

Demonstrations exploring Java memory internals, object lifecycles, and optimization mechanisms.

### Concepts Demonstrated
- **Integer Cache**: Demonstrating JVM Integer pooling behavior for values between `-128` and `127` (`==` vs `.equals()`).
- **String Immutability & StringBuilder Performance**: Benchmarking repeated `+` string concatenation against `StringBuilder.append()` in terms of latency and memory efficiency.
- **StackOverflowError**: Infinite recursion exhausting thread call-stack frames.
- **OutOfMemoryError**: Repeated large heap allocations exceeding maximum heap space limits (`-Xmx`).

### How to Run

Navigate to Day 10 folder:
```powershell
cd "Daily tasks\Day 10"
```

#### 1. Default Run (Integer Cache & String Concatenation)
```powershell
mvn compile exec:java
```
Or directly with Java:
```powershell
java -cp target/classes MemoryLab
```

#### 2. Run Specific Modes
- **Integer Cache**:
  ```powershell
  mvn exec:java "-Dexec.args=integer"
  # or
  java -cp target/classes MemoryLab integer
  ```

- **String Comparison**:
  ```powershell
  mvn exec:java "-Dexec.args=strings"
  # or
  java -cp target/classes MemoryLab strings
  ```

- **StackOverflowError Demo**:
  ```powershell
  mvn exec:java "-Dexec.args=stack"
  # or
  java -cp target/classes MemoryLab stack
  ```

- **OutOfMemoryError Demo (with limited heap)**:
  ```powershell
  java -Xmx64m -cp target/classes MemoryLab heap
  ```
