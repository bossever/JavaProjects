public class Main {
    public static void main(String[] args) {
        double firstVal = 20.0;
        double secondVal = 80.0;
        double firstSecond = 100.0 * (firstVal + secondVal);
        double remainder = firstSecond % 40.0;
        boolean myBool;

        if (remainder == 0) {
            myBool = true;
        }
        else {
            myBool = false;
            System.out.println("Remainder = " + remainder);
        }

        System.out.println("myBool = " + myBool);
    }
}
