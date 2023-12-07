package lab1;

import org.example.lab1.Circle;
import org.example.lab1.Rectangle;
import org.example.lab1.Shape;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.Assert.assertEquals;
public class lab1Test
{
    @Test(dataProvider = "equalShape")
    public void equalShapeTest(Shape obj1, Shape obj2, boolean res)
    {
        assertEquals(Objects.equals(obj1,obj2),res);
    }
    @DataProvider
    public Object[][] equalShape()
    {

        Rectangle r1 = new Rectangle.RectangleBuilder().setLength(10).setWidth(20).build();
        Rectangle r2 = new Rectangle.RectangleBuilder().setLength(10).setWidth(25).build();
        Circle c1 = new Circle.CircleBuilder().setRadius(15).build();
        Circle c2 = new Circle.CircleBuilder().setRadius(20).build();



        return new Object[][]{{r1,r1,true},{r1,r2,false},{c1,c1,true},{c1,c2,false}};
    }

    @Test(dataProvider = "hashEqualShapes")
    public void hashEqualShapesTest(Shape obj1,Shape obj2)
    {
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }
    @DataProvider
    public Object[][] hashEqualShapes()
    {
        Rectangle.RectangleBuilder rb1 = new Rectangle.RectangleBuilder();
        rb1.setShapeId(1);
        rb1.setShapeName("Rectangle");
        rb1.setLength(10);
        rb1.setWidth(20);
        Circle.CircleBuilder cb = new Circle.CircleBuilder();
        cb.setShapeId(2);
        cb.setShapeName("Circle");
        cb.setRadius(10);
        Shape r1 = rb1.build();
        Shape c1 = cb.build();
        return new Object[][]{{r1,r1},{c1,c1}};
    }
}

