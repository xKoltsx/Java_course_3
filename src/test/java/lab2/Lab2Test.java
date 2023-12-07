package lab2;

import org.example.lab2.*;
import org.example.lab2.Serialize;
import org.example.lab2.SerializeToJSON;
import org.example.lab2.SerializeToTxt;
import org.example.lab2.SerializeToXml;
import org.example.temp.Shape;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Lab2Test {

    @Test(dataProvider = "serializeToJSONTest")
    public void serializeProviderTest(String fileName, Serialize<Rectangle> serializer, List<Rectangle> objs) throws IOException, ClassNotFoundException {
        serializer.writeToFile(objs, fileName);
        List<Rectangle> res = serializer.readFromFile(fileName);
        assertEquals(res, objs);
    }


    @DataProvider
    public Object[][] serializeToJSONTest() {
        List<Rectangle> list = Arrays.asList
                (

                        new Rectangle.RectangleBuilder().setWidth(22).setLength(33).build(),
                        new Rectangle.RectangleBuilder().setWidth(45).setLength(55).build()
                );
        return new Object[][]
                {
                        {"test123.json", new SerializeToJSON(), list},
                        {"test1234.xml", new SerializeToXml(), list},
                        {"test1235.txt", new SerializeToTxt(), list}
                };
    }
}
