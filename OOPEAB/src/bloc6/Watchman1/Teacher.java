package src.bloc6.Watchman1;

public final class Teacher extends Human{
    private String name;
    private Integer number;
    private String dol;
    private RuleHuman<Teacher> rule;

    public Teacher(String name, Integer number, String dol,RuleHuman<Teacher> t) {
        this.name = name;
        this.number = number;
        this.dol = dol;
        this.rule=t;
    }
    public Teacher() {
        this(null,null,null,null);
    }

    @Override
    public boolean check() {
        if(rule!=null)
            return rule.Access(this);
        return false;
    }

    public void setRule(RuleHuman<Teacher> rule) {
        this.rule = rule;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDol() {
        return dol;
    }
}
