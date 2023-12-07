package org.example.lab2;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.temp.Shape;

import java.util.Objects;

public class Rectangle {
    private int length;
    private int width;

    @JsonCreator
    public Rectangle(@JsonProperty("length") int length, @JsonProperty("width") int width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle() {
        // Пустой конструктор для Jackson
    }

    public Rectangle(RectangleBuilder rb)
    {
        this.length = rb.length;
        this.width = rb.width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(length, rectangle.length) &&
                Objects.equals(width, rectangle.width);
    }

    @Override
    public int hashCode() { return Objects.hash(length, width); }

    public static  class RectangleBuilder
    {
        private int length;
        private int width;

        public RectangleBuilder setLength(int length) {
            this.length = length;
            return this;
        }

        public RectangleBuilder setWidth(int width) {
            this.width = width;
            return this;
        }
        public Rectangle build() {
            return new Rectangle(this);
        }
    }
}
