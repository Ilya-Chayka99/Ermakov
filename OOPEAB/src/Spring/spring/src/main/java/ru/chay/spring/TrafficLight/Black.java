package ru.chay.spring.TrafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Black implements Color{
    @Override
    public Color next() {
        return this;
    }
    @Override
    public String toString() {
        return "Black";
    }
}
