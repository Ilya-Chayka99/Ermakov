package ru.chay.spring.TrafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Yellow implements Color{

    private Color green;
    @Autowired
    public void setGreen(@Qualifier("green") @Lazy Color green) {
        this.green = green;
    }

    @Override
    public Color next() {
        return green;
    }
    @Override
    public String toString() {
        return "Yellow";
    }
}
