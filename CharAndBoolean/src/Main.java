public class Main {

    public static void main(String[] args) {

        char myChar = 'D';
        char myUnicodeChar = '\u0044';      //The escape sequence is used when assigning characters through the Unicode code set
        System.out.println("myChar = " + myChar);
        System.out.println("myUnicodeChar = " + myUnicodeChar);
        char myCopyrightChar = '\u00A9';
        System.out.println("myCopyrightChar = " + myCopyrightChar);

        boolean myTrueBoolean = true;
        boolean myFalseBoolean = false;

        boolean isCustomerOver21 = true;
        System.out.println("isCustomerOver21 = " + isCustomerOver21);
    }
}
