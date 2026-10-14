
import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {

    // Upper-bounded wildcard: reads numbers
    public static double sum(List<? extends Number> numbers) {
        double total = 0;

        for (Number number : numbers) {
            total += number.doubleValue();
        }

        return total;
    }

    // Lower-bounded wildcard: accepts integers or their supertypes
    public static void addNumbers(List<? super Integer> numbers) {
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
    }

    public static void main(String[] args) {

        List<Integer> integers = List.of(10, 20, 30);
        System.out.println("Sum: " + sum(integers));

        List<Number> values = new ArrayList<>();
        addNumbers(values);
        System.out.println("Added values: " + values);
    }
}
