package ru.chay.spring.TrafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Yellow implements Color{
    @Autowired
    private Color green;

    @Override
    public Color next() {
        return green;
    }
    @Override
    public String toString() {
        return "Yellow";
    }
}
