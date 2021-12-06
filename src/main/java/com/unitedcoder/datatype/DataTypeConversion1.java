package com.unitedcoder.datatype;

public class DataTypeConversion1 {
    public static void main(String[] args)
    {
        //widening casting
       // byte ->short ->int ->long ->float ->double  (implicit conversion)
        int x1=100;
        long l1= x1;  //basically, system automatically conver the int to long
        System.out.println(String.format("x1=%d",x1));
        System.out.println(String.format("l1=%d",l1));
        double d1=l1;
        float f1=l1;
        System.out.println(String.format("d1=%.2f",d1));
        System.out.printf("f1=%.2f",f1);    //System.out.printf = System.out.print(String.format())
        System.out.println();  //
        //How do we round up to nearest 2 decimals
        double a = 3.445678;
        int rounded_a = (int)Math.round(a);
        System.out.println("a="+rounded_a );
        //Narrowing casting
        //double -> float -> long -> int ->short -> byte  (Explicit casting)
        long l2=20961;
        int i2= (int) l2;  //type casting is required, convert long to int type
        System.out.println(String.format("l2=%d",l2));
        System.out.println(String.format("i2=%d",i2));
        short s2= (short) i2;
        double d2=100.05;
        float f2= (float) d2;
        System.out.printf("s2=%d \n",s2);
        System.out.printf("f2=%.2f",f2);
    }
}
