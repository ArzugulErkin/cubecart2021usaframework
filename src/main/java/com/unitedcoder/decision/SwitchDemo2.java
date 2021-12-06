package com.unitedcoder.decision;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class SwitchDemo2 {
    public static void main(String[] args) {
        System.out.print("Please enter a number from the console: ");
        Scanner input=new Scanner(System.in);
        String number=input.next(); //input a numeric string  = number
         if(StringUtils.isNumeric(number))
        {
            int digitCounts=number.length();  //get the length of the String
            switch (digitCounts)
            {
                case 1:
                    System.out.println("You entered 1 digit");
                    System.out.println("Your number is between 0 and 9");
                    break;
                case 2:
                    System.out.println("You entered 2 digits");
                    System.out.println("Your number is between 10 and 99");
                    break;
                case 3:
                    System.out.println("You entered 3 digits");
                    System.out.println("Your number is between 100 and 999");
                   break;
                default:
                    System.out.println("You entered more than 3 digits");
                    System.out.println("Your number is greater than or equal to 1000");
            }
        }
        else System.out.println("Please enter a numeric string ");
    }
}
