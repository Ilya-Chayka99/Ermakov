import src.Abs;
import src.Point.Point;
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
import java.util.Scanner;
import java.util.function.Predicate;

public class Start {
        public static void main(String[]args) throws Exception {
//            System.out.println("Hellow World");
            System.out.println(Abs.class.getName());
            Scanner sk = new Scanner(System.in);
            String name = sk.next();

                Constructor m =Class.forName(name).getDeclaredConstructor(int.class);
                m.setAccessible(true);
                Abs c= (Abs) m.newInstance(3);
                Field f = c.getClass().getDeclaredField("x");
                f.setAccessible(true);



                f.setInt(c,5555555);
                System.out.println(f.get(c));



    }


}





