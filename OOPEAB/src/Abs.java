package src;

import src.Point.Point;

import java.util.ArrayList;
import java.util.List;

public class Abs {
    final int x=5;
    private Abs(int k) {
        System.out.println(k);
    }

    @Override
    public String toString() {
        return "Abs{" +
                "x=" + x +
                '}';
    }
}
