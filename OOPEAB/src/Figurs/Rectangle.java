package src.Figurs;

import src.Point.Point;

public class Rectangle extends Figure{
    Point point;
    int lenghtA;
    int lenghtB;

    public Rectangle(Point point, int lenghtA, int lenghtB) {
        this.point = point;
        this.lenghtA = lenghtA;
        this.lenghtB = lenghtB;
    }

    @Override
    double sqare() {
        return lenghtA*lenghtB;
    }
}
