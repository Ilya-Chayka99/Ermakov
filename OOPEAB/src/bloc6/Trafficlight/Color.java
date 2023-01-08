package src.bloc6.Trafficlight;

import java.util.HashMap;

public class Color implements Colorable{
    String name;

    public Color(String name) {
        this.name = name;
    }

    @Override
    public Color next() {
        return null;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                '}';
    }
}
