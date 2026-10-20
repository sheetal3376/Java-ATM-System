package ATM;


	
	
	import java.util.Scanner;

	public class ATMSystem {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        Account userAccount = new Account("123456", 9999, 5000.0);

	        System.out.println("--- WELCOME TO THE ATM ---");
	        System.out.print("Enter your 4-digit PIN: ");
	        int enteredPin = scanner.nextInt();

	        if (!userAccount.validatePin(enteredPin)) {
	            System.out.println("Incorrect PIN. Access Denied.");
	            scanner.close();
	            return;
	        }

	        int choice;
	        do {
	            System.out.println("\n--- MENU ---");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit Money");
	            System.out.println("3. Withdraw Money");
	            System.out.println("4. Exit");
	            System.out.print("Choose an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    System.out.println("Current Balance: ₹" + userAccount.getBalance());
	                    break;
	                case 2:
	                    System.out.print("Enter deposit amount: ");
	                    double dep = scanner.nextDouble();
	                    userAccount.deposit(dep);
	                    break;
	                case 3:
	                    System.out.print("Enter withdrawal amount: ");
	                    double with = scanner.nextDouble();
	                    userAccount.withdraw(with);
	                    break;
	                case 4:
	                    System.out.println("Thank you for using our ATM!");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        } while (choice != 4);

	        scanner.close();
	    }
	}


