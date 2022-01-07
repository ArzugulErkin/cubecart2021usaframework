package com.unitedcoder.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> students=new LinkedList<>();
        students.add("Mike");
        students.add("Judy");
        students.add("Lucy");
        students.add("James Bond");
        students.add("Brad");
        //printing the linked list
        for(String student: students)
        {
            System.out.print(student+" ");
        }
        //add more student
        students.add(3,"Abdulla");
        System.out.println();
        for(String student: students)
        {
            System.out.print(student+" ");
        }
        //using ListIterator to loop items in the Linked List
        System.out.println();
        ListIterator<String> studentList=students.listIterator();
        while (studentList.hasNext())
        {
            System.out.println(studentList.next());
        }

    }
}
