package src.bloc6.Trafficlight;

public class Trafficlight {
    Colors color;

    public Trafficlight(Colors color) {
        this.color = color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void next(){
        System.out.println(color);
        this.color=color.next();
    }


}
