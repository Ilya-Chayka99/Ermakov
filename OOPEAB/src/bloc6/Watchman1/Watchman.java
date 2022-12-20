package src.bloc6.Watchman1;

public final class Watchman implements UserVisitor{
    public Watchman() {
    }
    public boolean checkUser(Human v) {
        return v.check();
    }
}
