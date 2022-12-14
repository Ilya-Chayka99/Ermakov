package src.Line;

import src.Point.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PoliLine poliLine = (PoliLine) o;
        return Objects.equals(points, poliLine.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
