package ru.chay.spring.PostProcessor;

import ru.chay.spring.CollectFildSuper.CollectField;
import ru.chay.spring.ToStringg;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NewToStringPro implements InvocationHandler {
    private Object object;
    public NewToStringPro(Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("toString")){
            if(object.getClass().isAnnotationPresent(ToStringg.class))
                return CollectField.toStringField(object);
        }
        return method.invoke(proxy,args);
    }
}
