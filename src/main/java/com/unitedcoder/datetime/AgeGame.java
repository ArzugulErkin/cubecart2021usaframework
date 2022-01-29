package com.unitedcoder.datetime;

import java.util.Scanner;

public class AgeGame {
    public static void main(String[] args) {
        System.out.println("Please enter your birthday in this format yyyy-mm-dd");
        Scanner scanner=new Scanner(System.in);

        String birthday=scanner.next();

        DateTimeUtility dateTimeUtility=new DateTimeUtility();

        System.out.println("Your age: "+dateTimeUtility.calculateAge(birthday));
    }
}
