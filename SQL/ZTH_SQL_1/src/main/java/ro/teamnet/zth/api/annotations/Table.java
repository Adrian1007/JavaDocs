package ro.teamnet.zth.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Adi on 28.04.2015.
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)


public @interface Table {
    String name() default "";
}
