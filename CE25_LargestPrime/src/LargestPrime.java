public class LargestPrime {

    public static int getLargestPrime(int number) {

        if (number <= 0) {
            return -1;
        }

        int largestPrimeFactor = number;

        for(int i = 2; i <= number/2; i++) {

            if (number % i == 0) {

                boolean isPrime = true;
                for (int j = 2; j <= i/2; j++) {

                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    largestPrimeFactor = i;
                }
            }
        }
        if (largestPrimeFactor > 1) {
            return largestPrimeFactor;
        }
        else {
            return -1;
        }
    }
}
