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
    public void setRuleSudent(RuleSudent<T> ru){
        this.ruleSudent=ru;
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
