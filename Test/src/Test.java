import com.sun.org.apache.xpath.internal.operations.String;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by xms on 2017/8/27.
 */
public class Test {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        B b = new B();
        Class clazz =  b.getClass();
        Class c=clazz.getSuperclass();
        Method[] method = c.getDeclaredMethods();
        AccessibleObject.setAccessible(method,true);
        for (Method m :method){
            System.out.println(m.getName());
            m.invoke(new String());
        }
    }
}
