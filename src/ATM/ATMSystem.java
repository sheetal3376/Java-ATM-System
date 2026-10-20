package ATM;

import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account userAccount = new Account("ACC12345", 1234, 5000.00);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (userAccount.validatePin(enteredPin)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Current Balance: ₹" + userAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        userAccount.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        userAccount.withdraw(withdrawAmount);
                        break;
                    case 4:
                        userAccount.printTransactionHistory();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Incorrect PIN. Access Denied.");
        }

        scanner.close();
    }
}