package org.example.lab3;

import org.example.lab3.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeServiceWithoutStream implements ShapeServiceInterface {
    private List<Shape> myList;

    public ShapeServiceWithoutStream(List<Shape> myList) {
        this.myList = myList;
    }

    public List<Shape> getMyList() {
        return myList;
    }

    public void setMyList(List<Shape> myList) {
        this.myList = myList;
    }

    @Override
    public String toString() {
        return "ShapeServiceWithoutStream{" +
                "myList=" + myList +
                '}';
    }

    public List<Shape> getByShapeId(Integer shapeId) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : myList) {
            if (shapeId.equals(shape.getShapeId())) {
                result.add(shape);
            }
        }
        return result;
    }

    public List<Shape> getByShapeName(String shapeName) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : myList) {
            if (shapeName.equals(shape.getShapeName())) {
                result.add(shape);
            }
        }
        return result;
    }

    public List<Shape> getByType(String type) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : myList) {
            if (type.equals(shape.getType())) {
                result.add(shape);
            }
        }
        return result;
    }

}
