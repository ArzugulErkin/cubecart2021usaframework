package com.unitedcoder.methodtutorial;

public class Calculator {
    //defining instance variables
    private String type;
    private String version;
    private String size;
    //define constructor and generate getter
    public Calculator() {
    }
    public Calculator(String type, String version, String size) {
        this.type = type;
        this.version = version;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public String getSize() {
        return size;
    }
    //design methods
    public int addNumbers(int number1,int number2)  //add two integers
    {
        int sum=number1+number2;
        return sum;
    }
    public long addNumbers(int number1,long number2)  //add two integers
    {
        long sum=number1+number2;
        return sum;
    }
    //method overload
    public double addNumbers(double d1, double d2) //add two double numbers
    {
        return d1+d2;
    }
    //add many numbers
    public long addNumbers(long... numbers) // 3 dots represent any number of values, call it dynamic variables
    {
        long total=0;
        for(long eachNumber: numbers)
        {
            total=total+eachNumber;
        }
        return total;
    }
    public int subtractNumbers(int a,int b)
    {
        System.out.println(String.format("%d-%d=%d",a,b,a-b));
        return a-b;
    }
    public double multiplyNumbers(double x,double y)
    {
        double multiplication=x*y;
        System.out.println(String.format("%.2f * %.2f=%.2f",x,y,multiplication));
        return multiplication;
    }
    public double divideNumbers(double numerator,double denominator)
    {
        if(denominator==0)
        {
            System.out.println("You cannot divide a number by 0");
            return 0;
        }
        else {
            double result=numerator/denominator;
            System.out.println(String.format("%.2f / %.2f = %.2f",numerator,denominator,result));
            return result;
        }
    }
    public void calculatePower(double base, double power)
    {
        double powerResult=Math.pow(base,power);
        System.out.println(String.format("the %.1f power of number %.1f = %.1f",power,base,powerResult));
    }
    public void calculateSquareRoot(double number)
    {
        System.out.println("Square root of "+number+ "is "+Math.sqrt(number));

        System.out.println(String.format("Square root of %.1f   is    %.1f",number,Math.sqrt(number)));
    }
    public void printCalculatorType()
    {
        System.out.println(getType());
    }
    //static calculate rectangle area method
    public static long calculateRectangleArea(long width, long height)
    {
        long area=width*height;
        System.out.printf("the area of a rectangle %d by %d is %d ",width,height,area);
        return area;
    }
    public static void calculateCircleArea(int radius)
    {
        System.out.println(Math.PI*radius*radius);
    }
    public static double calculateTriangleArea(int base, int height)
    {
        double area=(base*height)/2;
        System.out.println("The area of a triangle is "+area);
        return area;
    }

}
