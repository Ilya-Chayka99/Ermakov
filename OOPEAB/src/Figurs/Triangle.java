package src.Figurs;

import src.Point.Point;
import src.Line.PoliLine;

import static java.lang.Math.*;

public class Triangle extends Figure implements PoliLineable{
    Point p2;
    Point p3;

    public Triangle(Point p1, Point p2, Point p3) {
        super(p1);
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public double sqare() {
        return (abs((p2.x-point.x)*(p3.y-point.y)-(p3.x-point.x)*(p2.y-point.y))/2d);
    }
    @Override
    public PoliLine newPoliLine() {
        return new PoliLine(point,p2,p3);}
}
