package ru.chay.spring.PostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.chay.spring.Valid.InspectObj;
import ru.chay.spring.Valid.Validate;
@Component
public class ValidateBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    InspectObj inspectObj;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean.getClass().isAnnotationPresent(Validate.class)){
            inspectObj.validate(bean);
        }
        return bean;
    }
}
