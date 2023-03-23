package ru.chay.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Rand {
    private int min,max;
    List<Integer> list =new ArrayList<>();

    @Autowired
    public void setMin(int min) {
        this.min = min;
    }
    @Autowired
    public void setMax(int max) {
        this.max = max;
    }

    public int rand()
    {
        Random r = new Random();
        while (true)
            while (list.size()!=(Math.abs(max)+Math.abs(min))+1){
                int k= r.nextInt(min,max+1);;
                if(!list.contains(k)) {
                    list.add(k);
                    return k;
                }
                if(list.size()==(Math.abs(max)+Math.abs(min))-1){
                    list.clear();
                    break;
                }
            }

    }
}
