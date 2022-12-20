package src.bloc6.Watchman1;

public class RuleTeacher implements RuleHuman<Teacher>{
    public RuleTeacher() {
    }
    @Override
    public boolean Access(Teacher h) {
        if (h.getName() == null) return false;
        if (h.getNumber() == null && h.getDol() != null) return true;
        if (h.getNumber() != null) return true;
        else return false;

    }
}
