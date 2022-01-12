package com.unitedcoder.classtutorial;

public class Car {
    //make the class variables private and methods are public
    //generate getter and setter to access the fields
    //convert the object to a String object to get the information
    private String type;
    private int year;
    private double price;
    private String brand;
    private String vin;
    private int mileAge;
    private String color;
    private String engine;
    private String make;
    private String bodyType;
    private boolean isNew;
    private String model;
    //default constructor
    public Car() {
    }

    public Car(String type, int year, double price, String brand, String vin, int mileAge, String color,
               String engine, String make, String bodyType, boolean isNew, String model) {
        this.type = type;
        this.year = year;
        this.price = price;
        this.brand = brand;
        this.vin = vin;
        this.mileAge = mileAge;
        this.color = color;
        this.engine = engine;
        this.make = make;
        this.bodyType = bodyType;
        this.isNew = isNew;
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getMileAge() {
        return mileAge;
    }

    public void setMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public  boolean getNew()
    {
        return isNew;
    }
    //convert the object to String object


    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", vin='" + vin + '\'' +
                ", mileAge=" + mileAge +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", make='" + make + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", isNew=" + isNew +
                ", model='" + model + '\'' +
                '}';
    }
}
