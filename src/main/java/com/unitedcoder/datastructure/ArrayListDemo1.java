package com.unitedcoder.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo1 {
    //We have 10 students; let's write a java code to
    // get the average grade of the 10 students
    public static void main(String[] args) {
        //define a list
        List<Integer> studentGrades=new ArrayList<>();  //define an arrayList
        studentGrades.add(95);  //use add method to add items to the list
        studentGrades.add(92);
        studentGrades.add(85);
        studentGrades.add(90);
        studentGrades.add(87);
        studentGrades.add(98);
        studentGrades.add(75);
        studentGrades.add(94);
        studentGrades.add(79);
        studentGrades.add(100);
        System.out.println(studentGrades);
        //get the total count of an array list
        int totalStudents=studentGrades.size(); //use the size method to get the count of all items in the list
        int sum=0;
        for(int grade:studentGrades)    //how to loop through items in the list
        {
            sum=sum+grade;
        }
        double average=(double) sum/totalStudents;
        System.out.println(String.format("average grade is %.2f",average));
    }
}
