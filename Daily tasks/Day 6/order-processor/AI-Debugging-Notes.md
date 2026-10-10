# Day 6 — AI-Assisted Debugging Notes

## 1. Stack trace: NumberFormatException

**Example error:**
```text
java.lang.NumberFormatException: For input string: "abc"
    at java.lang.Integer.parseInt(...)
    at order.OrderProcessor.processOrder(...)
    at order.Main.processAndDisplay(...)
```

**Root cause:** The program attempted to convert `"abc"` into an integer.

**Fix:** Validate the input or catch `NumberFormatException`. In the Order Processor, the exception is wrapped in `OrderProcessingException`, preserving the original cause.

**Verification:** Run the application with quantity `"abc"` and confirm that it displays a readable error instead of terminating unexpectedly.

## 2. Stack trace: IllegalArgumentException

**Example error:**
```text
java.lang.IllegalArgumentException: ID must be greater than zero.
    at model.BaseEntity.setId(...)
```

**Root cause:** An invalid ID was supplied to the setter.

**Fix:** Supply a positive ID and retain validation in the setter.

**Verification:** Test both a positive ID and an invalid ID. Confirm that the valid value is accepted and the invalid value is rejected.

## How I used AI for debugging

1. Read the exception type and error message.
2. Identified the first application-code line in the stack trace.
3. Asked AI to explain possible causes and suggest a fix.
4. Checked the suggested fix against the source code.
5. Recompiled and reran the test to verify the result.

## Important lesson

AI suggestions are hypotheses, not proof. Always verify the root cause, inspect the affected code, and run a test after making a change.