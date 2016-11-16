import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by long.yl
 * Created in 2016/11/16
 * Created on Basara_PACKAGE_NAME
 */
public class Java8Test {
    public static void main(String args[]){

        List<String> list = Arrays.asList("aaa","bbb","ccc","abc");

        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value n has.
        System.out.println("Print all numbers:");
        //pass n as parameter
        eval(list, n->true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n%2 comes to be zero
        System.out.println("Print even numbers:");
        eval(list, n-> n.startsWith("a") );
        for (String s : list) {
            if (s.startsWith("a")) {
                System.out.println(s + "-");
            }
        }

        // Predicate<Integer> predicate2 = n -> n > 3
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n is greater than 3.
        System.out.println("Print numbers greater than 3:");
        eval(list, n-> n.contains("b") );
        for (String s : list) {
            if (s.contains("b")) {
                System.out.println(s + "-");
            }
        }
    }

    public static void eval(List<String> list, Predicate<String> predicate) {
        for(String n: list)  {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}
