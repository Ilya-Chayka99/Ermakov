package src.Reflection.InspectObj;

import src.Human.Human;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.Map;

public class HumanTests {

    public void TestHeight(Human h) throws Exception{
        Field f = h.getClass().getDeclaredField("height");
        f.setAccessible(true);
        if((double)f.get(h)>250){
            throw new InvalidParameterSpecException("Рост человека не может быть больше 250см))");

        }


    }
}
