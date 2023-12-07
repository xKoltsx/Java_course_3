package org.example.lab4;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

abstract public class Shape implements Comparable<Shape>
{
    protected final Integer shapeId;
    protected final String shapeName;
    protected String type;

    public Integer getShapeId() {
        return shapeId;
    }

    public String getShapeName() {
        return shapeName;
    }

    public String getType() {
        return type;
    }

    public Shape(ShapeBuilder sb)
    {
        this.shapeId = sb.shapeId;
        this.shapeName = sb.shapeName;
        this.type = "shapeType";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return  Objects.equals(shapeId, shape.shapeId) &&
                Objects.equals(shapeName, shape.shapeName) &&
                Objects.equals(type, shape.type);
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

    static abstract class ShapeBuilder//передає данні в конструктор Shape
    {
        @NotNull
        @Positive(message = "The value must be positive")
        protected Integer shapeId;
        @NotEmpty
        protected String shapeName;
        @NotEmpty
        protected String type;

        public Shape.ShapeBuilder setType(String type)
        {
            this.type = type;
            return this;
        }

        public Shape.ShapeBuilder setShapeId(Integer shapeId) {
            this.shapeId = shapeId;
            return this;
        }

        public Shape.ShapeBuilder setShapeName(String shapeName) {
            this.shapeName = shapeName;
            return this;
        }

        ShapeBuilder(){};

        abstract public Shape build();//абстрактний метод build

    }
}
