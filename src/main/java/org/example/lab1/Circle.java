package org.example.lab1;
import java.util.Objects;

/**
 * The type Circle.
 */
public class Circle extends Shape
{
    private final int radius;

    /**
     * Gets radius.
     *
     * @return the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Instantiates a new Circle.
     *
     * @param cb the cb
     */
    public Circle(CircleBuilder cb)
    {
        super(cb);
        this.radius = cb.radius;
    }
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", shapeId=" + shapeId +
                ", shapeName='" + shapeName + '\'' +
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

    /**
     * The type Circle builder.
     */
    final static public class CircleBuilder extends ShapeBuilder
    {
        private int radius;

        /**
         * Sets radius.
         *
         * @param radius the radius
         * @return the radius
         */
        public CircleBuilder setRadius(int radius) {
            this.radius = radius;
            return this;
        }
        public Circle build(){return new Circle(this);}
    }
}
