package src.Point;

public class Point3 extends Point{
    double z;
    public Point3(double x, double y,double z) {
        super(x, y);
        this.z=z;
    }

    public Point3(double x, double y) {
        super(x, y);
        this.z=0;
    }
}
