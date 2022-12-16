package src.Figurs;

import src.Point.Point;
import src.Line.PoliLine;

public class Rectangle extends Figure implements PoliLineable{
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
    public double sqare() {
        return lenghtA*lenghtB;
    }

    @Override
    public PoliLine newPoliLine() {
        return new PoliLine(point,
                new Point(point.x+lenghtA, point.y),
                new Point(point.x+lenghtA, point.y-lenghtB),
                new Point(point.x, point.y-lenghtB));
    }
}
