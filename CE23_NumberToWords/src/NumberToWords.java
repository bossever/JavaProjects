public class NumberToWords {

    public static void numberToWords(int number) {

        if (number < 0) {
            System.out.println("Invalid Value");
        }
        else if (number == 0) {
            System.out.println("Zero");
        }
        else {
            int rev_number = reverse(number);
            int zeros = getDigitCount(number) - getDigitCount(rev_number);

            while (rev_number > 0) {

                switch (rev_number % 10) {
                    case 0: System.out.println("Zero");
                            break;
                    case 1: System.out.println("One");
                            break;
                    case 2: System.out.println("Two");
                            break;
                    case 3: System.out.println("Three");
                            break;
                    case 4: System.out.println("Four");
                            break;
                    case 5: System.out.println("Five");
                            break;
                    case 6: System.out.println("Six");
                            break;
                    case 7: System.out.println("Seven");
                            break;
                    case 8: System.out.println("Eight");
                            break;
                    case 9: System.out.println("Nine");
                }
                rev_number /= 10;
            }

            for (int i = 0; i < zeros; i++) {
                System.out.println("Zero");
            }
        }
    }

    public static int reverse(int number) {

        boolean isNegative = number < 0;
        number = Math.abs(number);
        int rvr = 0;
        while (number > 0) {
            rvr = (rvr * 10) + (number % 10);
            number /= 10;
        }
        rvr = isNegative ? -rvr : rvr;
        return rvr;
    }

    public static int getDigitCount(int number) {

        if (number < 0) {
            return -1;
        }

        int digits = 0;
        do {
            digits++;
            number /= 10;
        } while (number > 0);
        return digits;
    }
}
