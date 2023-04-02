package src.Reflection.Reset;

import src.Reflection.Default;

import java.lang.reflect.Field;

public class Reset {

    public static void reset(Object... ob) throws Exception {
        for (Object o : ob) {
//            if (!o.getClass().isAnnotationPresent(Default.class)) continue;
//            Field[] fields = o.getClass().getDeclaredFields();
//            Class<?> c = o.getClass().getDeclaredAnnotation(Default.class).value();
//            Object cob = c.newInstance();
//            for (Field f : fields) {
//                f.setAccessible(true);
//                for (Field filed : cob.getClass().getDeclaredFields()) {
//                    if (filed.getType() == f.getType()) {
//                        f.set(o, filed.get(cob));
//                    }
//                }
//            }

        }
    }
}
