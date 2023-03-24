package ru.chay.spring.TrafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Green implements Color{

    private Color yellowB;
    @Autowired
    public void setYellowB(Color yellowB) {
        this.yellowB = yellowB;
    }

    @Override
    public Color next() {
        return yellowB;
    }
    @Override
    public String toString() {
        return "Green";
    }
}
