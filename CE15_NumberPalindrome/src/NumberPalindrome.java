public class NumberPalindrome {

    public static boolean isPalindrome(int number) {

        number = Math.abs(number);
        int reversed = 0;
        int lastDigit;
        int temp = number;

        while (temp > 0) {
            reversed = (reversed * 10) + (temp % 10);
            temp /= 10;

        }

        return reversed == number;
    }
}
