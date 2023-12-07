package org.example.lab3;

import java.util.List;
import java.util.stream.Collectors;

public class ShapeServiceWithStream {
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
}
