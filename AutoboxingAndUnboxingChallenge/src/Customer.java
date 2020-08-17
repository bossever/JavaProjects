import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, double firstTransaction) {
        this.name = name;
        this.transactions.add(firstTransaction);
    }

    public void transaction(double amount) {
        transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public void showTransactions() {
        System.out.println("\n" + name + "'s transactions : ");

        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("    --> " + transactions.get(i));
        }
        System.out.println("");
    }
}