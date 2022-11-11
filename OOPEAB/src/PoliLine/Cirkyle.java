package src.PoliLine;

import src.Point.Point;

import java.util.List;

public class Cirkyle extends PoliLine {
    public Cirkyle(Point... arr) {
        super(arr);
    }

    public Cirkyle(List arr) {
        super(arr);
    }

    public Cirkyle() {
    }
    @Override
    public double lengthPoliLine(){
        return super.lengthPoliLine()+Math.hypot(getLastPoint().x-getPoint(0).x,getLastPoint().y-getPoint(0).y);
    }
}
