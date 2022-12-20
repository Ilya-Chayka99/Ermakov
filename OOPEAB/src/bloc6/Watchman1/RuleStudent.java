package src.bloc6.Watchman1;

public class RuleStudent implements RuleHuman<Student> {
    public RuleStudent() {
    }
    @Override
    public boolean Access(Student h) {
        if(h.getName()==null||h.getNumber()==null)
            return false;
        else return true;
    }
}
