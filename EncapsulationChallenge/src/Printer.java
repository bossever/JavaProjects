public class Printer {

    private int tonerLevelPercent = 100;
    private int pagesPrinted = 0;
    private boolean duplex = false;

    public Printer(boolean duplex) {
        this.duplex = duplex;

        showStats();
    }

    public void fillToner(int amountPercent) {

        if (tonerLevelPercent + amountPercent > 100) {
            tonerLevelPercent = 100;
        }
        else {
            tonerLevelPercent += amountPercent;
        }
        System.out.println("Toner Level (percentage) = " + tonerLevelPercent);
    }

    public void printPages(int pages) {

        if (duplex && ((tonerLevelPercent - (pages*2)) >= 0)) {
            pagesPrinted += (pages * 2);
            tonerLevelPercent -= (pages * 2);
            System.out.println("Printing...");
            System.out.println("Pages printed = " + pages*2 + " | Total pages printed to date = " + pagesPrinted + " | Toner Level (percentage) = " + tonerLevelPercent);
        }
        else if (!duplex &&tonerLevelPercent - pages >= 0){
            pagesPrinted += pages;
            tonerLevelPercent -= pages;
            System.out.println("Printing...");
            System.out.println("Pages printed = " + pages + " | Total pages printed to date = " + pagesPrinted + " | Toner Level (percentage) = " + tonerLevelPercent);
        }
        else {
            System.out.println("Not enough ink to print " + pages + " page(s)! Please fill/replace toner cartridge.");
        }
    }

    public void showStats() {
        System.out.println("Total pages printed to date = " + pagesPrinted + " | Toner level (percentage) = " + tonerLevelPercent);
    }
}
