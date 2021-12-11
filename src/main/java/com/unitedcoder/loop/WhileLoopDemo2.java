package com.unitedcoder.loop;

public class WhileLoopDemo2 {
    public static void main(String[] args) {
        double balance=10000;
        double bankRate=0.05;
        double targetBalance=15000;
        int year=0;
        while (balance<=targetBalance)
        {
            year++;
            double interestAmount=balance*bankRate;
            balance=balance+interestAmount;
            System.out.println(String.format("Year=%d  InterestAmount=%.2f,  balance=%.2f",year,interestAmount,balance));
            //System.out.println("Year="+year+ "  InterestAmount="+interestAmount+"    balance="+balance);
        }
        System.out.println("Total Years: "+year);
        System.out.println("Final Balance: "+balance);
    }
}
