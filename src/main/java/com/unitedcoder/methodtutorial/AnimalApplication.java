package com.unitedcoder.methodtutorial;

public class AnimalApplication {
    public static void main(String[] args) {
        Animal animal=new Animal();
        animal.animalSound();
        animal.animalEat("animal food");
        //calling the animalSound method in the Cat object
        Cat cat=new Cat();
        cat.animalSound();
        cat.animalEat("cat food");
        //calling the animaSound method in the Dog object
        Dog dog=new Dog();
        dog.animalSound();
        dog.animalEat("dog food");

    }
}
