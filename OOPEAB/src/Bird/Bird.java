package src.Bird;

abstract class Bird {
    String text;

    public Bird(String text) {
        this.text = text;
    }
    public Bird(){
    }
    abstract public void song();
}
