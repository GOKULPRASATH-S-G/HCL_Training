import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int CORRECT_PIN = 1111;
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean authenticated = false;

        System.out.println("===== Welcome to HCL ATM =====");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your PIN: ");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                attempts++;
                System.out.println("Invalid PIN format.");
                continue;
            }

            int enteredPin = scanner.nextInt();

            if (enteredPin == CORRECT_PIN) {
                authenticated = true;
                System.out.println("Login Successful!");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN!");

                System.out.println(
                        "Attempts remaining: " + (MAX_ATTEMPTS - attempts));
            }
        }

        if (!authenticated) {
            System.out.println(
                    "Account locked! Too many incorrect attempts.");
            return;
        }

        System.out.println("Welcome to ATM Services!");
    }
}