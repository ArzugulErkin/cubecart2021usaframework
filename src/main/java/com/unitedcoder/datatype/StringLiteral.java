package com.unitedcoder.datatype;

public class StringLiteral {
    public static void main(String[] args) {
        //define string variables
        String s1="abc";
        String s2="abc";
        System.out.println(s1==s2);
        //define String objects
        String a=new String("abc"); //define a new String object instance
        String b=new String("abc"); //define a new String object instance
        System.out.println(a==b);
    }
}
