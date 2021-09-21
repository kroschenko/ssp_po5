package main3.task1;

import java.util.Objects;


public class Triangle {

    private final double a;

    private final double b;

    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {
        var semiPerimeter = perimeter() / 2;
        return Math.pow(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c), 0.5);
    }

    public double perimeter() {
        return a + b + c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.a, a) == 0 && Double.compare(triangle.b, b) == 0 && Double.compare(triangle.c, c) == 0;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public boolean isExist() {
        return a + b < c && b + c < a && a + c < b;
    }
}
