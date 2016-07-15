import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author long.yl.
 * @Date 2016/3/16
 */
public final class FinalFieldTest {

    public static final String name5 = "eee";
    private static String name2 = "bbb";

    private final String name3 = "ccc";

    public String name4 = "ddd";
    private String name = "aaa";

    /**
     * 反射无法修改static final属性，但可以修改static或final属性，private无影响
     */
    @Test
    public void dotest() {
        try {
            FinalFieldTest test = new FinalFieldTest();
            System.out.println(test);
            for (Field field : test.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                field.set(test, "111");
            }
            System.out.println(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "FinalFieldTest{" +
                "name='" + name + '\'' +
                "name='" + FinalFieldTest.name2 + '\'' +
                ", name3='" + name3 + '\'' +
                ", name4='" + name4 + '\'' +
                ", name5='" + name5 + '\'' +
                '}';
    }
}
