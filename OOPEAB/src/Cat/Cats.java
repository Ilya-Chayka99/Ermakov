package src.Cat;

public abstract class Cats {
    String name;
    public Cats(String name) {
        this.name = name;
    }
    public abstract void meow();
    abstract void meow(int n);
}
