package com.unitedcoder.datatype;

import java.util.Scanner;  //using the Scanner object in this code
public class ScannerExample {

        public static void main(String[] args)
        {
            Scanner number=new Scanner(System.in);
            System.out.print("Please enter a number: ");
            if(number.nextInt()%2==0)
                System.out.println("You entered an even number");
            else
                System.out.println("You entered an odd number");

        }
    }

