
package payment;

public class Card extends Payment implements Refundable {

    public Card(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println(
                "Processing card payment of Rs. " + getAmount());
    }

    @Override
    public void refund(double amount) {
        if (amount <= 0 || amount > getAmount()) {
            System.out.println("Invalid refund amount.");
            return;
        }

        System.out.println(
                "Card refund processed: Rs. " + amount);
    }
}
