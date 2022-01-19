package com.unitedcoder.inheritancetutorial;

import java.util.List;

public class DoctorStudent extends GraduateStudent{
    private String thesisTopic;
    private List<String> publications;

    public DoctorStudent() {
    }
    public DoctorStudent(Long studentNumber, String firstName, String lastName, String className, int age, String birthday, String major, String address, String advisorName,
                         String researchProject, String thesisTopic, List<String> publications) {
        super(studentNumber, firstName, lastName, className, age, birthday, major, address, advisorName, researchProject);
        this.thesisTopic = thesisTopic;
        this.publications = publications;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }
    public List<String> getPublications() {
        return publications;
    }

    @Override
    public String toString() {
        return "DoctorStudent{" +super.toString()+
                "thesisTopic='" + thesisTopic + '\'' +
                ", publications=" + publications +
                '}';
    }
}
