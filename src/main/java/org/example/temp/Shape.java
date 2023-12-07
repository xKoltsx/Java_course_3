package org.example.temp;

import java.util.Objects;

abstract public class Shape implements Comparable<Shape>
{
    protected int shapeId;
    protected String shapeName;
    protected String type;

    public int getShapeId() {
        return shapeId;
    }

    public String getShapeName() {
        return shapeName;
    }

    public String getType() {
        return type;
    }

    private Shape(int shapeId, String shapeName, String type)
    {
        this.shapeId = shapeId;
        this.shapeName = shapeName;
        this.type = type;
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

    static abstract class ShapeBuilder//передає данні в конструктор Shape
    {
        protected int shapeId;
        protected String shapeName;
        protected String type;

        public ShapeBuilder setType(String type)
        {
            this.type = type;
            return this;
        }

        public ShapeBuilder setShapeId(int shapeId) {
            this.shapeId = shapeId;
            return this;
        }

        public ShapeBuilder setShapeName(String shapeName) {
            this.shapeName = shapeName;
            return this;
        }

        ShapeBuilder(){};

        abstract public Shape build();//абстрактний метод build
    }
}
