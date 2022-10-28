package src.immutableArrey;

import java.util.ArrayList;
import java.util.List;

public class ImmutableArrey {
    private List<Integer> arr = new ArrayList<>();

    public ImmutableArrey(List<Integer> arr) {
        this.arr= new ArrayList<>(arr);
    }
    public ImmutableArrey(int... arr){
        for(Integer ar:arr){
            this.arr.add(ar);
        }
    }
    public int getNum(int poz) throws Exception {
        proverka(poz);
        return arr.get(poz);

    }
    public void replaseNum(int num, int poz) throws Exception {
        proverka(poz);
        arr.set(poz,num);
    }
    public boolean ifEmty()
    {
        if(arr.size()==0) return true;
        return false;
    }
    public int isSize(){
        return arr.size();
    }
    private void proverka(int poz) throws Exception {
        if(poz<00 && poz>arr.size()-1) {
            throw new Exception("Позиция вышла за рамки массива");
        }
    }

    @Override
    public String toString() {
        return ""+arr;
    }
}
