package src.Point;

import java.util.HashMap;
import java.util.Map;

public class PointStats {
    Map<String,Object> map =new HashMap<>();
    PointStats(Map<String,Object> map){
        this.map= map;
    }
    public PointStats(){}
    public void add(String s,Object o){

        map.put(s,o);
    }
    @Override
    public String toString() {
        String s="";
       for(Map.Entry<String,Object> m:map.entrySet()){
           s+="["+m.getKey()+":"+m.getValue()+"] ";
       }
       return s;
    }
}
