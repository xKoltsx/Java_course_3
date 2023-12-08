package org.example.lab3;

import org.example.lab3.Shape;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeServiceWithoutStream implements ShapeServiceInterface {
    private List<Shape> myList;

    public ShapeServiceWithoutStream(List<Shape> myList) {
        this.myList = myList;
    }

    public List<Shape> getShape() {
        return myList;
    }

    public void setShape(List<Shape> myList) {
        this.myList = myList;
    }

    @Override
    public String toString() {
        return "ShapeServiceWithoutStream{" +
                "myList=" + myList +
                '}';
    }

    public List<Shape> getShapeByShapeId(Integer shapeId) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : myList) {
            if (shapeId.equals(shape.getShapeId())) {
                result.add(shape);
            }
        }
        return result;
    }

    public List<Shape> getShapeByShapeName(String shapeName) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : myList) {
            if (shapeName.equals(shape.getShapeName())) {
                result.add(shape);
            }
        }
        return result;
    }

    public List<Shape> getShapeByType(String type) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : myList) {
            if (type.equals(shape.getType())) {
                result.add(shape);
            }
        }
        return result;
    }
    @Override
    public List<Shape> sortByName() {
        List<Shape> shapes = getShape();
        shapes.sort(Comparator.comparing(Shape::getShapeName));
        return shapes;
    }



}
