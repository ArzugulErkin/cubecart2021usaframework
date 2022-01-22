package com.unitedcoder.classtutorial;

import java.util.ArrayList;
import java.util.List;

public class CarApplication {
    public static void main(String[] args) {
        List<Car> cars=new ArrayList<>();
        //define car1
        Car car1=new Car();   car1.setType("SUV"); car1.setBrand("Honda CRV");
        car1.setMake("Honda"); car1.setPrice(40000); car1.setModel("CRV4");
        car1.setColor("Navy Blue"); car1.setEngine("V6");car1.setVin("Honda123456789");
        car1.setYear(2022); car1.setMileAge(50); car1.setNew(true);
        car1.setBodyType("Sedan");
        //define car2
        Car car2=new Car();
        car2.setType("compact"); car2.setBrand("Toyota Camery");
        car2.setMake("Toyota"); car2.setPrice(30000); car2.setModel("Camery");
        car2.setColor("Silver"); car2.setEngine("V6");car2.setVin("Toyota123456789");
        car2.setYear(2020); car2.setMileAge(30000); car2.setNew(false);
        car2.setBodyType("Compact");
        //define car 3
        Car car3=new Car();
        car3.setBrand("Mercedes Benz"); car3.setType("SUV");
        car3.setPrice(80000); car3.setModel("GLS"); car3.setMake("Mercedes");
        car3.setColor("Navy Blue");car3.setEngine("V8"); car3.setVin("Mercedes123456789");
        car3.setYear(2021); car3.setMileAge(15000);car3.setNew(true); car3.setBodyType("Sports");
        //add cars to the list
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        for(Car car: cars)
        {
            System.out.println(car);
        }
        //I want to print only the car make and price
        for(Car car: cars)
        {
            System.out.println(car.getBrand());
            System.out.println(car.getType());
            System.out.println(car.getPrice());
            System.out.println(car.getModel());
            System.out.println(car.getMake());
            System.out.println(car.getColor());
            System.out.println(car.getEngine());
            System.out.println(car.getVin());
            System.out.println(car.getYear());
            System.out.println(car.getMileAge());
            System.out.println(car.isNew());
            System.out.println(car.getBodyType());
        }

    }
}
