package com.unitedcoder.classtutorial.packageone;

public class Beta {
    private String version;

    public Beta() {
    }
    public Beta(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public static void main(String[] args) {
        Alpha alpha1=new Alpha("This is public alpha class");
        System.out.println(alpha1.getInfo());
        DummyClass dummyClass=new DummyClass("This is a dummy class that has no modifier for get and set methods");
        System.out.println(dummyClass.getInfo());
    }
    @Override
    public String toString() {
        return "Beta{" +
                "version='" + version + '\'' +
                '}';
    }
}
