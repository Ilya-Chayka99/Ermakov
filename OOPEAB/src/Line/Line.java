package src.Line;

import src.Figurs.PoliLineable;
import src.Point.Point;
import src.PoliLine.PoliLine;

import java.util.Objects;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Line implements Longable, PoliLineable {
    private Point point1,point2;

    public Line(Point point1, Point point2) {
        this(point1.x,point1.y,point2.x,point2.y);
    }

    public Line(double x1,double y1,double x2, double y2) {
        this.point1 = new Point(x1,y1);
        this.point2 = new Point(x2,y2);

    }
    public double longLine(){
        return sqrt(pow(point1.x-point2.x,2)+pow(point1.y-point2.y,2));
    }

    @Override
    public PoliLine newPoliLine() {
        PoliLine p = new PoliLine();
        p.addPoliLinePoint(point1,point2);
        return p;
    }

    public void setPointFirstCoord(int x, int y) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(point1, line.point1) && Objects.equals(point2, line.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }
}
