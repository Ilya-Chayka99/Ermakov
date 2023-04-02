package ru.chay.spring.Valid;



import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.spec.InvalidParameterSpecException;
import java.util.*;
@Component
public class InspectObj {
    @Autowired
    ApplicationContext context;
    @SneakyThrows
    public void validate(Object b){
        String[] clazz=null;
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
        for(String z :clazz){
            if(!(z==null)){
                Object t = context.getBean(z);
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
                System.out.println("1111111111111111111111111111111111111111111111111111111111111111111111111");
                System.out.println(map);
            }
        }

    }

}
