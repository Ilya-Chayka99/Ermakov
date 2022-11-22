package src.Figurs;
import src.Point.Point;

import static java.lang.Math.*;
public class Circle extends Figure{
    Point p;
    double r;

    public Circle(Point p, double r) {
        this.p = p;
        this.r = r;
    }

    @Override
    double sqare() {
        return 2*PI*r;
    }
}
