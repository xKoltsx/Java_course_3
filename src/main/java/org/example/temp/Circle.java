package org.example.temp;

import java.util.Objects;

public class Circle extends Shape
{
    private int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(CircleBuilder cb)
    {
        super(cb);//передає білдер в батьківський клас
        this.radius = cb.radius;
        this.type = "circle";
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", shapeId=" + shapeId +
                ", shapeName='" + shapeName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    @Override
    public int compareTo(Shape o) {
        return this.getShapeName().compareTo(o.getShapeName());
    }

     public static class CircleBuilder extends ShapeBuilder
    {
        private int radius;

        public CircleBuilder setRadius(int radius) {
            this.radius = radius;
            return this;
        }
        public Shape build(){return new Circle(this);}
    }
}
