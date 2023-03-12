package src.Reflection.InspectObj;

import src.Human.Human;

import java.lang.reflect.Field;
import java.security.spec.InvalidParameterSpecException;

public class HumanTests1 {

    public void TestName(Human h) throws Exception{
        Field f = h.getClass().getDeclaredField("name");
        f.setAccessible(true);
        if(f.get(h)==null){
            throw new InvalidParameterSpecException("Имя не может быть пустым");
        }

    }
}
