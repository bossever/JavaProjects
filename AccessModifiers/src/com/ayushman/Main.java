package com.ayushman;

public class Main {

    public static void main(String[] args) {
        Account ashusAccount = new Account("Ashu");
        ashusAccount.deposit(1000);
        ashusAccount.withdraw(500);
        ashusAccount.withdraw(-200);
        ashusAccount.deposit(-20);
        ashusAccount.calculateBalance();

        System.out.println("Balance on account is " + ashusAccount.getBalance());
    }
}
