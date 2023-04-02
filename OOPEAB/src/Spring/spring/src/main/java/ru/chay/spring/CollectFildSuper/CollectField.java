package ru.chay.spring.CollectFildSuper;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CollectField {
    @SneakyThrows
    public static String toStringField(Object obj) {
        Class<?> b =obj.getClass();
        Class<?> b1=b;
        Map<String,Object> f= new HashMap<>();
        while (b!=Object.class){
            Arrays.stream(b.getDeclaredFields()).forEach(field -> {
                field.setAccessible(true);
                try {
                    f.put(field.getName().toString(),field.get(obj));
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
