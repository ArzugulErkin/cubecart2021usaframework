package com.unitedcoder.decision;
import java.util.Scanner;
public class ConditionOperatorDemo1 {
    public static void main(String[] args) {
        System.out.println("Please input the first number ");
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        System.out.println("Please input the second number ");
        int y=input.nextInt();
        int z=x>y ? x:y ; //if x is greater than y, z=x; else z=y;
        System.out.println(String.format("z=%d",z));
    }
}
