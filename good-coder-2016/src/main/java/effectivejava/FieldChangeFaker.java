package effectivejava;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author long.yl.
 * @Date 2016/3/30
 */
public class FieldChangeFaker {

    public static void main(String[] args) throws Throwable {
        Foo foo = new Foo();
        foo.setName("yl");
        System.out.println(foo);
        Field field = foo.getClass().getDeclaredField("name");
        field.setAccessible(true);
        field.set(foo, "yanglong");
        System.out.println(foo);
        Method method = foo.getClass().getDeclaredMethod("getName");
        method.setAccessible(true);
        method.invoke(foo);
        System.out.println(foo);
    }

    static class Foo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Foo{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
