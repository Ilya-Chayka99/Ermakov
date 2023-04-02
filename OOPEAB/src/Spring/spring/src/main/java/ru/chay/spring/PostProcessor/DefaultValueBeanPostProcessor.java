package ru.chay.spring.PostProcessor;


import lombok.SneakyThrows;
import lombok.experimental.NonFinal;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.chay.spring.Collect;
import ru.chay.spring.CollectFildSuper.CollectField;
import ru.chay.spring.Default;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
public class DefaultValueBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    ApplicationContext context;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    @SneakyThrows
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            Field[] fields = bean.getClass().getDeclaredFields();
            for (Field f : fields) {
                if (bean.getClass().isAnnotationPresent(Default.class)) {
                    f.setAccessible(true);
                    String c = bean.getClass().getDeclaredAnnotation(Default.class).value();
                    Collect.collect(context.getBean(c).getClass()).forEach((x, y) -> {
                        if (y.getClass() == f.getType()) {
                            try {
                                f.set(bean, y);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
                if (!f.isAnnotationPresent(Default.class)) continue;
                String c = f.getDeclaredAnnotation(Default.class).value();
                f.setAccessible(true);
                f.set(bean, c);
            }
        return bean;
    }
}
