/*  	// You job is to create a simple banking application.
        // There should be a Bank class
        // It should have an ArrayList of Branches
        // Each Branch should have an ArrayList of Customers
        // The Customer class should have an ArrayList of Doubles (transactions)
        // Customer:
        // Name, and the ArrayList of doubles.
        // Branch:
        // Need to be able to add a new customer and initial transaction amount.
        // Also needs to add additional transactions for that customer/branch
        // Bank:
        // Add a new branch
        // Add a customer to that branch with initial transaction
        // Add a transaction for an existing customer for that branch
        // Show a list of customers for a particular branch and optionally a list
        // of their transactions
        // Demonstrate autoboxing and unboxing in your code
        // Hint: Transactions
        // Add data validation.
        // e.g. check if exists, or does not exist, etc.
        // Think about where you are adding the code to perform certain actions
 */

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Bank noBank = new Bank();

    public static void main(String[] args) {
        bankPortalMenu();
        scanner.close();
    }

    public static void bankPortalMenu() {
        boolean willLoop = true;

        while(willLoop) {
            System.out.println("\n\nChoose an option : \n1. Show list of branches \n2. Create a branch \n3. Enter branch portal \n4. Quit application");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    noBank.showBranches();
                    break;
                case 2:
                    noBank.addBranch();
                    break;
                case 3:
                    noBank.branchPortalMenu();
                    break;
                case 4:
                    willLoop = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}