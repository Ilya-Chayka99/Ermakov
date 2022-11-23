package src.Figurs;

import src.Point.Point;

abstract class Figure {
    Point point;

    public Figure(Point point) {
        this.point = point;
    }

    abstract double sqare();
}
