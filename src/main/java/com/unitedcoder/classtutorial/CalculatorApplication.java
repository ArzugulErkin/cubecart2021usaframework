package com.unitedcoder.classtutorial;

public class CalculatorApplication {
    public static void main(String[] args) {
        Calculator calculator=new Calculator("Scientific Calculator","Texas Instruments",
                "Micro Devices");
        System.out.println(calculator.getBrand());
        System.out.println(calculator.getFactory());
        System.out.println(calculator.getType());
    }
}
