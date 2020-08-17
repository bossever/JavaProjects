public class LastDigitChecker {

    public static boolean isValid(int number) {
        return (number >= 10 && number <= 1000);
    }

    public static boolean hasSameLastDigit(int a, int b, int c) {

        if (!(isValid(a) && isValid(b) && isValid(c))) {
            return false;
        }

        int last_a = a % 10;
        int last_b = b % 10;
        int last_c = c % 10;

        return (last_a == last_b || last_b == last_c || last_c == last_a);
    }
}
