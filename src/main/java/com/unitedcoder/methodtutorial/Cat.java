package com.unitedcoder.methodtutorial;

public class Cat extends Animal{
    //animalSound method overriding

    public void animalSound()
    {
        System.out.println("The cat says: meow meow");
    }
    @Override
    public void animalEat(String foodName)
    {
        System.out.println("The cat eats "+foodName);
    }


}
