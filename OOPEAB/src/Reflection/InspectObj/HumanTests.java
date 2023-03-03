package src.Reflection.InspectObj;

import src.Human.Human;

import java.lang.reflect.Field;

public class HumanTests {
    public void TestHeight(Human h) throws Exception{
        Field f = h.getClass().getDeclaredField("height");
        f.setAccessible(true);
        if((double)f.get(h)>250){
            throw new RuntimeException("Рост человека не может быть больше 250см))");

        }


    }
}
