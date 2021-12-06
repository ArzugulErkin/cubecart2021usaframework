package com.unitedcoder.decision;

import java.util.Scanner;

public class ATMDemo1 {
    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Please input your pin");
        int pin=input.nextInt();
        // Rule 1:  after if statement, there is no ;
        // Rule 2:  if you have multiple statements after the if or else keyword,
        // you need to use curly bracket
        if(pin==1234) {
            System.out.println("Your account number is 123456789");
            System.out.println("Your account balance is $1000");
        }
        else
            System.out.println("Please try again with your correct pin");
    }
}
