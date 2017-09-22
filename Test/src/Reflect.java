import java.lang.annotation.*;

/**
 * Created by xms on 2017/9/16.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Reflect {
    String name() default "";
}
