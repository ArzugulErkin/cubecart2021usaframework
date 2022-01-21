package com.unitedcoder.interfacetutorial;

public class CalculatorApplication {
    public static void main(String[] args) {
        ICalculator calculator=new Calculator();
        System.out.println(ICalculator.version);
        System.out.println(calculator.addTwoNumbers(10.20,5.80));

        System.out.println(calculator.addMultipleNumbers(10,20,30,40,60));

        System.out.println(calculator.multiplyTwoNumbers(10,20));

        System.out.println(calculator.divideTwoNumbers(200,10));

        System.out.println(calculator.subtractTwoNumber(50,30));


    }
}
