package com.unitedcoder.decision;

import java.util.Scanner;

public class ATMDemo2 {
    public static void main(String[] args) {
     double accountBalance=5000.50;
        Scanner input=new Scanner(System.in);
        System.out.println("Please input the amount to withdraw");
        double withdrawAmount=input.nextDouble();
        //make decision
        if(withdrawAmount<=accountBalance)
        {
            double balance=accountBalance-withdrawAmount;
            System.out.println("Please take your cash in the cash dispenser");
            System.out.println(String.format("Your balance %.2f",balance));
        }
        else {
            System.out.println("Insufficient fund");
            System.out.println("Please enter an amount less than your balance "+accountBalance);
        }
    }
}
