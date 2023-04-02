package ru.chay.spring.PostProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CaheHandler implements InvocationHandler {
    private Object obj;
    Map<Method,Object> cache = new HashMap<>();
    Map<Field,Object> fieldss = new HashMap<>();

    public CaheHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(fieldss.isEmpty()){
            Field[] fields =obj.getClass().getDeclaredFields();
            for(Field f:fields){
                f.setAccessible(true);
                this.fieldss.put(f,f.get(obj));
            }
        }
        for (Field f:fieldss.keySet()){
            f.setAccessible(true);
            if(f.get(obj).equals(fieldss.get(f))) continue;
            Field[] fields =obj.getClass().getDeclaredFields();
            for(Field ff:fields){
                ff.setAccessible(true);
                this.fieldss.put(ff,ff.get(obj));
            }
            System.out.println("Вызов");
            method.setAccessible(true);
            cache.clear();
            cache.put(method,method.invoke(obj,args));
            break;
        }
        if(!cache.containsKey(method)){
            method.setAccessible(true);
            cache.put(method,method.invoke(obj,args));
        }
        System.out.println("Кэш");
        return cache.get(method);
    }
}
