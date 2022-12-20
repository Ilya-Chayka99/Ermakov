package src.bloc6.Trafficlight;

public class Trafficlight {
    Colorable color;

    public Trafficlight(Colorable color) {
        this.color = color;
    }

    public void setColor(Colorable color) {
        this.color = color;
    }

    void next(){
        System.out.println(color);
        this.color=color.next();
    }


}
