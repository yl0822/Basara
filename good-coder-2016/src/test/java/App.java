import org.junit.experimental.theories.internal.BooleanSupplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by long.yl on 2016/7/11.
 */
public class App {

	public static void main(String[] args) {
        List<Acer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Acer acer = new Acer();
            acer.setAge(i);
            acer.setName("acer_"+i);
            list.add(acer);
        }
        Acer acer1= (Acer) null;
        System.out.println(acer1);
        System.out.println(Arrays.toString(list.toArray()));
        for (Acer acer : list) {
            acer.setName(acer.getName() + "_ext");
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
    static class Acer{
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Acer{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
