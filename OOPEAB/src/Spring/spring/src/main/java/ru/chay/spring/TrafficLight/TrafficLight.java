package ru.chay.spring.TrafficLight;

public class TrafficLight {
    private Color color;
    public TrafficLight(Color colorl) {
        this.color=colorl;
    }

    public void on(Color red){
        color=red;
    }
    public void off(Color black){
        color=black;
    }
    public void next(){
        System.out.println(color);
        color= color.next();
    }
}
