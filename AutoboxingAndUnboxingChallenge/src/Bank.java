import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<Branch>();
    Scanner scanner = new Scanner(System.in);

    public void addBranch() {
        System.out.print("Enter branch name : ");
        String branchName = scanner.nextLine();

        if (searchForBranch(branchName) >= 0) {
            System.out.println("Branch already exists.");
        } else {
            branches.add(new Branch(branchName));
        }
    }

    public void branchPortalMenu() {

        System.out.print("Enter branch name : ");
        String branchName = scanner.nextLine();

        if (searchForBranch(branchName) >= 0) {
            boolean willLoop = true;

            while (willLoop) {
                System.out.println("\n\nChoose an option : \n1. Show list of customers \n2. Add a customer \n3. Show customer details \n4. Add/deduct money for a customer \n5. Exit branch portal");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        branches.get(searchForBranch(branchName)).showCustomers();
                        break;
                    case 2:
                        branches.get(searchForBranch(branchName)).addCustomer();
                        break;
                    case 3:
                        branches.get(searchForBranch(branchName)).showCustomerDetail();
                        break;
                    case 4:
                        branches.get(searchForBranch(branchName)).addTransaction();
                        break;
                    case 5:
                        willLoop = false;
                        break;
                }
            }
        }
        else {
            System.out.println("Branch with name " + branchName + " does not exist.");
        }
    }

    public void showBranches() {
        for (int i = 0; i < branches.size(); i++) {
            System.out.println("    --> " + branches.get(i).getBranchName());
        }
    }

    public int searchForBranch(String branchName) {
        int index = -1;
        for (int i = 0; i < branches.size(); i++) {

            if (branches.get(i).getBranchName().equals(branchName)) {
                index = i;
                return index;
            }
        }
        return index;
    }
}