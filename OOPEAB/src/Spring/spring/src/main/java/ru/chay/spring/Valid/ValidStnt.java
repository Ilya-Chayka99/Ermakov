package ru.chay.spring.Valid;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import ru.chay.spring.Student;

import java.lang.reflect.Field;
import java.security.spec.InvalidParameterSpecException;
@Component
public class ValidStnt {

    @SneakyThrows
    public void test(Student h) {
        Field f = h.getClass().getDeclaredField("zz");
        f.setAccessible(true);
        if(f.get(h)=="z"){
            throw new InvalidParameterSpecException("Рост человека не может быть больше 250см))");
        }


    }
}
