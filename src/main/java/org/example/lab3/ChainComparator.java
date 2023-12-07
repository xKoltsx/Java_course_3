package org.example.lab3;

import java.util.Comparator;
import java.util.List;

public class ChainComparator implements Comparator<Shape> {
    private List<Comparator<Shape>> comparators;

    public ChainComparator(List<Comparator<Shape>> comparators) {
        this.comparators = comparators;
    }

    @Override
    public int compare(Shape o1, Shape o2) {
        int res;
        for(Comparator<Shape> comparator : comparators) {
            if ((res = comparator.compare(o1, o2)) != 0) {
                return res;
            }
        }
        return 0;
    }
}
