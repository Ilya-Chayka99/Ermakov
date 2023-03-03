package src.Reflection.InspectObj;

import src.Line.Line;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InspectObj {
    public static String fieldCollection(Object b){
        Class<?> clazz=b.getClass();
        List<Field> f= new ArrayList<>();
        while (clazz!=Object.class){

            Arrays.stream(clazz.getDeclaredFields()).forEach(field -> f.add(field));
            clazz=clazz.getSuperclass();
        }
        return f.toString();
    }
    public static void lineConnector(Line l1,Line l2) throws Exception{

        Field f = l2.getClass().getDeclaredField("point1");
        Field f2 = l1.getClass().getDeclaredField("point2");
        f.setAccessible(true);
        f2.setAccessible(true);
        f.set(l2,f2.get(l1));
    }
    public static void validate(Object b,Class<?> clazz) throws Exception{
        Object t = clazz.newInstance();
        List<Method> m =Arrays.stream(t.getClass().getMethods()).toList();

        for (Method met:m) {
            Class<?>[] types = met.getParameterTypes();
           for(Class<?> ty:types)
                if(ty==b.getClass()){
                    met.invoke(t,b);
            };
        }
        System.out.println("Все тесты были выполнены!");

    }
}
