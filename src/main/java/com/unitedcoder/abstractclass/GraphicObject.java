package com.unitedcoder.abstractclass;

//use the keyword abstract to define an abstract class

public abstract class GraphicObject {
    int x;
    int y;
    //define a method with implementation
    void moveTo(int newX,int newY)  //none abstract method
    {
        System.out.println(String.format("This object is moved to location %d %d",newX,newY));
    }
    //define abstract methods
     void printInfo(String graphicObjectName)
     {
         System.out.println("This is a "+graphicObjectName);
     }

    abstract void resize();  //no implementation
    abstract void draw(int r); //no implementation
}
