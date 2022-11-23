package src.Figurs;
import src.Point.Point;

import static java.lang.Math.*;
public class Circle extends Figure{
    double r;

    public Circle(Point p, double r) {
        super(p);
        this.r = r;
    }

    @Override
    double sqare() {
        return PI*r*r;
    }
}
