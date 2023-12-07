package org.example.lab2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializeToJSON implements Serialize<Rectangle> {
    @Override
    public void writeToFile(List<Rectangle> objs, String fileName) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.writeValue(new File(fileName),objs);
    }

    @Override
    public List<Rectangle> readFromFile(String fileName) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), new TypeReference<List<Rectangle>>(){});
    }
}
