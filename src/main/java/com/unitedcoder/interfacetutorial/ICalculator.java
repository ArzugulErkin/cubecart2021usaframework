package com.unitedcoder.interfacetutorial;

public interface ICalculator {
   static final String version="1.0";
    double addTwoNumbers(double d1,double d2); //method name, return type, arguments , no implementation
    int addMultipleNumbers(int... numbers);
    double multiplyTwoNumbers(double d1,double d2);
    float divideTwoNumbers(double x, double y);
    long subtractTwoNumber (long l1, long l2);

}
