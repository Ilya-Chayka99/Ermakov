package src.bloc6.School;

import java.lang.reflect.Array;
import java.security.KeyStore;
import java.util.*;


public class School {
    Map<String,List<Parent>> observ = new HashMap<>();

    public School() {
        observ.put("marks",new ArrayList<>());
        observ.put("name",new ArrayList<>());
    }

    public void addObsMarks(Parent p){
        observ.get("marks").add(p);
    }
    public void addObsName(Parent p){
        observ.get("name").add(p);
    }
    public void addObsMarksName(Parent p){
        addObsMarks(p);
        addObsName(p);
    }
    public void notifyParents(Student s,String key,Integer... mar){
        for(Map.Entry<String,List<Parent>> e : observ.entrySet()){
            if(e.getKey()==key){
                List<Parent> p = e.getValue();
                for(Parent g:p){
                    if(g.getStudents().contains(s)){
                        g.obs("Получил оценку(и)  " + Arrays.asList(mar));
                    }
                }
            }
        }
    }
    public void notifyParents(Student s,String key,String name){
        for(Map.Entry<String,List<Parent>> e : observ.entrySet()){
            if(e.getKey()==key){
                List<Parent> p= e.getValue();
                for(Parent g:p){
                    if(g.getStudents().contains(s)){
                        g.obs("Изменнил имя на "+name);
                    }
                }
            }
        }
    }
}
