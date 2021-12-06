package com.unitedcoder.decision;
import java.util.Scanner;

public class ConditionOperatorDemo2 {
    public static void main(String[] args) {
        System.out.println("Please enter a number from 1 to 9");
        System.out.println("1 for Chrome browser, other numbers for Firefox browser");
        Scanner input=new Scanner(System.in);
        int browserValue=input.nextInt();
        //use condition operator
        String browser=browserValue==1?"Chrome Browser": "Firefox Browser";
        System.out.println("You are running the test under "+browser);
    }
}
