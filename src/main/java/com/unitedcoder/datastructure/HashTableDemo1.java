package com.unitedcoder.datastructure;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashTableDemo1 {
    public static void main(String[] args) {
        Map<String,String> customers=new Hashtable<>();
        //this line below will return null Pointer exception because hashTable does not allow null key
        customers.put(null,null);
        System.out.println(customers.toString());

        Map<String, String> students=new HashMap<>();
        students.put(null,null);
        System.out.println(students.toString());
    }
}
