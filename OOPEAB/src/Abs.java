package src;

import src.Point.Point;
import src.Reflection.Default;
import src.Reflection.Entity.A;
import src.Reflection.Invoke;
import src.Reflection.Reset.Def;
import src.Reflection.Two;

import java.util.ArrayList;
import java.util.List;

public class Abs {

    final int x=5;

    public String a="1";

    private int y=6;
    private Abs(int k) {
        System.out.println(k);
    }

    public Abs() {
    }
    @Invoke
    public String getS() {
        return "ugurhg";
    }
    @Invoke
    public int getX() {
        return x;
    }
    @Invoke
    A a(String s){
        return new A(s);
    }
    @Override
    public String toString() {
        return "Abs{" +
                "x=" + x +
                ", a='" + a + '\'' +
                ", y=" + y +
                '}';
    }
}
