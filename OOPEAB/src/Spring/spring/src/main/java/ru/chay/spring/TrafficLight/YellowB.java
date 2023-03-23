package ru.chay.spring.TrafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class YellowB implements Color{
    @Autowired
    private Color red;


    @Override
    public Color next() {
        return red;
    }
    @Override
    public String toString() {
        return "Yellow";
    }
}
