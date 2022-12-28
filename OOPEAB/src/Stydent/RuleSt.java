package src.Stydent;

public class RuleSt<T> {
    private Stydent<T> st;
    private RuleRodable<T> rule;

    public RuleSt(Stydent<T> st, RuleRodable<T> rule) {
        this.st = st;
        this.rule = rule;
    }

    public Stydent<T> getSt() {
        return st;
    }

    public RuleRodable<T> getRule() {
        return rule;
    }
}
