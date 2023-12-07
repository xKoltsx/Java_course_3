package org.example.lab3;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
