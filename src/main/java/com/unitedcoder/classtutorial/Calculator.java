package com.unitedcoder.classtutorial;

public class Calculator {
  private   String type;
   private String brand;
  private   String factory;

    public static void main(String[] args) {
        Calculator calculator=new Calculator("Scientific Calculator","Texas Instruments","Micro Devices");
        System.out.println(calculator.getBrand());
        System.out.println(calculator.getFactory());
        System.out.println(calculator.getType());
    }

    public Calculator() {
    }

    public Calculator(String type, String brand, String factory) {
        this.type = type;
        this.brand = brand;
        this.factory = factory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }
}
