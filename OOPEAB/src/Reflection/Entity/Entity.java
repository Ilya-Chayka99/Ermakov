package src.Reflection.Entity;

import src.Reflection.Prim;
import src.Reflection.ToString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public abstract class Entity{
    @Override
    public String toString() {
        Class<?> b =this.getClass();
        Class<?> b1=b;
        Map<String,Object> f= new HashMap<>();
        while (b!=Object.class && b!= Entity.class){
            Arrays.stream(b.getDeclaredFields()).forEach(field -> {
                field.setAccessible(true);
                try {
                    ToString annotation =field.getDeclaredAnnotation(ToString.class);
                    if(annotation!=null){
                        if(annotation.value()!= Prim.NO){
                            f.put(field.getName().toString(),field.get(this));
                        }
                    }
                    else  f.put(field.getName().toString(),field.get(this));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
            b1=b;
            b=b.getSuperclass();
        }
        return b1.getSimpleName()+f;
    }
}
