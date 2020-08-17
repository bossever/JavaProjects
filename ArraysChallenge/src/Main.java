/* 	    // Create a program using arrays that sorts a list of integers in descending order.
        // Descending order is highest value to lowest.
        // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
        // ultimately have an array with 106,81,26, 15, 5 in it.
        // Set up the program so that the numbers to sort are read in from the keyboard.
        // Implement the following methods - getIntegers, printArray, and sortIntegers
        // getIntegers returns an array of entered integers from keyboard
        // printArray prints out the contents of the array
        // and sortIntegers should sort the array and return a new array containing the sorted numbers
        // you will have to figure out how to copy the array elements from the passed array into a new
        // array and sort them and return the new sorted array.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        printArray(sortIntegers(getIntegers()));
    }

    public static int[] getIntegers() {

        System.out.println("Enter the length of array : ");
        Scanner scanner = new Scanner(System.in);
        int lengthOfArray = scanner.nextInt();
        scanner.nextLine();
        int[] array = new int[lengthOfArray];

        System.out.println("Enter " + lengthOfArray + " integers : \n");

        for (int i = 0; i < lengthOfArray; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {

        int[] sortedArray = new int[array.length];
        int max = 0;
        boolean firstComparison = true;

        for (int i = 0; i < array.length; i++) {

            max = array[0];
            if (firstComparison) {

                for (int j = 0; j < array.length; j++) {

                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                firstComparison = false;
            }
            else {
                for (int j = 0; j < array.length; j++) {

                    if (array[j] >= max && array[j] < sortedArray[i - 1]) {
                        max = array[j];
                    }
                }
            }
            sortedArray[i] = max;
        }
        return sortedArray;
    }
}
