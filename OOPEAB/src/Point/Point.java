package src.Point;

import src.Fraction.Fraction;

import java.util.Objects;

public class Point implements Cloneable {
    public double x,y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{"+x+":"+y+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public Point clone()  {
        try {
            return (Point) super.clone();
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
