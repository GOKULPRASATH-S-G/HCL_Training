
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FilterEngine {

    record Product(String name, String category, double price,
            boolean inStock) {
    }

    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 65000, true),
                new Product("Mouse", "Electronics", 800, true),
                new Product("Keyboard", "Electronics", 1500, false),
                new Product("Chair", "Furniture", 4500, true),
                new Product("Desk", "Furniture", 9000, false),
                new Product("Bottle", "Accessories", 500, true));

        // Predicates: conditions for filtering products
        Predicate<Product> affordable = product -> product.price() <= 5000;

        Predicate<Product> electronics = product -> product.category().equalsIgnoreCase("Electronics");

        Predicate<Product> available = Product::inStock;

        // Compose predicates using and()
        Predicate<Product> filter = affordable
                .and(available);

        System.out.println("=== Affordable Products In Stock ===");
        products.stream()
                .filter(filter)
                .forEach(System.out::println);

        System.out.println("\n=== In-stock Electronics ===");
        products.stream()
                .filter(electronics.and(available))
                .forEach(System.out::println);

        // Function chain: transform product name
        Function<Product, String> getName = Product::name;
        Function<String, String> uppercase = String::toUpperCase;

        Function<Product, String> productLabel = getName.andThen(uppercase);

        System.out.println("\n=== Product Labels ===");
        products.stream()
                .map(productLabel)
                .forEach(System.out::println);

        // Consumer: prints a product
        Consumer<Product> printer = product -> System.out.println(
                product.name() + " - Rs. " + product.price());

        System.out.println("\n=== All Products ===");
        products.forEach(printer);

        // Supplier: provides a default product
        Supplier<Product> defaultProduct = () -> new Product("Default Product", "General", 0, false);

        System.out.println("\n=== Default Product ===");
        System.out.println(defaultProduct.get());

        // Predicate negate()
        System.out.println("\n=== Out-of-stock Products ===");
        products.stream()
                .filter(available.negate())
                .forEach(System.out::println);

        // Function compose()
        Function<Integer, Integer> multiplyByTwo = number -> number * 2;
        Function<Integer, Integer> addThree = number -> number + 3;

        System.out.println("\nCompose result: "
                + multiplyByTwo.compose(addThree).apply(5));
    }
}
