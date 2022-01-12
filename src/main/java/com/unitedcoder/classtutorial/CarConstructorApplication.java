package com.unitedcoder.classtutorial;
import java.util.ArrayList;
import java.util.List;

public class CarConstructorApplication {
    public static void main(String[] args) {
        List<Car> cars=new ArrayList<>();
        //define car1
        Car car1=new Car("SUV",2017,40000,"Honda CRV","Honda123456789",50, "Navy Blue","V6","Honda","Sedan",true,"CRV4");
        //define car2
        Car car2=new Car("compact",2020,30000,"Toyota Camery","Toyota123456789", 30000,"Silver","V6","Toyota","compact",false,"Camery");
        //define car 3
        Car car3=new Car("SUV",2021,80000,"Mercedes Benz","Mercedes123456789",15000,"Navy Blue","V8","Mercedes","Sports",true,"GLS");
        //add cars to the list
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        for(Car car: cars)
        {
            System.out.println(car);
        }
    }
}
