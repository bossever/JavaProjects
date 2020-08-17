import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
//      GearBox mcLaren = new GearBox(6);

//      GearBox.Gear first = mcLaren.new Gear(1, 12.3);
//      GearBox.Gear second = new GearBox.Gear(2, 15.4);   * Not the correct way to instantiate an object of the inner class
//      GearBox.Gear third = new mcLaren.Gear(3, 17.8);;   * Not the correct way to instantiate an object of the inner class

//      mcLaren.operateClutch(true);
//      mcLaren.changeGear(1);
//      mcLaren.operateClutch(false);
//      System.out.println(mcLaren.wheelSpeed(1000));
//      mcLaren.changeGear(2);
//      System.out.println(mcLaren.wheelSpeed(3000));
//      mcLaren.operateClutch(true);
//      mcLaren.changeGear(3);
//      mcLaren.operateClutch(false);
//      System.out.println(mcLaren.wheelSpeed(6000));

//        class ClickListener implements Button.OnClickListener {
//            public ClickListener() {
//                System.out.println("I have been attached.");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked.");
//            }
//        }

//        btnPrint.setOnClickListener(new ClickListener());

        btnPrint.setOnClickListener(new Button.OnClickListener() {    //Anonymous inner class
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked. ");
            }
        });
        listen();
    }

    private static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
            }
        }
    }
}
