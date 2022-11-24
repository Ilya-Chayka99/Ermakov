package src.Bird;

public abstract class Bird {
    String text;

    public Bird(String text) {
        this.text = text;
    }

    abstract public void song();
}
