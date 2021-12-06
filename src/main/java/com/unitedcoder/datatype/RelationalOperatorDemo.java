package com.unitedcoder.datatype;

public class RelationalOperatorDemo {
    public static void main(String[] args) {
        //relational operator
        int value1=10; int value2=9;  int value3=9;
        System.out.println(value1==value2); //this is for equal comparison
        System.out.println(value1!=value2); //this is for not equal comparison
        System.out.println(value1>value2); //this is for greater than
        System.out.println(value1<value2); //this is for less than
        System.out.println(value2>=value3); //this is for greater than or equal to
        System.out.println(value2<=value3); //this is for less than or equal to
        System.out.println("Selenium"=="selenium");
        //logical AND(&&)  logical OR (||)
        int number1=5; int number2=10;
        boolean result1 = (number1 == 5) && (number2 == 10);
        System.out.println(String.format("result=%b",result1));
        boolean result2=(number1==5)&&(number2==9);
        System.out.println(String.format("result=%b",result2));
        boolean result3=(number1==5)||(number2==9);
        System.out.println(String.format("result=%b",result3));
        //boolean operator    AND(&&)   OR(||)
        boolean b1=true;
        boolean b2=true;
        boolean b3=false;
        boolean b4=false;
        System.out.println(b1&&b2);
        System.out.println(b1&&b3);
        System.out.println(b2||b3);
        System.out.println(b3||b4);
    }
}
