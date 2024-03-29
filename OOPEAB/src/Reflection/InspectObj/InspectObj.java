package src.Reflection.InspectObj;

import src.Line.Line;
import src.Reflection.Validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.spec.InvalidParameterSpecException;
import java.util.*;

public class InspectObj {
    public static List<Field> fieldCollection(Object b){
        Class<?> clazz=b.getClass();
        List<Field> f= new ArrayList<>();
        while (clazz!=Object.class){

            Arrays.stream(clazz.getDeclaredFields()).forEach(field -> f.add(field));
            clazz=clazz.getSuperclass();
        }
        return f;
    }
    public static void lineConnector(Line l1,Line l2) throws Exception{

        Field f = l2.getClass().getDeclaredField("point1");
        Field f2 = l1.getClass().getDeclaredField("point2");
        f.setAccessible(true);
        f2.setAccessible(true);
        f.set(l2,f2.get(l1));
    }
    public static void validate(Object b) throws Exception{
        Class<?>[] clazz=null;
        if(!b.getClass().isAnnotationPresent(Validate.class)){
            Annotation[] annotation= b.getClass().getDeclaredAnnotations();
            for(Annotation annotation1:annotation){
                if(annotation1.annotationType().isAnnotationPresent(Validate.class)){
                    clazz = annotation1.annotationType().getDeclaredAnnotation(Validate.class).value();
                    break;
                }
            }
        }
        else clazz = b.getClass().getDeclaredAnnotation(Validate.class).value();
        Map<String,InvalidParameterSpecException> map = new HashMap<>();
        for(Class<?> z :clazz){
            if(!(z==null)){
                Object t = z.newInstance();
                List<Method> m =Arrays.stream(t.getClass().getDeclaredMethods()).toList();
                try {
                    for (Method met:m) {
                        map.put(met.getName(),null);
                        met.setAccessible(true);
                        met.invoke(t,b);
                    }
                }
                catch (InvocationTargetException e){
                    if(e.getCause() instanceof InvalidParameterSpecException){
                        map.put(e.getCause().getStackTrace()[0].getMethodName(),(InvalidParameterSpecException)e.getCause());
                    }else throw  new RuntimeException(e);
                }
                catch (Exception e){
                    throw  new RuntimeException(e);
                }
                System.out.println(map);
            }
        }

    }

}
