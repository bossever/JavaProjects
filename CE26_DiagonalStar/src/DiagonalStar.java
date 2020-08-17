public class DiagonalStar {

    public static void printSquareStar(int number) {

        if (number < 5) {
            System.out.println("Invalid Value");
        }
        else {

            for (int currentRow = 1; currentRow <= number; currentRow++) {

                for (int currentColumn = 1; currentColumn <= number; currentColumn++) {

                    if ((currentRow == 1 || currentRow == number) || (currentColumn == 1 || currentColumn == number) || (currentColumn == currentRow) || (currentColumn == number - currentRow + 1)) {
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
    }
}
