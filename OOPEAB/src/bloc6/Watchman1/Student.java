package src.bloc6.Watchman1;

public final class Student extends Human{
    private String name;
    private Integer number;
    private RuleHuman<Student> rule;
    public Student(String name, Integer number,RuleHuman<Student> r) {
        this.name = name;
        this.number = number;
        this.rule=r;
    }
    public Student(){
        this(null,null,null);
    }
    public void setRule(RuleHuman<Student> rule) {
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
