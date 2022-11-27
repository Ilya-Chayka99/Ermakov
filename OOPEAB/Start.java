import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start {
    public static void main(String[]args) throws Exception {
        Student st = new Student("pete");
        st.addGrade(1,23,4,5,7);
        System.out.println(st);

    }
}


class Student {
    private String name;
    private List<Integer> marks = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }
    public void addGrade(int... ar){
        for(int i:ar) marks.add(i);
    }
    public List<Integer> getMarks(){
        return new ArrayList<>(marks);
    }
    public String getName() {
        return name;
    }


}
