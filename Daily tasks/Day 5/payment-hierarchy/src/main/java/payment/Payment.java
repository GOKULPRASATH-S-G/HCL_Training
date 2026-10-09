package payment;

public abstract class Payment {

    private double amount;

    public Payment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Payment amount must be greater than zero."
            );
        }

        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract void pay();

    public void pay(String transactionReference) {
        System.out.println("Transaction Reference: "
                + transactionReference);
        pay();
    }
}
