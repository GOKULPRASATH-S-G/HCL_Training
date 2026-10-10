package order;

import order.exception.InvalidOrderException;
import order.exception.OrderProcessingException;

public class Main {

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();

        System.out.println("=== Test Case 1: Valid Order ===");
        handleOrder(processor, "ORD-101", 5, 49.99);

        System.out.println("\n=== Test Case 2: Invalid Order (Invalid Quantity) ===");
        handleOrder(processor, "ORD-102", -2, 25.00);

        System.out.println("\n=== Test Case 3: Invalid Order (Invalid Price) ===");
        handleOrder(processor, "ORD-103", 10, -5.00);

        System.out.println("\n=== Test Case 4: Invalid Order (Empty Order ID) ===");
        handleOrder(processor, "   ", 3, 15.00);

        System.out.println("\n=== Test Case 5: Order Processing Failure (Exceeds Inventory) ===");
        handleOrder(processor, "ORD-104", 150, 20.00);
    }

    private static void handleOrder(OrderProcessor processor, String orderId, int quantity, double price) {
        try {
            double total = processor.processOrder(orderId, quantity, price);
            System.out.printf("Success: Order total is $%.2f%n", total);
        } catch (InvalidOrderException e) {
            System.err.println("Caught InvalidOrderException: " + e.getMessage());
        } catch (OrderProcessingException e) {
            System.err.println("Caught OrderProcessingException: " + e.getMessage());
        } finally {
            System.out.println("Finished order transaction cleanup for: " + (orderId == null || orderId.isBlank() ? "<EMPTY_ID>" : orderId.trim()));
        }
    }
}
