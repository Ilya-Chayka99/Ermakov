package src.Cat;

public abstract class Cats implements Catable{
    String name;
    public Cats(String name) {
        this.name = name;
    }
    public abstract void meow();
    public abstract void meow(int n);
}
