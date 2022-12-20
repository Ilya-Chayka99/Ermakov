package src.Stydent;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;



public class Stydent<T> implements Coppiable {
    private String name;
    private final Ruleable<T> rule;
    private  RuleSudent<T> ruleSudent;
    protected List<T> rate = new ArrayList<>();

    public Stydent(String name,Ruleable<T> a, T... arr) throws Exception {
        this.name = name;
        if(a==null) throw new Exception();
        this.rule=a;
        for(T ar:arr)
        {
            if(this.rule.rule( ar)) throw new Exception();
            rate.add(ar);
        }
    }
    public Stydent(String name) throws Exception {
        this(name,x->true);
    }
    public void setRuleSudent(RuleSudent<T> ru){
        this.ruleSudent=ru;
    }
    public TDefault<T> mediumRate() {
        if(rate.isEmpty()) return new TDefault<T>(null);
        if(ruleSudent!=null) return new TDefault<T>( ruleSudent.getMediumRate(rate));
        RuleStudentable<T> ru = (RuleStudentable<T>) rate.get(0);
        List<T> tmp = new ArrayList<>(rate);
        tmp.remove(0);
        return new TDefault<T>(ru.mediumRate((T[])tmp.toArray()));
    }
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


}
