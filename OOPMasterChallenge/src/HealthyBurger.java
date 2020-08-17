import java.util.Scanner;

public class HealthyBurger extends BaseHamburger{

    private boolean broccoli = false, cucumber = false;

    public HealthyBurger() {

        setBreadRollType("Brown Rye Bread");
        setMeatType(setMeat());

        System.out.println("\nCost of Base Hamburger = $" + cost + "\nWould you like to make any additions? (y/n)");
        Scanner scannerAdditions = new Scanner(System.in);
        char yesNo = scannerAdditions.next().charAt(0);

        if (yesNo == 'y' || yesNo == 'Y') {
            this.additions();
        }
        else {
            System.out.println("Thank you for ordering, your net total is $" + cost);
        }

        scannerAdditions.close();
    }

    @Override
    protected void additions() {
        super.additions();

        Scanner scannerAdditions = new Scanner(System.in);

        System.out.println("\nDo you want to add broccoli ($0.50)? (y/n)");
        char yesNo = scannerAdditions.next().charAt(0);
        System.out.println("aa");
        scannerAdditions.nextLine();
        broccoli = yesNo == 'y' || yesNo == 'Y';
        cost = broccoli ? (cost + 0.50) : cost;

        System.out.println("\nDo you want to add cucumber? ($0.50)(y/n)");
        yesNo = scannerAdditions.next().charAt(0);
        scannerAdditions.nextLine();
        cucumber = yesNo == 'y' || yesNo == 'Y';
        cost = cucumber ? (cost + 0.50) : cost;

        System.out.println("Thank you for ordering, your net total is $" + cost);

    }
}
