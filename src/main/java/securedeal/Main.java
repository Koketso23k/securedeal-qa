package securedeal;

import java.util.Scanner;

/**
 * A very simple text menu to try out a SecureDeal transaction.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Buyer name: ");
            String buyer = scanner.nextLine();

            System.out.print("Item name: ");
            String item = scanner.nextLine();

            System.out.print("Price (R): ");
            double price = Double.parseDouble(scanner.nextLine());

            Transaction transaction = new Transaction(buyer, item, price);
            System.out.println("Created: " + transaction);

            System.out.print("New status (PENDING, SHIPPED, RECEIVED): ");
            String statusText = scanner.nextLine().trim().toUpperCase();
            transaction.updateStatus(TransactionStatus.valueOf(statusText));
            System.out.println("Updated: " + transaction);

        } catch (NumberFormatException e) {
            System.out.println("Error: price must be a number");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
