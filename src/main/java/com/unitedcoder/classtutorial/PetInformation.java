package com.unitedcoder.classtutorial;

public class PetInformation {
    public static void main(String[] args) {
        Pet[] pets=new Pet[2];
        pets[0]=new Pet(); //instance of Pet
        pets[1]=new Pet(); //instance of Pet
        pets[0].setType("Cat");
        pets[0].setBreed("American Short Hair");
        pets[0].setColor("Brown");
        pets[0].setEyeColor("Brown");
        pets[0].setHeight(20);
        pets[0].setMale(true);
        pets[0].setName("Pillow");

        pets[1].setType("Cat");
        pets[1].setBreed("Scottish");
        pets[1].setColor("Grey");
        pets[1].setEyeColor("Blue");
        pets[1].setHeight(18);
        pets[1].setMale(false);
        pets[1].setName("Willow");
        for(Pet pet: pets)
        {
            System.out.println(pet);
        }

    }
}
