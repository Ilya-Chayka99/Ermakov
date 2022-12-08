package src.myUtilist;

import src.Bird.Bird;
import src.Cat.Cats;
import src.Figurs.Figure;
import src.Figurs.PoliLineable;
import src.Line.Longable;
import src.Point.Point;
import src.PoliLine.PoliLine;

import java.util.List;

import static java.lang.Math.*;
import static java.lang.Integer.*;

public class MyUtilits {

    public static double sum(Number... ar){
        double sum=0;
        for(Number a:ar){
            sum+=a.doubleValue();
        }
        return sum;
    }
    public static void birdMarket(Bird ... ar){
        for(Bird bird:ar){
            bird.song();
        }
    }
    public static double squaresFigures (Figure... ar){
        double sum=0;
        for(Figure a:ar){
            sum+=a.sqare();
        }
        return sum;
    }
    public static void Meowing(Cats... ar){
        for(Cats m:ar){
            m.meow();
        }
    }
    public static double longLines (Longable... ar){
        double sum=0;
        for(Longable a:ar){
            sum+=a.longLine();
        }
        return sum;
    }
    public static PoliLine addPolilines(PoliLineable ...p){
        PoliLine poliLine = new PoliLine();
        for (PoliLineable ar:p)
        {
            poliLine.addPoliLinePoint(ar.newPoliLine().getPoliLine());
        }
        return poliLine;
    }
    public static Double powString(String x,String y){
        return pow(parseInt(x),parseInt(y));
    }


}
