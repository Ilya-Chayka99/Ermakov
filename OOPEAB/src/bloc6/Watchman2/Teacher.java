package src.bloc6.Watchman2;

public final class Teacher extends Human {
    private String name;
    private Integer number;
    private String dol;


    public Teacher(String name, Integer number, String dol,Accessable r) {
        super(r);
        this.name = name;
        this.number = number;
        this.dol = dol;
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

    public void setRule(Accessable rule) {
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
