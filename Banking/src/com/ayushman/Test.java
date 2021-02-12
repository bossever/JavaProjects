package com.ayushman;

import java.lang.*;

public class Test {

    public static void main(String args[]) {
        try {
            int a = 0;
            int d = 5/a;
            int ar[] = new int[2];
            System.out.println("Access Element three : " + ar[3]);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Exception thrown : \n" + e1);
        }
        System.out.println("After Catch Block");
    }
}