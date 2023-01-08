package src.bloc6.School;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
    private School school;
    private String name;
    List<Integer> marks = new ArrayList<>();

    public Student(School school, String name) {
        this.school = school;
        this.name = name;
    }
    public void addMarks(Integer... mar){
        marks.addAll(Arrays.asList(mar));
        school.notifyParents(this,"marks",mar);

    }

    public void setName(String name) {
        this.name = name;
        school.notifyParents(this,"name",name);
    }
}
