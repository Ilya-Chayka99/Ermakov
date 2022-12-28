package src.Stydent;

import java.util.ArrayList;
import java.util.List;

public class Roditel<T> implements RuleRodable<T>{

    private List<RuleSt> st = new ArrayList<>();

    public Roditel(List<RuleSt> st) {
        this.st = st;
    }

    public void checNum(Stydent<T> s, T t){
        for(RuleSt r : st){
            if(s.equals(r.getSt())) {
            }
        }
    }
}
