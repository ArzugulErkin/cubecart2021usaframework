package com.unitedcoder.interfacetutorial;

public class Calculator implements ICalculator{
    public double addTwoNumbers(double d1, double d2) {
        return d1+d2;
    }

    public int addMultipleNumbers(int... numbers) {
        int sum=0;
        for(int n: numbers)
        {
            sum=sum+n;
        }
        return sum;
    }

    public double multiplyTwoNumbers(double d1, double d2) {
        return d1*d2;
    }

    public float divideTwoNumbers(double x, double y) {
        if(y==0)
        {
            System.out.println("the denominator cannot be zero");
            return 0;
        }
        else
        {
            float division=(float)(x/y);
            return division;
        }
    }

    @Override
    public long subtractTwoNumber(long l1, long l2) {
        return l1-l2;
    }
}
