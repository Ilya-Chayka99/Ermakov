package src;

import src.Point.Point;

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

    @Override
    public String toString() {
        return "Abs{" +
                "x=" + x +
                '}';
    }
}
