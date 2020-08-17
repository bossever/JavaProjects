import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int counter = 1, sum = 0;

        while (counter <= 10) {

            System.out.println("Enter number #" + counter);
            counter++;
            boolean isInteger = scanner.hasNextInt();

            if (isInteger) {
                sum += scanner.nextInt();
            }
            else {
                System.out.println("Invalid number");
                counter--;
            }
            scanner.nextLine();
        }
        System.out.println("Sum = " + sum);
        scanner.close();
    }
}
