package order;

import order.exception.InvalidOrderException;
import order.exception.OrderProcessingException;

public class OrderProcessor {

    private static final int MAX_INVENTORY_LIMIT = 100;

    public void validateOrder(String orderId, int quantity, double price) throws InvalidOrderException {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new InvalidOrderException("Invalid order: Order ID cannot be null or empty.");
        }
        if (quantity <= 0) {
            throw new InvalidOrderException("Invalid order: Quantity must be greater than zero. Provided: " + quantity);
        }
        if (price <= 0.0) {
            throw new InvalidOrderException("Invalid order: Price must be greater than zero. Provided: " + price);
        }
    }

    public double processOrder(String orderId, int quantity, double price) throws OrderProcessingException {
        System.out.println("Processing order [" + orderId + "]...");

        // Validate order inputs
        validateOrder(orderId, quantity, price);

        // Check stock/inventory limit
        if (quantity > MAX_INVENTORY_LIMIT) {
            throw new OrderProcessingException(
                "Processing failed for order [" + orderId + "]: Requested quantity (" + quantity
                + ") exceeds available inventory limit (" + MAX_INVENTORY_LIMIT + ")."
            );
        }

        double totalAmount = quantity * price;
        System.out.printf("Order [%s] processed successfully. Total: $%.2f%n", orderId, totalAmount);
        return totalAmount;
    }
}
