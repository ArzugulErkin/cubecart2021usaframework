package com.unitedcoder.datatype;

import java.util.Locale;

public class StringDemo2 {
    public static void main(String[] args) {
        String city="Columbia";
        String state="Maryland";
        String zipCode="21046";
        //+ is for joining strings together , or concatenate strings
        //print the city, state in upper case
        System.out.println(city.toUpperCase());
        System.out.println(state.toUpperCase());
        //print the city and state in lower case
        System.out.println(city.toLowerCase());
        System.out.println(state.toLowerCase());
        //get the length of the String
        String s1="United Coder";
        System.out.println(s1.length());
        String s2="Selenium Master";
        System.out.println(s2.substring(0,8));
        //join strings - concatenate strings
        // use + symbol to join strings, concat method
        System.out.println(city+" " +state);
        String a1="SDET";
        String a2="Students";
        System.out.println(a1.concat(" ").concat(a2).concat(" are learning Java"));
        //your creativity is your limit
        //search a string
        String s3="Java Test Automation Framework Designing";
        System.out.println(s3.indexOf("T")); //if value is greater than 0, found the search item
        System.out.println(s3.indexOf("t")); //if value is greater than 0, found the search item
        System.out.println(s3.indexOf("z")); //if the value is less than 0, not found
        //contains
        System.out.println(s3.contains("Java")); //return logic true
        System.out.println(s3.contains("java"));


    }
}
