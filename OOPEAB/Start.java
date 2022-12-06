import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Start {
    public static void main(String[]args) throws Exception {
        Student st = new Student("pete");
        st.addGrade(1,23,4,5,7);
        Student cl = st.clone();
        cl.addGrade(99);
        System.out.println(st);
        System.out.println(cl);
//        Class cl = st.getClass();
//        System.out.println(Arrays.asList(cl.getDeclaredFields()));

    }
//    public static boolean ik(String st){
//        return st.equals("Hellow");
//        return "Hellow".equals(st);
//    }
}


class Student {
    private String name;
    private List<Integer> marks = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(Student ar){
        this.name=ar.name;
//        this.marks=ar.marks.cl
        this.marks=new ArrayList<>(ar.marks);
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

    @Override
    public Student clone() {
        Student st = new Student(name);
        st.marks=new ArrayList<>(this.marks);
        return st ;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(name, marks);
        return 42;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

