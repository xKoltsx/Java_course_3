package org.example.lab3;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShapeServiceWithStream implements ShapeServiceInterface {
    public List<Shape> list;

    public ShapeServiceWithStream(List<Shape> list) {
        this.list = list;
    }

    public List<Shape> getList() {
        return list;
    }

    public void setList(List<Shape> list) {
        this.list = list;
    }

    public List<Shape> getRectangles()
    {
        return getList().stream().filter(shape -> "rectangle".equals(shape.getType())).collect(Collectors.toList());
    }
    public List<Shape> getCircles()
    {
        return getList().stream().filter(shape -> "circle".equals(shape.getType())).collect(Collectors.toList());
    }
    public List<Shape> getShapeByName(String name)
    {
        return getList().stream().filter(shape -> name.equals(shape.getShapeName())).collect(Collectors.toList());
    }

    @Override
    public List<Shape> getShape() {
        return list;
    }
    @Override
    public void setShape(List<Shape> list) {this.list = list;}

    @Override
    public List<Shape> getShapeByShapeId(Integer shapeId)
    {
        return getShape().stream().filter(getShapeId(shapeId)).collect(Collectors.toList());
    }

    @Override
    public List<Shape> getShapeByShapeName(String shapeName)
    {
        return getShape().stream().filter(getShapeName(shapeName)).collect(Collectors.toList());
    }

    @Override
    public List<Shape> getShapeByType(String shapeType)
    {
        return getShape().stream().filter(getShapeType(shapeType)).collect(Collectors.toList());
    }

    @Override
    public List<Shape> sortByName() {
        return getShape().stream()
                .sorted(Comparator.comparing(Shape::getShapeName))
                .collect(Collectors.toList());
    }

    private Predicate<Shape> getShapeId (Integer shapeId)
    {
        return shape -> shapeId.equals(shape.getShapeId());
    }

    private Predicate<Shape> getShapeName (String shapeName)
    {
        return shape -> shapeName.equals(shape.getShapeName());
    }

    private Predicate<Shape> getShapeType (String shapeType)
    {
        return person -> shapeType.equals(person.getType());
    }
}
