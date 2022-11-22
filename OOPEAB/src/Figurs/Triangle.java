package src.Figurs;

import src.Point.Point;

import static java.lang.Math.*;

public class Triangle extends Figure{
    Point p1;
    Point p2;
    Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    double sqare() {
        return (abs((p2.x-p1.x)*(p3.y-p1.y)-(p3.x-p1.x)*(p2.y-p1.y))/2d);
    }
}
