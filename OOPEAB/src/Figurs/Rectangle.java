package src.Figurs;

import src.Point.Point;

public class Rectangle extends Figure{
    int lenghtA;
    int lenghtB;

    public Rectangle(Point point, int lenghtA, int lenghtB) {
        super(point);
        this.lenghtA = lenghtA;
        this.lenghtB = lenghtB;
    }
    public boolean isSquare(){
        return lenghtA==lenghtB;
    }
    @Override
    double sqare() {
        return lenghtA*lenghtB;
    }
}
