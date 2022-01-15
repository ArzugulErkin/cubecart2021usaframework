package com.unitedcoder.methodtutorial;

import org.apache.commons.lang3.StringUtils;

public class CalculatorDemo {
    public static void main(String[] args)
    {
        Calculator calc1=new Calculator("Simple Calculator","1.0","Standard");
        System.out.println(String.format("%s %s %s",calc1.getType(),calc1.getVersion(),calc1.getSize()));
        System.out.println(calc1.addNumbers(100,300));
        System.out.println(calc1.addNumbers(100,123456789123l));
        double d=calc1.addNumbers(10.23, 25.65);
        System.out.println(String.format("%.2f",d));
        System.out.println(calc1.addNumbers(100,200,300,500,1200,1500,2000,2500,35000,100000));
        //add two integers ang get the result and then add the result to another integer
        int result1=calc1.addNumbers(25,75);
        int finalResult=calc1.addNumbers(result1,300);
        System.out.println("Result is "+finalResult);
        calc1.divideNumbers(100,20);
        calc1.divideNumbers(150,0);
        calc1.printCalculatorType();
        calc1.calculatePower(100,3);
        calc1.calculateSquareRoot(100);
        calc1.multiplyNumbers(20,30);
        //using static methods
        Calculator.calculateCircleArea(5);
        Calculator.calculateRectangleArea(10,8);
        Calculator.calculateTriangleArea(10,4);
        System.out.println(StringUtils.isNumeric("abcd"));

    }
}
