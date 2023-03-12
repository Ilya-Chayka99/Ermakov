package src.Reflection;

import src.Reflection.InspectObj.HumanTests;
import src.Reflection.InspectObj.HumanTests1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE})
@Validate({HumanTests.class, HumanTests1.class})
public @interface ToString {
    Prim value() default Prim.YES;
}
