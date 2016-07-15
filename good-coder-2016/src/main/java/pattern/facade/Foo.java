package pattern.facade;

/**
 * Created by Larry .Yang
 * on 16/3/25 13:55
 * Package: parent_pattern.facade
 */
public class Foo {

    public static long age;

    public static String name = "n";

    public static String desc = "ba";

    public void doMath() {
        //todo domath thing
    }

    public long getAge() {
        return age;
    }

    public String getInfo() {
        return name + desc;
    }
}
