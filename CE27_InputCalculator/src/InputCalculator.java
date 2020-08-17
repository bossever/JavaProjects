import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage() {

        Scanner scanner = new Scanner(System.in);
        int count = 0, sum = 0, finalAverage = 0;

        while (true) {

            boolean isInteger = scanner.hasNextInt();

            if (isInteger) {
                sum += scanner.nextInt();
                count++;
            }
            else {
                break;
            }
            scanner.nextLine();
        }
        if (count > 0) {
            finalAverage = (int) Math.round((double)sum / count);
        }
        System.out.println("SUM = " + sum + " AVG = " + finalAverage);
        scanner.close();
    }
}
