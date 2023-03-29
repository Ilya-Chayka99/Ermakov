package javaapplication2;

import java.util.*;
import java.util.function.Predicate;

public class Student<T> {
    private String name;
    private List<T> marks = new ArrayList<>();
    private Predicate<T> rule;
    private Avegerator<T> avegerator;
    
    public Student(String name) {
        this(name, x -> true);
    }

    public Student(String name, Predicate<T> rule, T... marks) {
        this.name = name;
        this.rule = rule;
        for (T mark : marks) {
            addGrade(mark);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGrade(T mark) {
        if (!rule.test(mark)) {
            throw new IllegalArgumentException();
        }
        this.marks.add(mark);
    }

    public void removeGrade(T mark) {
        marks.remove(mark);
    }

    public List<T> getMarks() {
        return new ArrayList<>(marks);
    }

    public void setAvegerator(Avegerator<T> avegerator) {
        this.avegerator = avegerator;
    }
    
    public T avg(){
        if(avegerator!=null) return avegerator.avg(marks);
        Avegerable<T> avegerable=(Avegerable<T>)marks.get(0);
        List<T> tmp= new ArrayList<>(marks);
        tmp.remove(0);
        return avegerable.avg((T[])tmp.toArray());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,marks);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null||getClass() != obj.getClass()) {
            return false;
        }
        final Student<?> other = (Student<?>) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.marks, other.marks);
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", marks=" + marks + '}';
    }
    
}
