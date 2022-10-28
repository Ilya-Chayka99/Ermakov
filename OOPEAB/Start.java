import src.immutableArrey.ImmutableArrey;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String[]args) throws Exception {
        ImmutableArrey ar = new ImmutableArrey(1,2,4,6,7);
        System.out.println(ar);
        System.out.println(ar.getNum(3));
        ar.replaseNum(99,0);
        System.out.println(ar);
        System.out.println(ar.ifEmty());
        System.out.println(ar.isSize());
    }
}
