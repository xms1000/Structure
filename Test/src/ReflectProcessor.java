import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xms on 2017/9/16.
 */
public class ReflectProcessor {
    public void parseMethod(final Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
        Method[] methods = clazz.getDeclaredMethods();
        for (final Method method : methods) {
            final Reflect my= method.getAnnotation(Reflect.class);
            if(my!=null){
                method.invoke(obj,my.name());
            }
        }
    }
}
