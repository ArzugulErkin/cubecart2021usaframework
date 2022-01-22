package com.unitedcoder.abstractclass;

public class Rectangle extends GraphicObject{
    @Override
    void resize() {
        System.out.println("I resized the rectangle");
    }

    @Override
    void draw(int r) {
        System.out.println("I draw a rectangle");
    }

    public static void main(String[] args) {
        Rectangle rectangle=new Rectangle();
        rectangle.printInfo("rectangle");
        rectangle.x=30;
        rectangle.y=50;
        rectangle.moveTo(rectangle.x+10, rectangle.y+10);
        rectangle.resize();
    }
}
