package ru.chay.spring.TrafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight {
    private Color color;
    public TrafficLight(Color red) {
        this.color=red;
    }
    public void on(){

    }
    public void next(){
        System.out.println(color);
        color= color.next();
    }
}
