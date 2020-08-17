import java.util.Scanner;

public class BaseHamburger {

    private String breadRollType;
    private String meatType;
    private boolean lettuce = false, tomato = false, carrot = false, cheeseSlice = false;
    protected double cost = 0;

    public String getBreadRollType() {
        return breadRollType;
    }

    public String getMeatType() {
        return meatType;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    public boolean isCarrot() {
        return carrot;
    }

    public boolean isCheeseSlice() {
        return cheeseSlice;
    }

    public double getCost() {
        return cost;
    }



    public BaseHamburger() {

        System.out.println("Base constructor called");
        breadRollType = setBread();
        meatType = setMeat();

        System.out.println("\nCost of Base Hamburger = $" + cost + "\nWould you like to make any additions? (y/n)");
        Scanner scannerAdditions = new Scanner(System.in);
        char yesNo = scannerAdditions.next().charAt(0);
        scannerAdditions.nextLine();

        if (yesNo == 'y' || yesNo == 'Y') {
            this.additions();
        }
        else {
            System.out.println("Thank you for ordering, your net total is $" + cost);
        }

        scannerAdditions.close();
    }

    protected String setBread() {

        //Bread Type
        while(true) {

            System.out.println("\nChoose Bread Roll type ($0.90): ");
            System.out.println("\n1. White Bread \n2. Brown Rye Bread \n3. Soft Milk Bread ");

            Scanner scannerBread = new Scanner(System.in);
            int breadTypeChoice = scannerBread.nextInt();
            scannerBread.nextLine();

            switch (breadTypeChoice) {
                case 1:
                    cost += 0.90;
                    return "White Bread";


                case 2:
                    cost += 0.90;
                    return "Brown Rye Bread";


                case 3:
                    cost += 0.90;
                    return "Soft Milk Bread";


                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    protected String setMeat() {

        //Meat Type
        while (true) {

            System.out.println("\nChoose Meat Type ($1.00): ");
            System.out.println("\n1. Chicken \n2. Beef \n3. Pork");

            Scanner scannerMeat = new Scanner(System.in);
            int meatTypeChoice = scannerMeat.nextInt();
            scannerMeat.nextLine();

            switch (meatTypeChoice) {
                case 1:
                    cost += 1;
                    return "Chicken";


                case 2:
                    cost += 1;
                    return "Beef";


                case 3:
                    cost += 1;
                    return "Pork";

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    protected void additions() {

        while (true) {
            System.out.println("\nChoose an addition : ");
            int i = 1, lettuceChoice = 0, tomatoChoice = 0, carrotChoice = 0, cheeseChoice = 0;

            if (!lettuce) {
                System.out.println("\n" + i + ". Lettuce ($0.30)");
                lettuceChoice = i;
                i++;
            }
            if (!tomato) {
                System.out.println(i + ". Tomato ($0.40)");
                tomatoChoice = i;
                i++;
            }
            if (!carrot) {
                System.out.println(i + ". Carrot ($0.30)");
                carrotChoice = i;
                i++;
            }
            if (!cheeseSlice) {
                System.out.println(i + ". Cheese Slice ($0.50)");
                cheeseChoice = i;
            }

            Scanner scannerMoreAdditions = new Scanner(System.in);
            int additionChoice = scannerMoreAdditions.nextInt();
            scannerMoreAdditions.nextLine();

            if (additionChoice == lettuceChoice) {
                this.lettuce = true;
                cost += 0.30;
            } else if (additionChoice == tomatoChoice) {
                this.tomato = true;
                cost += 0.40;
            } else if (additionChoice == carrotChoice) {
                this.carrot = true;
                cost += 0.30;
            } else if (additionChoice == cheeseChoice) {
                this.cheeseSlice = true;
                cost += 0.50;
            } else {
                System.out.println("Invalid choice\n");
            }

            System.out.println("Do you want more additions? (y/n)");
            char yesNo = scannerMoreAdditions.next().charAt(0);

            if (yesNo == 'y' || yesNo == 'Y') {
                //noinspection UnnecessaryContinue
                continue;
            }
            else {
                scannerMoreAdditions.close();
                break;
            }
        }

        System.out.println("Thank you for ordering, your net total is $" + cost);
    }

    protected void setBreadRollType (String breadRollType) {
        this.breadRollType = breadRollType;
        cost += 0.90;
    }

    protected void setMeatType (String meatType) {
        this.meatType = meatType;
        cost += 1;
    }
}
