
package payment;

public class UPI extends Payment implements Refundable {

    private String upiId;

    public UPI(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void pay() {
        System.out.println(
                "Processing UPI payment of Rs. " + getAmount());
        System.out.println("UPI ID: " + upiId);
    }

    @Override
    public void refund(double amount) {
        if (amount <= 0 || amount > getAmount()) {
            System.out.println("Invalid refund amount.");
            return;
        }

        System.out.println(
                "UPI refund processed: Rs. " + amount);
    }
}
