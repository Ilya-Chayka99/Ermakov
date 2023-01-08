import src.bloc6.School.Parent;
import src.bloc6.School.School;
import src.bloc6.School.Student;
import src.bloc6.Trafficlight.Colors;
import src.bloc6.Trafficlight.Trafficlight;
import src.bloc6.Watchman2.*;

import java.util.function.Predicate;

public class Start {
    public static void main(String[]args) throws Exception {
        School sk = new School();
        Student s = new Student(sk,"Vasa");
        Parent p = new Parent("Vasa");
        Parent p2 = new Parent("Ileg");
        Parent p3 = new Parent("ыварвапртапт");
        p.addS(s);
        p2.addS(s);
        p3.addS(s);
        sk.addObsMarks(p);
        sk.addObsMarksName(p2);
        sk.addObsName(p3);
        s.addMarks(3);
        s.addMarks(3,455);
        s.setName("Гандон");
        Predicate<Integer> rule = (a)->(a<4);

    }


}




