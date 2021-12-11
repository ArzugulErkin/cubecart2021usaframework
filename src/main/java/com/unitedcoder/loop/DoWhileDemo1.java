package com.unitedcoder.loop;

public class DoWhileDemo1 {
    public static void main(String[] args) {
        double myInitialInvestment=10000;
        double bankInterestRate=0.05;
        double myTargetBalance=15000;
        double balance=0;
        int year=0; //before investing, year =0
        do {
            year++;  //increase year by 1
            double myInterest=myInitialInvestment*bankInterestRate;
            myInitialInvestment=myInitialInvestment+myInterest;
            balance=myInitialInvestment;
            System.out.println(String.format("Year=%d    Interest=%.2f     Balance=%.2f",year,myInterest,balance));
        }while (balance<=myTargetBalance);
        System.out.println("Total years: "+year);
        System.out.println(String.format("Final balance=%.2f",balance));
    }
}
