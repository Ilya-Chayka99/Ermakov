package src.Figurs;

import src.Point.Point;

public abstract class Figure{
    Point point;

    public Figure(Point point) {
        this.point = point;
    }

    public abstract double sqare();
}
