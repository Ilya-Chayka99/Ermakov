package src.Line;

import src.Point.Point;

import java.util.List;

public class Cirkyle extends PoliLine {
    public Cirkyle(Point... arr) {
        super(arr);
        this.addPoliLinePoint(arr[0]);
    }

    public Cirkyle(List arr) {
        super(arr);
    }

    public Cirkyle() {
    }
    @Override
    public double longLine(){
        return super.longLine()+Math.hypot(getLastPoint().x-getPoint(0).x,getLastPoint().y-getPoint(0).y);
    }
}
