package src.Reflection.Entity;

import src.Reflection.Prim;
import src.Reflection.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B extends A{
    public B(String s) {
        super(s);
    }

    @ToString(Prim.NO)
    List<String> l = new ArrayList<>(Arrays.asList("1","di"));
}
