package ru.chay.spring.PostProcessor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ru.chay.spring.Invoke;
import ru.chay.spring.TrafficLight.Color;
import ru.chay.spring.TrafficLight.Green;

import java.util.function.Predicate;

@Component
public class DefaultConf {
    @Invoke
    @Bean
    String hel(){
        return "Hello world";
    }

    @Invoke
    @Bean
    Predicate<Integer> rul(){
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        };
    }

}
