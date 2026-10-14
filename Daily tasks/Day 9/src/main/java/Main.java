
public class Main {
    public static void main(String[] args) {

        System.out.println("=== Pair Example ===");
        Pair<Integer, String> pet = new Pair<>(101, "Bruno");
        pet.display();

        System.out.println("\n=== Box Example ===");
        Box<Integer> ageBox = new Box<>(3);
        ageBox.display();

        Box<Double> priceBox = new Box<>(249.99);
        priceBox.display();

        System.out.println("\n=== Generic Max Example ===");
        System.out.println("Largest integer: "
                + GenericToolkit.max(10, 25, 15));

        System.out.println("Largest double: "
                + GenericToolkit.max(10.5, 25.7, 15.2));

        System.out.println("Largest string: "
                + GenericToolkit.max("Apple", "Mango", "Banana"));
    }
}
