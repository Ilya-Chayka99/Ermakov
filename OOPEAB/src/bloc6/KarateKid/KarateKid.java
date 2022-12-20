package src.bloc6.KarateKid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KarateKid {
    private final String name;
    List<Punchable> punches = new ArrayList<>();

    public KarateKid(String name) {
        this.name = name;
    }

    public void addPunch(Punchable... p){
        punches.addAll(Arrays.stream(p).toList());
    }
    public void addPunch(List<Punchable> p){
        punches.addAll(p);
    }
    public void punch(){
        for(Punchable p:punches){
            System.out.println(name+" : "+ p.punch());
        }
    }

}
