package src.PoliLine;

import src.Line.Line;
import src.Line.Longable;
import src.Point.Point;

import java.util.ArrayList;
import java.util.List;

public class PoliLine implements Longable {
    private List<Point> points =new ArrayList<>();

    public PoliLine(Point...arr) {
        for(Point p:arr)
        {
            points.add(p);
        }
    }
    public PoliLine(List arr){
        points.addAll(arr);
    }
    public PoliLine() {

    }
    public void addPoliLinePoint(Point... point){
        for(Point p : point){
            points.add(p);
        }
    }
    public Point getPoint(int i){
        return points.get(i);
    }
    public List<Point> getPoliLine(){
        return new ArrayList<>(points);
    }
    public Point getLastPoint(){
        return points.get(points.size()-1);
    }
    public void addPoliLinePoint(List arr){
       points.addAll(arr);
    }
    public double longLine(){
        double size=0;
        for(int i=0;i<points.size()-1;i++)
        {
            size+=new Line(points.get(i),points.get(i+1)).longLine();
        }
        return size;
    }

    @Override
    public String toString() {
        return "Линия "+points;
    }
}
