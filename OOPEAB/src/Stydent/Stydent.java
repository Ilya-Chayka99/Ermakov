package src.Stydent;

import java.util.ArrayList;
import java.util.List;



public class Stydent<T> implements Coppiable {
    private String name;
    private final Ruleable<T> rule;
    private Avegerator<T> ruleSudent;
    protected List<T> rate = new ArrayList<>();
    private List<Roditel> rod = new ArrayList<>();
    public Stydent(String name,List<Roditel> r,Ruleable<T> a, T... arr) throws Exception {
        this.name = name;
        this.rod=r;
        if(a==null) throw new Exception();
        this.rule=a;
        for(T ar:arr)
        {
            if(this.rule.rule( ar)) throw new Exception();
            rate.add(ar);
        }
    }

    public void addGrade(T... t) throws Exception {
        for(T ar:t)
        {
            if(this.rule.rule( ar)) throw new Exception();
            rate.add(ar);
            for(Roditel r:rod){
                r.checNum(this,ar);
            }
        }
    }
    public Stydent(String name) throws Exception {
        this(name,null,x->true);
    }
    public void setRuleSudent(Avegerator<T> ru){
        this.ruleSudent=ru;
    }
//    public TDefault<T> mediumRate() {
//        if(rate.isEmpty()) return new TDefault<T>(null);
//        if(ruleSudent!=null) return new TDefault<T>( ruleSudent.getMediumRate(rate));
//        Avegereable<T> ru = (Avegereable<T>) rate.get(0);
//        List<T> tmp = new ArrayList<>(rate);
//        tmp.remove(0);
//        return new TDefault<T>(ru.mediumRate((T[])tmp.toArray()));
//    }
    public boolean otl() {
    	return ruleSudent.otl(rate);
    }

    public List<T> getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Stydent{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
    public Save getSave(){
        return new Save(rate,name);
    }
    @Override
    public Stydent<T> clone()  {
        try {
            Stydent<T> a = (Stydent<T>) super.clone();
            a.rate=new ArrayList<>(this.rate);
            return a;
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }

    private class Save implements Saveable{
        private List<T> rate;
        private String name;

        private Save(List<T> marks, String name){
            this.rate = new ArrayList<>(marks);
            this.name = name;
        }

        public void load(){
            Stydent.this.name = name;
            Stydent.this.rate = new ArrayList<>(rate);
        }
    }


}
