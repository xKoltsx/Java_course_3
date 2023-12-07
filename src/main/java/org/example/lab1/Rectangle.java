package org.example.lab1;
import java.util.Objects;

public class Rectangle extends Shape{
    private final int length;
    private final int width;

   private Rectangle(RectangleBuilder rb)
    {
        super(rb);
        this.length = rb.length;
        this.width = rb.width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", shapeId=" + shapeId +
                ", shapeName='" + shapeName + '\'' +
                '}';
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return length == rectangle.length && width == rectangle.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length, width);
    }

    final static public class RectangleBuilder extends ShapeBuilder
    {
        private int length;
        private int width;

        public RectangleBuilder setLength(int length) {
            this.length = length;
            return this;
        }

        public RectangleBuilder setWidth(int width) {
            this.width = width;
            return this;
        }
        public Rectangle build() {
            return new Rectangle(this);
        }
    }
}
