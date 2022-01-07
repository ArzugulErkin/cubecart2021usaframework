package com.unitedcoder.datastructure;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo1 {
    //use collections to find min and max numbers
    public static void main(String[] args) {
        int[] numbers=new int[]{3,2,5,6,3,6,10,20,1,25,30,50,60,43,55,89};
        //add numbers to the set
        Set<Integer> set1=new TreeSet<>();
        for(int i=0;i<numbers.length;i++)
        {
            set1.add(numbers[i]);
        }
        System.out.println("Min value is : "+ Collections.min(set1));
        System.out.println("Max value is : "+Collections.max(set1));
        //use collection to sort String
        String[] students=new String[]{"Mike","Jason","Bob","Emily","Adam","Wilson"};
        Set<String> studentSet=new TreeSet<>();
        for(String student: students)
        {
            studentSet.add(student);
        }
        System.out.println("Min alphabet name is "+Collections.min(studentSet,String.CASE_INSENSITIVE_ORDER));
        System.out.println("Max alphabet name is "+Collections.max(studentSet,String.CASE_INSENSITIVE_ORDER));

    }
}
