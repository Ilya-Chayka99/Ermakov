package src.Bird;

public class Vorobei extends Bird{
    public Vorobei(String text) {
        super(text);
    }

    public Vorobei() {
        this("ЧЫРЫК");
    }

    @Override
    public void song() {
        System.out.println(text);
    }
}
