package com.unitedcoder.datatype;

public class DataTypeDemo1 {
    public static void main(String[] args)
    {
        //byte short int long double float boolean char
        byte a=127;
        byte b=120;
        byte c=(byte) (a&b);  //& is AND operation
        System.out.println(c);
        //for AND operation, the both numbers should be true
        System.out.println("This is AND operation for byte "+c);
        //for OR operation, if any number is true, the result is true
        byte d=(byte)(a|b);     // | is OR operation
        System.out.println("This is OR operation for byte "+d);

        //short data type and operation  +, -, *, /, %
        short s1=3500;
        short s2=6000;
        short s3= (short) (s1+s2);
        System.out.println(String.format("%d + %d = %d",s1,s2,s3));
        System.out.println(String.format("%d - %d = %d",s2,s1,s2-s1));
        // %s for String   %f for float
        //int data type
        int i1=10000000;
        int i2=20000000;
        System.out.println(String.format("%d + %d = %d",i1,i2,i1+i2));
        System.out.println(String.format("%d -%d = %d",i1,i2,i1-i2));
        System.out.println(String.format("%d / %d = %d",i1,i2,i1/i2)); //this returns 0
        System.out.println(String.format("%d / %d = %f",i1,i2,(float)i1/i2)); //this returns 0.5
        //long data type
        long x=12345678901234567L;  //you need to add L after the number if the number exceeds the integer range
        long y=98765432101234567L;
        long z=x+y;
        System.out.println(String.format("%d + %d = %d",x,y,z));
        System.out.println(String.format("%d / %d = %.3f",x,y,(float)x/y));

        //float  +, -, *, /
        float f1=3.1415f;
        float f2=2.546789f;
        float f3=f1+f2;
        System.out.println(String.format("%.4f+%f=%f",f1,f2,f3));
        System.out.println(String.format("%.4f / %f = %f",f1,f2,f1/f2));

        //double data type
        double d1=100.09;
        double d2=2000.10;
        double d3=d1+d2;
        double d4=d1/d2;
        double d5=d1*d2;
        System.out.println(String.format("%.2f + %.2f=%.2f ",d1,d2,d3));
        System.out.println(String.format("%.2f / %.2f=%.2f ",d1,d2,d4));
        System.out.println(String.format("%.2f * %.2f=%.2f ",d1,d2,d5));

        //boolean data type - true -1      false - 0
        // AND (&)     OR (|)
        boolean b1=true;
        boolean b2=false;
        boolean b3=true;
        // AND (&&) when both conditions are true, the result is true
        // OR (||) when any condition is true, the result is true
        System.out.println(String.format("%b && %b = %b", b1, b2, b1&&b2));
        System.out.println(String.format("%b || %b = %b", b2, b3, b2||b3));
        System.out.println(String.format("%b && %b = %b", b1, b3, b1&b3));
        //char data type
        char searchLetter='k';
        String myName="Dolkun";
        System.out.println(myName.charAt(3)==searchLetter);
    }
}
