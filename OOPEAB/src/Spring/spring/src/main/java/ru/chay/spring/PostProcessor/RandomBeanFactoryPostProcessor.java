package ru.chay.spring.PostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;
import ru.chay.spring.Config;
import ru.chay.spring.Rand;

@Component
public class RandomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (!beanFactory.containsBean("random")) {
            BeanDefinitionRegistry con = ((BeanDefinitionRegistry) beanFactory);

            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(Rand.class);
            beanDefinition.setLazyInit(false);
            beanDefinition.setAbstract(false);
            beanDefinition.setAutowireCandidate(true);
            MutablePropertyValues mpv = new MutablePropertyValues();
            mpv.add("min",0);
            mpv.add("max",100);
            beanDefinition.setPropertyValues(mpv);
            beanDefinition.setScope("prototype");

            con.registerBeanDefinition("random", beanDefinition);
        }
    }
}
