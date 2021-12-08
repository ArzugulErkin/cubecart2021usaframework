package com.unitedcoder.decision;
import java.util.Scanner;
public class ATMDemo5 {
    public static void main(String[] args) {
     double accountBalance=5000.50;
        Scanner input=new Scanner(System.in);
        for(int i=1;i<=3;i++) {
            System.out.println("Please input your pin");
            if (input.nextInt() == 1234) {
                System.out.println("Please input the amount to withdraw");
                double withdrawAmount = input.nextDouble();
                //make decision
                if (withdrawAmount <= accountBalance) {
                    double balance = accountBalance - withdrawAmount;
                    System.out.println("Please take your cash in the cash dispenser");
                    System.out.println(String.format("Your balance %.2f", balance));
                } else {
                    System.out.println("Insufficient fund");
                    System.out.println("Please enter an amount less than your balance " + accountBalance);
                }
                break;  //break the loop after withdrawing the money
            }
            else {
                System.out.println("Please try again with your correct pin, you have already tried " + i + " times");
                System.out.println("You can try 3 times");
            }
        }
    }
}
