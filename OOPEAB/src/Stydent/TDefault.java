package src.Stydent;

public class TDefault<T> {
    T t;

    public TDefault(T t) {
        this.t = t;
    }
    public T getOr(T p){
        if(this.t==null) return p;
        return this.t;
    }
}
