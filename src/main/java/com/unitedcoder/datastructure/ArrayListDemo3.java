package com.unitedcoder.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo3 {
    //search an item in a list
    //sub list
    public static void main(String[] args) {

        String[] names=new String[]{"Akhtem","Aliya",
                "Amina","Arzigul","Dilmurat","Gulnur","Halide","Manizha",
                "Maryam","Muyesser","Nadire","Patigul","Rifat","Pazilat","Sayyada","Shareffa",
                "Sintia","Tursunay","Zulhumar","Dolkun"};

        ArrayList<String> studentList=new ArrayList<>(Arrays.asList(names));
        studentList.add("Maria");
        System.out.println(studentList); //initial list print
        int totalStudents=studentList.size();
        System.out.println(String.format("Total students: %d",totalStudents));
        //how to get an index of an item dynamically
        for(String name: studentList)
        {
            if(name.equalsIgnoreCase("Rifat"))
            {
                int position=studentList.indexOf(name);
                System.out.println("Rifat index: "+position);
                studentList.set(position,"Tarim");
            }
        }
        System.out.println(studentList); //print after replacement
      //split the list
        List<String> list1=studentList.subList(0,10);
        List<String> list2=studentList.subList(10,studentList.size()-1);
        System.out.println(list1);
        System.out.println(list2);

    }
}
