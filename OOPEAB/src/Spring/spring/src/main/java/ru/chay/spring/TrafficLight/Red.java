package ru.chay.spring.TrafficLight;


import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Red implements Color{
    @Autowired
    private Color yellow;

    public Red() {
    }

    @Override
    public Color next() {
        return yellow;
    }

    @Override
    public String toString() {
        return "Red";
    }
}
