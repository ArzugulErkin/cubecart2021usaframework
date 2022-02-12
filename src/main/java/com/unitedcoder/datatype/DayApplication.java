package com.unitedcoder.datatype;

import java.util.Scanner;

public class DayApplication {
    
    public static void main(String[] args) {
        System.out.print("Please type a weekday name: ");
        Scanner scanner = new Scanner(System.in);
        String weekday = scanner.next();
        DayFeeling(Day.valueOf(weekday.toUpperCase()));
    }

     public static void DayFeeling(Day day)
     {
         switch (day)
         {
             case MONDAY:
                 System.out.println("Monday is a tough day");
                 break;

             case TUESDAY:
             case WEDNESDAY:
             case THURSDAY:
                 System.out.println("These days are so so");
                 break;

             case FRIDAY:
                 System.out.println("Happy friday, weekend is coming");
                 break;

             case SATURDAY:
             case SUNDAY:
                 System.out.println("Sweet weekends");
                 break;
         }
     }
}
