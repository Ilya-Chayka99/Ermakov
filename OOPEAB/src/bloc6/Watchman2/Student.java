package src.bloc6.Watchman2;

public final class Student extends Human {
    private String name;
    private Integer number;

    public Student(String name, Integer number,Accessable r) {
        super(r);
        this.name = name;
        this.number = number;
    }
    public Student(){
        this(null,null,null);
    }

    public void setRule(Accessable rule) {
        this.rule = rule;
    }

    @Override
    public boolean check() {
        if(rule!=null)
            return rule.Access(this);
        return false;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }
}
