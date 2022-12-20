package src.bloc6.Watchman2;

public class Human {
    protected Accessable rule;
    public Human() {
        this(null);
    }

    public Human(Accessable rule) {
        this.rule = rule;
    }

    public boolean check(){
        if(rule!=null)
            return rule.Access(this);
        return false;
    }
}
