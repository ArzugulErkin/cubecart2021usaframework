package com.unitedcoder.classtutorial.packageone;

public class Alpha {
    protected String info;

    public Alpha(String info) {
        this.info = info;
    }

    protected String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public static void main(String[] args) {
        Alpha myAlpha=new Alpha("This is alpha class");
        System.out.println(myAlpha.getInfo());
    }

    @Override
    public String toString() {
        return "Alpha{" +
                "info='" + info + '\'' +
                '}';
    }
}
