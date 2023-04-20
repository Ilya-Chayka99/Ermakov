package ru.chay.spring;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PoliLine{
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
    public PoliLine addPoliLinePoint(Point... point){
        for(Point p : point){
            points.add(p);
        }
        return this;
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

    public PoliLine addPoliLinePoint(PoliLine poliLine) {
        this.points=poliLine.points;
        return this;
    }
}
