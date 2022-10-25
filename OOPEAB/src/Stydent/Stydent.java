package src.Stydent;

import java.util.ArrayList;
import java.util.List;

public class Stydent {
    private String name;
    private List<Integer> rate = new ArrayList<>();

    public Stydent(String name, Integer... arr) throws Exception {
        this.name = name;
        for(Integer ar:arr)
        {
            if(ar>5||ar<2) throw new Exception();
            rate.add(ar);
        }
    }
    public int mediumRate() {
    	if(rate.size()==0) return 0;
    	int mediumRate = 0;
    	for(Integer i:rate)
    	{
    		mediumRate+=i;
    	}
    	return mediumRate/rate.size();
    }
    public boolean otl() {
    	if(rate.size()==0) return false;
    	for(Integer i:rate)
    	{
    		if(i!=5) return false; 
    	}
    	return true;
    }

    public List<Integer> getRate() {
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
