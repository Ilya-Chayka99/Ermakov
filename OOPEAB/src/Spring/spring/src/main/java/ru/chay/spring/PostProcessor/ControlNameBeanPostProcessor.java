package ru.chay.spring.PostProcessor;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Component
public class ControlNameBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] field = bean.getClass().getDeclaredFields();
        for(Field f:field){
            if(f.getName().equals("name") && f.getType()== String.class){
                f.setAccessible(true);
                if(f.get(bean)==null) f.set(bean,"Vasia");
            }
        }
        return bean;
    }
}
