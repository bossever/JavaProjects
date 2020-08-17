package com.ayushman;

import java.util.Scanner;

public class Printer {

    private int x;

    public Printer() {
        X x = new X();
        x();
        x.x();
    }

    private void x() {
        Scanner x = new Scanner(System.in);
        System.out.print("Enter an integer : ");
        this.x = x.nextInt();
    }

    private class X{

        public void x() {

            for (int x = 1; x <= 12; x++) {
                System.out.println(Printer.this.x + " x " + x + " = " + (x*(Printer.this.x)) );
            }
        }
    }
}
