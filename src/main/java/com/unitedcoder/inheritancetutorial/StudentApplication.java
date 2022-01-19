package com.unitedcoder.inheritancetutorial;

import java.util.Arrays;

public class StudentApplication {
    public static void main(String[] args) {
        Student student1=new Student(1001l,"Mike","Smith","SDET",28,
                "1996-01-01","Computer","1234 Main Street, Washington DC");
        GraduateStudent grad1=new GraduateStudent(2002l,"Jake","Joshua","Bio Research 2025",30,"1992-05-01"
        ,"Biology Research","2345 Street, New York","Michael Shaun","Clone Technology");
        System.out.println(student1);
        System.out.println(" ---- below is for the graduate student ---");
        System.out.println(grad1);
        System.out.println("--- below is for a doctor student ---");
        DoctorStudent doctorStudent1=new DoctorStudent(9001l,"Jack","Mike","Computer Science 2028",30,"1992-05-01","CS",
                "6789 Cape Ann, Toronta, CA","David","Blockchain Technology","Blockchain Privacy",
                Arrays.asList("Using password in Blockchain","Privacy enhancement in Blockchain","Hacking in Blockchain"));
        System.out.println(doctorStudent1);
    }
}
