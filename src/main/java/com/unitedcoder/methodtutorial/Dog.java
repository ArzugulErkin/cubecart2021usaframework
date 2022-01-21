package com.unitedcoder.methodtutorial;

public class Dog extends Animal{
    //method override - animalSound

    public void animalSound()
    {
        System.out.println("The dog says: woof woof");
    }
    public void animalEat(String foodName)
    {
        System.out.println("The dog eats "+foodName);
    }

}
