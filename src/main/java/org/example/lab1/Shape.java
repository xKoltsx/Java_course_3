package org.example.lab1;
import java.util.Objects;

abstract public class Shape
{
    protected final int shapeId;
    protected final String shapeName;

    public int getShapeId() {
        return shapeId;
    }

    public String getShapeName() {
        return shapeName;
    }

    public Shape(ShapeBuilder sb)
    {
        this.shapeId = sb.shapeId;
        this.shapeName = sb.shapeName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return shapeId == shape.shapeId && Objects.equals(shapeName, shape.shapeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapeId, shapeName);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "shapeId=" + shapeId +
                ", shapeName='" + shapeName + '\'' +
                '}';
    }

    static abstract class ShapeBuilder
    {
        protected int shapeId;
        protected String shapeName;

        public ShapeBuilder setShapeId(int shapeId) {
            this.shapeId = shapeId;
            return this;
        }

        public ShapeBuilder setShapeName(String shapeName) {
            this.shapeName = shapeName;
            return this;
        }

        ShapeBuilder(){};

        abstract public Shape build();
    }
}
