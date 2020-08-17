public class TeenNumberChecker {

    public static boolean hasTeen(int a, int b, int c) {

        if (a > 19 || a < 13) {

            if (b > 19 || b < 13) {

                if (c > 19 || c < 13) {
                    return false;
                }
                else {
                    return true;
                }
            }
            else {
                return true;
            }
        }
        else {
            return true;
        }
    }

    public static boolean isTeen(int age) {

        if (age >= 13 && age <=19) {
            return true;
        }
        else {
            return false;
        }
    }
}
