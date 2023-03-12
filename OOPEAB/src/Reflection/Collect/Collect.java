package src.Reflection.Collect;

import src.Reflection.Invoke;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class Collect {

    public static Map<String,Object> collect(Class<?> ... b) throws Exception{
        Map<String,Object> s = new HashMap<>();
        for(Class<?> x:b){
            String str = x.getSimpleName().toString();
            Object ob = x.newInstance();
            for (Method m : x.getDeclaredMethods()) {
                Annotation a = m.getDeclaredAnnotation(Invoke.class);
                if (a != null) {
                    if (m.getParameterCount() == 0) {
                        s.put(m.getName(), m.invoke(ob));
                    }else{
                        Parameter[] parameter = m.getParameters();
                        Object[] ob1 = {};
                        int i=0;
                        for(Parameter parameter1:parameter){
                            System.out.println(s.values().stream()
                                    .filter(y->y.getClass()==parameter1.getType())
                                    .findAny());
                             ob1[i]= s.values().stream()
                                    .filter(y->y.getClass()==parameter1.getType())
                                    .findAny();

                        }
                        s.put(m.getName(), m.invoke(ob,ob1));


                    }
                }
            }
        }
        return s;
    }

}
