package com.unitedcoder.datatype;

public class InstanceOfDemo {
    public static void main(String[] args) {
        Integer i1=100;
        System.out.println(i1 instanceof Integer);

        Number myNumber=1234567890;
        System.out.println(myNumber instanceof Number);

        Object object="selenium";
        System.out.println(object instanceof String); //compare if the object instance type is String
        if(object instanceof String)
        {
            System.out.println(((String) object).substring(1,4));
        }
    }
}
