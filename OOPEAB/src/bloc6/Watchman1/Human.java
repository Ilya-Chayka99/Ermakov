package src.bloc6.Watchman1;

public class Human {
    private RuleHuman<Human> rule;
    public Human() {
    }

    public Human(RuleHuman<Human> rule) {
        this.rule = rule;
    }

    public boolean check(){
        if(rule!=null)
            return rule.Access(this);
        return false;
    }
}
