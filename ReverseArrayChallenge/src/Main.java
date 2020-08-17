import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the length of array : ");
        int length = scanner.nextInt();
        scanner.nextLine();

        int[] array = getIntegers(length);

        System.out.println("Default array = " + Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed array = " + Arrays.toString(array));
    }

    public static void reverse(int[] array) {

        for (int i = 0; i < array.length/2; i++) {
            array[i] = array[array.length - i - 1] + array[i];
            array[array.length - i - 1] = array[i] - array[array.length - i - 1];
            array[i] = array[i] - array[array.length - i - 1];
        }
    }

    public static int[] getIntegers(int length) {
        System.out.println("\nEnter " + length + " integers : \n");
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return array;
    }
}
