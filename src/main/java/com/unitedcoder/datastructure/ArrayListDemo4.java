package com.unitedcoder.datastructure;

import java.util.*;

public class ArrayListDemo4 {
    //Loop through items
    public static void main(String[] args) {

        String[] names=new String[]{"Akhtem","Aliya",
                "Amina","Arzigul","Dilmurat","Gulnur","Halide","Manizha",
                "Maryam","Muyesser","Nadire","Patigul","Rifat","Pazilat","Sayyada","Shareffa",
                "Sintia","Tursunay","Zulhumar","Dolkun"};

        ArrayList<String> studentList=new ArrayList<>(Arrays.asList(names));
        studentList.add("Maria");
        studentList.add("Mike");
        studentList.add("Adams");
        //use index to loop items
        //use symbols like \n   \t
        for(int i=0;i<studentList.size();i++)
        {
            System.out.print(studentList.get(i)+"\t");
        }
        System.out.println();
        //print last to first
        for(int j=studentList.size()-1;j>=0;j--)
        {
            System.out.print(studentList.get(j)+"\t");
        }
        System.out.println();
        //use enhanced for loop (for each loop to get items)
        for(String name: studentList)
        {
            System.out.print(name+"\t");
        }
        System.out.println();
        //using Iterator to loop items in the Array List
        //print each name using the Iterator object
        Iterator<String> studentIterator=studentList.iterator();
        while (studentIterator.hasNext())
        {
            System.out.print(studentIterator.next()+"\t");
        }
        System.out.println();
        //print the student list backwards
        ListIterator<String> studentListIterator=studentList.listIterator(studentList.size()); //move the position to last
        while(studentListIterator.hasPrevious())
        {
            System.out.print(studentListIterator.previous()+"\t");
        }
    }
}
