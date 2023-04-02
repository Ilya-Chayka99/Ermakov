package ru.chay.spring.PostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.chay.spring.ToStringg;
import ru.chay.spring.TrafficLight.Color;

import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

@Component
public class ToStringBeatPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(ToStringg.class)){
            return  Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),new NewToStringPro(bean));
        }
        return bean;
    }
}
