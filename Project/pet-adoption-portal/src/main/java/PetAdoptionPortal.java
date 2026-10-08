import java.util.Scanner;

public class PetAdoptionPortal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {

            System.out.println();
            System.out.println("===== Pet Adoption & Veterinary Clinic Portal =====");
            System.out.println("1. List Pets");
            System.out.println("2. Filter Pets & Apply");
            System.out.println("3. Review Applications & Schedule Home Visit");
            System.out.println("4. Approve Adoption");
            System.out.println("5. Book Veterinary Appointment");
            System.out.println("6. Record Veterinary Visit");
            System.out.println("7. Vaccination Reminders");
            System.out.println("8. Adoption Statistics");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.println("FR1: List Pets");
                    break;

                case 2:
                    System.out.println("FR2: Filter Pets & Apply");
                    break;

                case 3:
                    System.out.println("FR3: Review Applications & Schedule Home Visit");
                    break;

                case 4:
                    System.out.println("FR4: Approve Adoption");
                    break;

                case 5:
                    System.out.println("FR5: Book Veterinary Appointment");
                    break;

                case 6:
                    System.out.println("FR6: Record Veterinary Visit");
                    break;

                case 7:
                    System.out.println("FR7: Vaccination Reminders");
                    break;

                case 8:
                    System.out.println("FR8: Adoption Statistics");
                    break;

                case 0:
                    System.out.println("Exiting Pet Adoption Portal...");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 0-8.");
            }

        } while (choice != 0);

        scanner.close();
    }
}