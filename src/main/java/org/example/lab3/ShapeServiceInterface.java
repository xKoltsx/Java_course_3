package org.example.lab3;

import java.util.List;

public interface ShapeServiceInterface {
    List<Shape> getMyList();
    void setMyList(List<Shape> myList);



    List<Shape> getByShapeId(Integer shapeId);
    List<Shape> getByShapeName(String shapeName);
    List<Shape> getByType(String type);

}