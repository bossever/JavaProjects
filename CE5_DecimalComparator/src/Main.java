public class Main {

    public static void main(String[] args) {

        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(2.345, 2.3456));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(1.2, 1.200));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-1.2, 1.2));

    }
}
