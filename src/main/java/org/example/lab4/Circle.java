package org.example.lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

public class Circle extends Shape
{
    private final int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(CircleBuilder cb)
    {
        super(cb);//передає білдер в батьківський клас
        this.radius = cb.radius;
        this.type = "circle";
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", shapeId=" + shapeId +
                ", shapeName='" + shapeName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    @Override
    public int compareTo(Shape o) {
        return this.getShapeName().compareTo(o.getShapeName());
    }

    final static public class CircleBuilder extends Shape.ShapeBuilder
    {
        @NotNull
        private int radius;

        public Circle.CircleBuilder setRadius(int radius) {
            this.radius = radius;
            return this;
        }

        public Circle build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Circle.CircleBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for (ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if (constraintViolations.size() > 0) throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Circle(this);
        }
    }
}
