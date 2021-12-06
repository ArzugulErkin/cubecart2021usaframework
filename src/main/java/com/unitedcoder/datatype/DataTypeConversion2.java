package com.unitedcoder.datatype;

import org.apache.commons.lang3.StringUtils;

public class DataTypeConversion2 {
    public static void main(String[] args) {
        //convert numeric String to number data type
        String confirmationNumber="1234567890S";
        System.out.println(StringUtils.isNumeric(confirmationNumber));
        confirmationNumber=confirmationNumber.replace("S","");
        System.out.println(confirmationNumber);
        int n=Integer.parseInt(confirmationNumber); //convert numeric string to int
        System.out.println(1+n);

        double d3=Double.parseDouble(confirmationNumber); //convert numeric string to double
        float f3=Float.parseFloat(confirmationNumber);  //convert numeric string to float
        long l3=Long.parseLong(confirmationNumber);    //convert numeric string to long
        System.out.println(String.format("d3=%.0f",d3));
        System.out.println(String.format("f3=%.0f",f3));
        System.out.println(String.format("l3=%d",l3));

        //use value of for the conversion
        float f4=Float.valueOf(confirmationNumber) ; //using valueOf for converting the string to a float type
        String result="true";
        boolean b1=Boolean.valueOf(result);
        System.out.println("f4="+f4);
        System.out.println(b1);
        //convert number to String
        int x3=985;
        float f5=(float)450.55;
        String myStringx3=String.valueOf(x3);
        String myStringf5=String.valueOf(f5);
        System.out.println(x3+f5);
        String space=" ";
        System.out.println(myStringx3+space+myStringf5); //concatenate the string


    }
}
