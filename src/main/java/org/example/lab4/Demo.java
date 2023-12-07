package org.example.lab4;


public class Demo {
    public static void main(String[] args) {
        Rectangle.RectangleBuilder ob1 = new Rectangle.RectangleBuilder();

        Circle ob2 = (Circle) new Circle.CircleBuilder().setRadius(24).setShapeId(1).setShapeName("Senko").setType("Nigga").build();

        ob1.setLength(30);
        ob1.setWidth(30);
        ob1.setShapeId(2);
        ob1.setShapeName("Lolo");
        ob1.setType("sad");
        System.out.println(ob1.build());
        System.out.println(ob2);
    }
}