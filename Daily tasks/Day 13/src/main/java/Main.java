/**
 * Main application for Day 13 demonstrating:
 * 1. Custom Functional Interface (Calculator) with lambda expressions and higher-order methods.
 * 2. Java Built-in Functional Interfaces via FunctionalInterfaceDemo.
 */
public class Main {

    /**
     * Higher-order function that takes a functional interface as an argument.
     *
     * @param a          first operand
     * @param b          second operand
     * @param calculator functional interface implementation
     * @return calculated result
     */
    public static double compute(double a, double b, Calculator calculator) {
        return calculator.calculate(a, b);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       HCL TRAINING - DAY 13: FUNCTIONAL JAVA     ");
        System.out.println("==================================================");

        double num1 = 20.0;
        double num2 = 4.0;

        System.out.printf("%nOperands: num1 = %.1f, num2 = %.1f%n%n", num1, num2);

        System.out.println("--- Part 1: Custom Functional Interface (Calculator) ---");

        // 1. Lambda Expressions with single-line body
        Calculator addition = (a, b) -> a + b;
        Calculator subtraction = (a, b) -> a - b;
        Calculator multiplication = (a, b) -> a * b;

        // 2. Lambda Expression with block body and validation
        Calculator division = (a, b) -> {
            if (b == 0.0) {
                throw new ArithmeticException("Cannot divide by zero!");
            }
            return a / b;
        };

        // 3. Method Reference implementation
        Calculator power = Math::pow;

        // Passing lambdas to higher-order method
        System.out.printf("Addition (num1 + num2):        %.2f%n", compute(num1, num2, addition));
        System.out.printf("Subtraction (num1 - num2):     %.2f%n", compute(num1, num2, subtraction));
        System.out.printf("Multiplication (num1 * num2):  %.2f%n", compute(num1, num2, multiplication));
        System.out.printf("Division (num1 / num2):        %.2f%n", compute(num1, num2, division));
        System.out.printf("Power (num1 ^ num2):           %.2f%n", compute(num1, num2, power));

        // 4. Using static factory methods declared on the interface
        System.out.println("\nUsing Calculator static factory methods:");
        System.out.printf("Calculator.add():       %.2f%n", Calculator.add().calculate(num1, num2));
        System.out.printf("Calculator.subtract():  %.2f%n", Calculator.subtract().calculate(num1, num2));
        System.out.printf("Calculator.multiply():  %.2f%n", Calculator.multiply().calculate(num1, num2));
        System.out.printf("Calculator.divide():    %.2f%n", Calculator.divide().calculate(num1, num2));
        System.out.printf("Calculator.power():     %.2f%n", Calculator.power().calculate(num1, num2));

        // 5. Exception handling test for division by zero
        System.out.println("\nException Handling (Division by Zero):");
        try {
            Calculator.divide().calculate(num1, 0.0);
        } catch (ArithmeticException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        // --- Part 2: Java Built-in Functional Interfaces ---
        System.out.println();
        FunctionalInterfaceDemo.main(args);

        System.out.println("\n==================================================");
        System.out.println("            DAY 13 EXECUTION COMPLETED            ");
        System.out.println("==================================================");
    }
}
