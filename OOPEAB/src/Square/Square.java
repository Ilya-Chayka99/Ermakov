package src.Square;

import src.Point.Point;
import src.PoliLine.PoliLine;

public class Square {
    private Point point;
    private int length;

    public Square(Point point, int length) throws Exception {
        this.setL(length);
        this.point = point;
    }
    public Square(int x, int y,int length) throws Exception {
        this(new Point(x,y),length);
    }
    public PoliLine newPoliLine()
    {
        return new PoliLine(point,
                new Point(point.x+length, point.y),
                new Point(point.x+length, point.y-length),
                new Point(point.x, point.y-length),point);

    }

    public void setPoint(Point point) {
        this.point = point;
    }
    private void setL(int length) throws Exception {
        if(length<=0) throw new Exception("Длинна стороны не может быть отрицательной и равной нулю");
        this.length=length;
    }
    public void setLength(int length) throws Exception {
        this.setL(length);
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Квадрат в точке " + point + " со стороной " + length;
    }
}
