import src.Abs;
import src.Gun.GunAvtomat;
import src.Human.Human;
import src.Line.Cirkyle;
import src.Line.Line;
import src.Name.Name;
import src.Point.Point;
import src.Reflection.Entity.A;
import src.Reflection.Entity.B;
import src.Reflection.InspectObj.HumanTests;
import src.Reflection.InspectObj.InspectObj;
import src.Reflection.Read.ObjectsReader;
import src.bloc6.Exam.Codeable;
import src.bloc6.Exam.Zadacha;
import src.bloc6.School.Parent;
import src.bloc6.School.School;
import src.bloc6.School.Student;
import src.bloc6.Trafficlight.Colors;
import src.bloc6.Trafficlight.Trafficlight;
import src.bloc6.Watchman2.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Start {
        public static void main(String[]args) throws Exception {
//            System.out.println("Hellow World");
//            System.out.println(Abs.class.getName());
//            Scanner sk = new Scanner(System.in);
//            String name = sk.next();
//
//                Constructor m =Class.forName(name).getDeclaredConstructor(int.class);
//                m.setAccessible(true);
//                Abs c= (Abs) m.newInstance(3);
//                Field f = c.getClass().getDeclaredField("x");
//                f.setAccessible(true);
//
//
//
//                f.setInt(c,5555555);
//                System.out.println(f.get(c));
//7.1.1
//            Abs a = new Abs();
//            GunAvtomat b = new GunAvtomat();
//            System.out.println(InspectObj.fieldCollection(a));
//7.1.2
//            Line line = new Line(1,1,5,5);
//            Line line2 = new Line(1,1,9,9);
//            System.out.println(line+"     "+line2);
//            InspectObj.lineConnector(line,line2);
//            System.out.println(line+"     "+line2);
//7.1.3
//            B a = new B();
//            System.out.println(a);
//7.1.4
//            Human h =new Human("Stiv",300);
//            InspectObj.validate(h, HumanTests.class);
//
            ObjectsReader<Line> ob = new ObjectsReader<>("src/Reflection/Read/my.txt");
            Human h =new Human("Stiv",300);
            Human h1 =new Human("Stiv",300);
            System.out.println(ob.reader());



//            System.out.println(Point.class);
    }


}





