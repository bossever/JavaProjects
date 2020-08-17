import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int min = 0, max = 0, num = 0;
        boolean first = true;

        while(true) {

            System.out.print("Enter an integer : ");
            boolean isInteger = scanner.hasNextInt();
            if (isInteger) {
                num = scanner.nextInt();

                if (first) {
                    min = num;
                    max = num;
                    first = false;
                }
                min = (num <= min) ? num : min;
                max = (num >= max) ? num : max;
            }
            else {
                break;
            }
        }
        System.out.println("Max = " + max + "\nMin = " + min);
        scanner.close();
    }
}
