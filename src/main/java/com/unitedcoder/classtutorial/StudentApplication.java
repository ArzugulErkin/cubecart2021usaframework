package com.unitedcoder.classtutorial;

import java.util.ArrayList;
import java.util.List;

public class StudentApplication {
    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        //add student to the list
        Student student1=new Student("Dolkun","Tarim","T","Main Street, Columbia, MD");
        Student student2=new Student("Jackson","Smith","A","New York, NY","Male",
                "123-456-7890", 11,"jackson.smith@gmail.com",100001,"01/10/2020","Computer Science");
        Student student3=new Student("Mike","Fray",null,"1234 Ontario, CA","Male","641-123-4567");
        Student student4=new Student("Phani","PhaniLastName");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        //enhanced for loop to print
        for(Student student:students)
        {
            System.out.println(student);
        }
    }
}
