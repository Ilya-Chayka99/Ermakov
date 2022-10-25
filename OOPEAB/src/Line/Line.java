package src.Line;

import src.Point.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Line {
    private Point point1,point2;

    public Line(Point point1, Point point2) {
        this(point1.x,point1.y,point2.x,point2.y);
    }

    public Line(double x1,double y1,double x2, double y2) {
        this.point1 = new Point(x1,y1);
        this.point2 = new Point(x2,y2);

    }
    public int longLine(){
        return (int)sqrt(pow(point1.x-point2.x,2)+pow(point1.y-point2.y,2));
    }

    public void setPointFirstCoord(int x,int y) {
        point1.x=x;
        point1.y=y;
    }
    public void setPointEndCoord(int x,int y) {
        point2.x=x;
        point2.y=y;
    }

    public String getPointFirstCoord() {
        return point1.toString();
    }
    public String getPointEndCoord() {
        return point2.toString();
    }

    @Override
    public String toString() {
        return "Линия от " + point1 +" до " + point2;
    }
}
