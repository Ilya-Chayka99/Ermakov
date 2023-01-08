package src.bloc6.School;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Parent {
    public String name;
    private List<Student> students = new ArrayList<>();

    public Parent(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
    public void addS(Student s){
        students.add(s);
    }
    public void obs(String s){
        System.out.println("Уважаемый "+name+" ваш ребенок : " + s);
    }
}
