package effectivejava;

import java.lang.annotation.*;

/**
 * @author long.yl.
 * @Date 2016/3/30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Geek {

    int years() default 25;
}
