
package payment;

public class Cash extends Payment {

    public Cash(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println(
                "Processing cash payment of Rs. " + getAmount());
    }
}
