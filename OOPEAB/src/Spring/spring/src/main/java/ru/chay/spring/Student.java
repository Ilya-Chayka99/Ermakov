package ru.chay.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class Student {
    private String name;
    private List<Integer> rang =new ArrayList<>();
    private Predicate<Integer> rule;

    public Student(String name,Predicate<Integer> range) {
        this.name = name;
        this.rule = range;
    }

    public Student(String name, List<Integer> rang, Predicate<Integer> range) {
        this.name = name;
        this.rule = range;
        setRang(rang);
    }

    public void setRang(Integer ... rangg) {
        setRang(Arrays.asList(rangg));
    }
    public void setRang(List<Integer> rangg) {
        if(rule!=null){
            for(Integer r:rangg)
                if(rule.test(r))
                    rang.add(r);
        }else {
            rang.addAll(rangg);
        }


    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rang=" + rang +
                '}';
    }
}
