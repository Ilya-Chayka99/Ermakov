package src.Bird;

public abstract class Bird implements Songable {
    String text;

    public Bird(String text) {
        this.text = text;
    }

    abstract public void song();
}
