package com.unitedcoder.classtutorial;

public class Pet {
    private String type;
    private boolean male;
    private String name;
    private String color;
    private double age;
    private double weight;
    private double height;
    private String eyeColor;
    private boolean fourLegs;
    private String breed;
    private boolean inHome;
    private String intelligentLevel;
    //generate getter and setter

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public boolean isFourLegs() {
        return fourLegs;
    }

    public void setFourLegs(boolean fourLegs) {
        this.fourLegs = fourLegs;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isInHome() {
        return inHome;
    }

    public void setInHome(boolean inHome) {
        this.inHome = inHome;
    }

    public String getIntelligentLevel() {
        return intelligentLevel;
    }

    public void setIntelligentLevel(String intelligentLevel) {
        this.intelligentLevel = intelligentLevel;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", male=" + male +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", eyeColor='" + eyeColor + '\'' +
                ", fourLegs=" + fourLegs +
                ", breed='" + breed + '\'' +
                ", inHome=" + inHome +
                ", intelligentLevel='" + intelligentLevel + '\'' +
                '}';
    }
}
