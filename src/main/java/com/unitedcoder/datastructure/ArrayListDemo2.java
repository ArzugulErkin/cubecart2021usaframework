package com.unitedcoder.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo2 {
    //add items
    //remove items
    //set items in a specific position
    public static void main(String[] args) {
        System.out.println("Add 4 students to the list");
        List<String> studentList=new ArrayList<>();
        studentList.add("Mike");
        studentList.add("Maria");
        studentList.add("Alex");
        studentList.add("Chris");
        //get the size of the array list
        int totalStudents=studentList.size();
        System.out.println("Total students: "+totalStudents);
        System.out.println(studentList);
        //remove Alex
        System.out.println("Remove one student");
        studentList.remove("Alex");
        System.out.println("Total students: "+studentList.size());
        System.out.println(studentList);
        //add a student to the top of the list
        System.out.println("We add a student to the top of the list");
        studentList.add(0, "Dolkun");
        System.out.println(studentList);
        //replace an item
        System.out.println("Replace one student with a new name");
        studentList.add("Alex");
        System.out.println(studentList);
        studentList.set(4, "Alexander");
        for(String student: studentList)
        {
            System.out.println(student);
        }
        //dynamically replace one item
        int totalCount=studentList.size();
        for(int i=0;i<totalCount;i++)
        {
            if(studentList.get(i)=="Maria") {
                studentList.set(i, "Sintia");
                break;
            }
        }
        System.out.println(studentList);

    }
}
