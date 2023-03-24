package ru.chay.spring.TrafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TrafficLight {
    private Color color;
    @Autowired
    private Color black;
    @Autowired
    private Color red;
    public TrafficLight(Color colorl) {
        this.color=colorl;
    }

    public void on(){
        color=red;
    }
    public void off(){
        color=black;
    }
    public void next(){
        System.out.println(color);
        color= color.next();
    }
}
