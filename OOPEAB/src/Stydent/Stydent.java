package src.Stydent;

import java.util.ArrayList;
import java.util.List;



public class Stydent<T> {
    private String name;
    Ruleable<T> rule;
    RuleSudent<T> ruleSudent;
    private List<T> rate = new ArrayList<>();

    public Stydent(String name,Ruleable<T> a,RuleSudent<T> ru, T... arr) throws Exception {
        this.name = name;
        if(a==null||ru==null) throw new Exception();
        this.rule=a;
        this.ruleSudent=ru;
        for(T ar:arr)
        {
            if(this.rule.rule( ar)) throw new Exception();
            rate.add(ar);
        }
    }
    public T mediumRate() {
        return ruleSudent.getMediumRate(rate);
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
}
