package com.unitedcoder.decision;

import java.util.Scanner;

public class ATMDemo4 {
    public static void main(String[] args) {
        double accountBalance=5000.50;
        Scanner input=new Scanner(System.in);
        System.out.println("please enter your pin");
        int pin=input.nextInt();
        if (pin ==1234) {
            System.out.println("your account number is 123456789");
            System.out.println("your account balance is $5000.50");
        }
        else {
            System.out.println("please tyr again with your correct pin");
        }

        System.out.println("please enter the amount to withdraw");
        double withdrawAmount=input.nextDouble();
        if (withdrawAmount<=accountBalance){
            double balance=accountBalance-withdrawAmount;
            System.out.println("please take your cash in the cash dispenser");
            System.out.println(String.format("your balance %.2f",balance));
        }
        else {
            System.out.println("Insufficient fund");
            System.out.println("please enter an amount less than your balance"+accountBalance);
        }
    }
}
