package src.Bird;

abstract class Bird {
    String text;

    public Bird(String text) {
        this.text = text;
    }

    abstract public void song();
}
