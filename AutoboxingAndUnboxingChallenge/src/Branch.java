import java.util.ArrayList;
import java.util.Scanner;

public class Branch {

    private String branchName;
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    Scanner scanner = new Scanner(System.in);


    public Branch(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void showCustomers() {
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("    --> " + customers.get(i).getName());
        }
    }

    public void showCustomerDetail() {
        System.out.print("Enter customer name : ");
        String customerName = scanner.nextLine();

        if (searchForCustomer(customerName) >= 0) {
            customers.get(searchForCustomer(customerName)).showTransactions();
        }
        else {
            System.out.println("Customer with name " + customerName + " does not exist.");
        }
    }

    public void addCustomer() {
        System.out.print("Enter customer name : ");
        String name = scanner.nextLine();
        if (searchForCustomer(name) >= 0) {
            System.out.println("Customer already exists on database. Enter a different name to proceed.");
        }
        else {
            System.out.print("Enter initial deposit (transaction) : ");
            double transaction = scanner.nextDouble();
            scanner.nextLine();

            customers.add(new Customer(name, transaction));
        }
    }

    public void addTransaction() {
        System.out.print("Enter customer name : ");
        String customerName = scanner.nextLine();
        int index = searchForCustomer(customerName);

        if (index >= 0) {
            System.out.print("Enter transaction amount : ");
            double transactionAmount = scanner.nextDouble();
            scanner.nextLine();
            customers.get(index).transaction(transactionAmount);
            System.out.println("Transaction successfully processed.");
        }
        else {
            System.out.println("Customer with name " + customerName + " not found. \nTransaction failed.");
        }
    }

    public int searchForCustomer(String name) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getName().equals(name)) {
                index = i;
                return index;
            }
        }
        return index;
    }
}