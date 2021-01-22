public class Main {
    public static void main(String[] args) {

        int myInteger = 0;
        {
            myInteger = 2;
        }
        System.out.println("myInteger = " + myInteger);

        switch (myInteger) {
            case 2:
            {
                System.out.println(myInteger++);
            }
            break;

            default:
                break;
        }
    }
}
