package src.bloc6.KarateKid;

public class Punch implements Punchable{
    private  String text;

    public Punch(String text) {
        this.text = text;
    }
    public String punch(){
        return text;
    }
}
