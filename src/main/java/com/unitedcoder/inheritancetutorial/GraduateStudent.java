package com.unitedcoder.inheritancetutorial;

public class GraduateStudent extends Student{
    private String advisorName;
    private String researchProject;

    public GraduateStudent() {
    }

    public GraduateStudent(Long studentNumber, String firstName, String lastName, String className, int age, String birthday, String major,
                           String address, String advisorName, String researchProject) {
        super(studentNumber, firstName, lastName, className, age, birthday, major, address);
        this.advisorName = advisorName;
        this.researchProject = researchProject;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public String getResearchProject() {
        return researchProject;
    }

    @Override
    public String toString() {
        return "GraduateStudent{" +super.toString()+
                "advisorName='" + advisorName + '\'' +
                ", researchProject='" + researchProject + '\'' +
                '}';
    }
}
