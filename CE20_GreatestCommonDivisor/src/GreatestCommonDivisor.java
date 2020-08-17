public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int first, int second) {

        if (first < 10 || second < 10) {
            return -1;
        }

        int common = 1;

        for (int i = 1; i <= first/2; i++) {
            if (first % i == 0 && second % i == 0) {
                common = i;
            }
        }
        return common;
    }
}