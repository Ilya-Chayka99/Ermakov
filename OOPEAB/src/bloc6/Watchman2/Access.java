package src.bloc6.Watchman2;

public class Access implements Accessable {
    public Access() {
    }

    @Override
    public boolean Access(Human h) {
        return false;
    }

    @Override
    public boolean Access(Student h) {
        if(h.getName()==null||h.getNumber()==null)
            return false;
        return true;
    }

    @Override
    public boolean Access(Teacher h) {
        if (h.getName()==null||(h.getDol()==null&&h.getNumber()==null))
            return false;
        return true;
    }
}
