package ru.chay.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;
@Component
public class FabricaStudent {
    private Predicate<Integer> rule;

    public FabricaStudent( @Qualifier("Stud") Predicate<Integer> rule) {
        this.rule = rule;
    }
    public Student createStudent(String name , List<Integer> arr){
        return new Student(name,arr,rule);
    }
//    public Student createStudent(String name){
//        return new Student(name,rule);
//    }
}
