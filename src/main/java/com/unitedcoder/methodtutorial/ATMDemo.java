package com.unitedcoder.methodtutorial;

public class ATMDemo {
    public static void main(String[] args) {
        BankAccount myAccount=new BankAccount(123456789,5000,"Dolkun Tarim");
        myAccount.welcomeMessage("Welcome to the US Bank");
        System.out.println("Account number " + myAccount.getAccountNumber());
        System.out.println("Account balance: " + myAccount.getAccountBalance());
        System.out.println("Account Name: " + myAccount.getAccountName());
       double balance= myAccount.depositMoney(1000);
        System.out.println(balance);

        double balanceAfterWithdraw=myAccount.withdrawMoney(500);
        System.out.println(balanceAfterWithdraw);

        myAccount.checkAccountBalance();
        BankAccount tursunayAccount=new BankAccount(987654,3000,"Tursunay");
        myAccount.transferMoney(tursunayAccount.getAccountNumber(), tursunayAccount.getAccountBalance(), 1000);

        BankAccount dilmuratAccount=new BankAccount(3455566,10000,"Dilmurat");
        dilmuratAccount.welcomeMessage("Welcome to Toronto Bank");
        dilmuratAccount.checkAccountBalance();
        System.out.println(dilmuratAccount.depositMoney(1000));
    }
}
