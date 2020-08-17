public class SharedDigit {

    public static boolean hasSharedDigit(int number1, int number2) {

        if ((number1 < 10 || number1 > 99) || (number2 < 10 || number2 > 99)) {
            return false;
        }

        int n1_first = number1 / 10;
        int n1_last = number1 % 10;

        int n2_first = number2 / 10;
        int n2_last = number2 % 10;

        return (n1_first == n2_first || n1_first == n2_last || n1_last == n2_first || n1_last == n2_last);
    }
}
