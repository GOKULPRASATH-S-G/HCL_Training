
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface DiscountRule {
    double apply(double price);
}

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        // Custom functional interface
        DiscountRule discount = price -> price * 0.90;
        System.out.println("Price after 10% discount: "
                + discount.apply(1000));

        // Predicate: tests a condition
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println("Is 20 even? " + isEven.test(20));

        // Predicate composition
        Predicate<Integer> greaterThanTen = number -> number > 10;
        System.out.println("Even and greater than 10: "
                + isEven.and(greaterThanTen).test(20));

        // Function: transforms a value
        Function<String, String> trim = String::trim;
        Function<String, String> uppercase = String::toUpperCase;
        System.out.println("Transformed: "
                + trim.andThen(uppercase).apply("  java  "));

        // Consumer: performs an action
        Consumer<String> printer = System.out::println;
        printer.accept("Hello from Consumer");

        // Supplier: supplies a value
        Supplier<String> defaultName = () -> "Unknown Product";
        System.out.println("Default name: " + defaultName.get());
    }
}
