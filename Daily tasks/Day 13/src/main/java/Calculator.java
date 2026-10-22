/**
 * A custom functional interface representing a mathematical operation
 * taking two double arguments and producing a double result.
 */
@FunctionalInterface
public interface Calculator {

    /**
     * Performs a mathematical operation on two double operands.
     *
     * @param a first operand
     * @param b second operand
     * @return result of the operation
     */
    double calculate(double a, double b);

    /**
     * Static helper returning an addition calculator.
     */
    static Calculator add() {
        return (a, b) -> a + b;
    }

    /**
     * Static helper returning a subtraction calculator.
     */
    static Calculator subtract() {
        return (a, b) -> a - b;
    }

    /**
     * Static helper returning a multiplication calculator.
     */
    static Calculator multiply() {
        return (a, b) -> a * b;
    }

    /**
     * Static helper returning a division calculator with division by zero
     * validation.
     */
    static Calculator divide() {
        return (a, b) -> {
            if (b == 0.0) {
                throw new ArithmeticException("Division by zero is not permitted.");
            }
            return a / b;
        };
    }

    /**
     * Static helper returning a power calculator using Math.pow method reference.
     */
    static Calculator power() {
        return Math::pow;
    }
}
