package org.example.lab3;

import java.util.List;

public interface ShapeServiceInterface {
    List<Shape> getShape();
    void setShape(List<Shape> myList);



    List<Shape> getShapeByShapeId(Integer shapeId);
    List<Shape> getShapeByShapeName(String shapeName);
    List<Shape> getShapeByType(String type);

    List<Shape> sortByName();

}