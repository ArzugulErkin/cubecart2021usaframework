package com.unitedcoder.methodtutorial;

public class BankAccount {
    private int accountNumber;
    private double accountBalance;
    private String accountName;
    public BankAccount() {
    }
    public BankAccount(int accountNumber, double accountBalance, String accountName) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountName = accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    // print welcome statement
    public void welcomeMessage(String message)
    {
        System.out.println(message);
    }
    //deposit money
    public double depositMoney(double depositAmount)
    {
        accountBalance=accountBalance+depositAmount;
        return accountBalance;
    }
    //withdraw money
    public double withdrawMoney(double withdrawAmount)
    {
        if(withdrawAmount<accountBalance)
        {
            accountBalance=accountBalance-withdrawAmount ;
            return accountBalance;
        }
        else {
            System.out.println("You have insufficient fund");
            System.out.println("Your balance was "+accountBalance);
            return accountBalance;
        }

    }
    //check balance
    public void checkAccountBalance()
    {
        System.out.println("Account balance is "+accountBalance);
    }
    //transfer money
    public void transferMoney(int receiverAccountNumber, double receiverBalance, double transferAmount)
    {
        if(transferAmount<accountBalance)
        {

          double  finalBalance=receiverBalance+transferAmount;
            System.out.println("Receiver original balance "+receiverBalance);
            System.out.println("receiver final balance is "+finalBalance);
            System.out.println("Your original balance was "+accountBalance);
            double originalBalance=accountBalance-transferAmount;
            System.out.println("Your final balance is "+String.valueOf(originalBalance));
        }
        else {
            System.out.println("We cannot perform the transfer because you do not have a sufficient fund");
            System.out.println("Your balance was "+accountBalance);
            System.out.println("You wanted to transfer "+transferAmount);
        }

    }
}
