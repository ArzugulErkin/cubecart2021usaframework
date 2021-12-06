package com.unitedcoder.homework;

import java.util.Scanner;

public class TaxCalculator {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.print("Please enter your income:  ");
        double income=in.nextDouble();
        System.out.println("Are you married? (Y/N)");
        String input=in.next();
        int status;
        if(input.equalsIgnoreCase("Y"))
            status=TaxReturn.MARRIED;
        else
            status=TaxReturn.SINGLE;
        TaxReturn myTaxReturn=new TaxReturn(income,status);
        System.out.println("Tax: "+myTaxReturn.getTax());
    }
}
