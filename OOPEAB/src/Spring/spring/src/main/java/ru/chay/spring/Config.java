package ru.chay.spring;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.function.Predicate;

@Configuration
public class Config {
    @Bean
    String hello(){
        return "Hello world";
    }
    @Bean
    @Scope("prototype")
    int random(Rand rand){
        return rand.rand();
    }

    @Bean
    @Lazy
    Date date(){
        return new Date();
    }
    @Bean
    @Qualifier("Stud")
    Predicate<Integer> range(){
        return (x)->(x>=2 && x<=5);
    }
    @Bean
    int min(){
        return 1;
    }
    @Bean
    int max(){
        return 5;
    }

    @Bean
    Feedback good(){
        return new Feedback("Очень хорошо",4);
    }
    @Bean
    Feedback usual(){
        return new Feedback("Сойдет",3);
    }
    @Bean
    @Lazy
    Feedback hardToSay(int random){
        return new Feedback("Сложно сказать",random);
    }
    @Bean
    @Lazy
    Feedback topFeedback(List<Feedback> rev){
        Feedback f = rev.get(0);
        for(Feedback fid:rev)
            if(f.getRang()< fid.getRang())
                f=fid;
        return f;
    }
    @Bean
    @Scope("prototype")
    Student getSt(@Qualifier("Stud") Predicate<Integer> rule){
        return new Student("DR", Arrays.asList(1,4,8,4,99,3,5),rule);
    }
}
