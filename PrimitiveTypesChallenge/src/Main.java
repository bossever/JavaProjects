public class Main {

    public static void main(String[] args) {

        byte myByte = 12;
        short myShort = 128;
        int myInt = 99999;
        long myLong = 50000L + 10L*(myByte + myShort + myInt);

        System.out.println("myLong = " + myLong);
    }
}
