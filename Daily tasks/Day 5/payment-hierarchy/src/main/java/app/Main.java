package app;

import payment.Card;
import payment.Cash;
import payment.Payment;
import payment.Refundable;
import payment.UPI;

public class Main {

    public static void main(String[] args) {

        Payment cardPayment = new Card(1500.0);
        Payment upiPayment = new UPI(800.0, "user@okaxis");
        Payment cashPayment = new Cash(500.0);

        Payment[] payments = { cardPayment, upiPayment, cashPayment };

        System.out.println("=== Processing Payments (Polymorphism) ===");
        for (Payment payment : payments) {
            payment.pay();
            System.out.println();
        }

        System.out.println("=== Overloaded Method (pay with Reference) ===");
        cardPayment.pay("TXN123456");
        System.out.println();

        System.out.println("=== Processing Refunds (Interface) ===");
        for (Payment payment : payments) {
            if (payment instanceof Refundable) {
                ((Refundable) payment).refund(200.0);
            } else {
                System.out.println("Cash payment cannot be refunded.");
            }
        }
    }
}
