package com.unitedcoder.homework;

import org.apache.commons.lang3.StringUtils;

public class DataTypeConversionQuiz {
    public static void main(String[] args) {
        String abc="1234567";
        System.out.println(StringUtils.isNumeric(abc));
        Long l1=Long.parseLong(abc);
        System.out.println(l1);
        System.out.println(Math.sqrt(16));
        int x=123;
        System.out.println(Integer.parseInt(""+x)==x);
    }
}
