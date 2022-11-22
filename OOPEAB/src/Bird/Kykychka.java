package src.Bird;

public class Kykychka extends Bird {
    public Kykychka(String text) {
        super(text);
    }

    public Kykychka() {
        this("ку-ку");
    }

    @Override
    public void song() {
        int i = (int) (Math.random()*9)+1;
        for(int k=0;k<i;k++)
            System.out.println(text);
    }
}
