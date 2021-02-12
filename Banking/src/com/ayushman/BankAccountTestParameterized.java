package com.ayushman;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Ayushman", "Sachan", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test..");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {

        });
    }
}
