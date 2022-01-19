package com.unitedcoder.inheritancetutorial;

public class Student {
    private Long studentNumber;
    private String firstName;
    private String lastName;
    private String className;
    private int age;
    private String birthday;
    private String major;
    private String address;
    //default constructor
    public Student() {
    }
    //constructor with all arguments
    public Student(Long studentNumber, String firstName, String lastName, String className, int age, String birthday, String major, String address) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.age = age;
        this.birthday = birthday;
        this.major = major;
        this.address = address;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClassName() {
        return className;
    }

    public int getAge() {
        return age;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMajor() {
        return major;
    }

    public String getAddress() {
        return address;
    }
    @Override
    public String toString()
    {
        return "student number="+studentNumber+"\n"+
                "name="+firstName+" "+lastName+"\n"+
                "class name="+className +"\n"+
                "major="+major+"\n"+
                "age="+age+"\n"+
                "birthday="+birthday+"\n"+
                "address="+address;
    }
}
