package src.Stydent;

public class TDefault<T> {
    private T avg;
    private TDefault(){}
    private TDefault(T t) {
        this.avg = t;
    }
    public T getOr(T def){
        if(this.avg==null) return def;
        return this.avg;
    }
    public static <R> TDefault<R> create() {
        return new TDefault<R>();
    }
    public  static <R> TDefault<R> createNoNull(R t){
        if(t==null) throw new IllegalArgumentException();
        return new TDefault<R>(t);
    }
    public  static <R> TDefault<R> createNull(R t){
        return new TDefault<R>(t);
    }
}
