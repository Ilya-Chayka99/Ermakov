package ru.chay.spring;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class Collect {
    @SneakyThrows
    public static Map<String,Object> collect(Class<?> ...classes) {
        Map<String,Object> collect =new HashMap<>();
        for(Class<?> aClass:classes){
            List<Method> methods = new ArrayList<>(Arrays.asList(aClass.getDeclaredMethods()));
            List<Method> waitMethods = new CopyOnWriteArrayList<>();
            Object curObj = aClass.newInstance();
            for(Method aMethod:aClass.getDeclaredMethods()){
                aMethod.setAccessible(true);
                if(aMethod.isAnnotationPresent(Invoke.class) && aMethod.getReturnType()!=void.class){
                    if(aMethod.getParameterTypes().length==0){
                        collect.put(aMethod.getName(),aMethod.invoke(curObj));
                    }else waitMethods.add(aMethod);
                }
            }
            int curSize;
            do{
                curSize=waitMethods.size();
                for(Method aMethod:waitMethods){
                    List<Object> curPars = new ArrayList<>();
                    List<Parameter> pars =Arrays.asList(aMethod.getParameters());
                    for(Parameter par:pars){
                        for(Object obj:collect.values()){
                            if(obj.getClass() == par.getType()){
                                curPars.add(obj);
                                break;
                            }
                        }
                    }
                    if(curPars.size()!=pars.size()) throw new RuntimeException("No args");
                    collect.put(aMethod.getName(),aMethod.invoke(curObj,curPars.toArray()));
                    waitMethods.remove(aMethod);
                }
            }while (curSize!=waitMethods.size());

        }
        return collect;
    }
}
