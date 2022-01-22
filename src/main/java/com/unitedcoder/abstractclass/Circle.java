package com.unitedcoder.abstractclass;

public class Circle extends GraphicObject{
    public static void main(String[] args) {
      Circle circle=new Circle();
      circle.printInfo("circle");
      circle.x=10;
      circle.y=50;
      circle.draw(5);
      circle.moveTo(100,300);
      circle.resize();
    }
    @Override
    void resize() {
        System.out.println("I resized the circle");
    }
    @Override
    void draw(int r) {
        System.out.println("I draw the cicle with the radius "+r);
    }
}
