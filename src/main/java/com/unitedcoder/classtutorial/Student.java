package com.unitedcoder.classtutorial;

public class Student {
    //firstName,lastName,middleInitial, address, gender, phone, grade, email, studentId,birthday,major
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String address;
    private String gender;
    private String phone;
    private int grade;
    private String email;
    private long studentId;
    private String birthday;
    private String major;
    //create constructors
    //default constructor
    public Student() {
    }
    public Student(String firstName, String lastName, String middleInitial, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.address = address;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String firstName, String lastName, String middleInitial, String address,
                   String gender, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public Student(String firstName, String lastName, String middleInitial, String address, String gender,
                   String phone, int grade, String email, long studentId, String birthday, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
        this.grade = grade;
        this.email = email;
        this.studentId = studentId;
        this.birthday = birthday;
        this.major = major;
    }
    //define getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public int getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMajor() {
        return major;
    }
    //toString
    //override means that use my toString method instead of using the Java built-in toString method
   @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", grade=" + grade +
                ", email='" + email + '\'' +
                ", studentId=" + studentId +
                ", birthday='" + birthday + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
