import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Integer
        //Longer, slightly harder method

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            intArrayList.add(Integer.valueOf(i));   //Integer.valueOf(i) --> boxing
        }

        for (int i = 0; i <= 10; i++){
            System.out.println(i + " --> " + intArrayList.get(i).intValue());   //Integer.intValue() OR intArrayList.get(i).intValue() --> Unboxing
        }

        //Simpler method

        Integer myIntValue = 56;            //Autoboxing done by Java ~ Integer myIntValue = Integer.valueOf(56);
        int myInt = myIntValue;             //Auto-Unboxing done by Java ~ int myInt = myIntValue.intValue();





        //Double
        //Longer method

        ArrayList<Double> myDoubleValues = new ArrayList<Double>;
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5){
            myDoubleValues.add(Double.valueOf(dbl));
        }

        for (int i = 0; i < myDoubleValues.size(); i++) {
            System.out.println(i + " --> " + myDoubleValues.get(i).doubleValue());
        }
    }
}
