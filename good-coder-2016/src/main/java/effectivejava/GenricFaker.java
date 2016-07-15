package effectivejava;

import java.util.HashSet;
import java.util.Set;

/**
 * @author long.yl.
 * @Date 2016/3/30
 */
public class GenricFaker {
    public void print(Set<? extends GenricFaker> set) {
        set.add(null);
    }

    static class Stack<T extends GenricFaker> {
        public void doStack(T t) {
            t.print(new HashSet<GenricFaker>());
        }
    }
}
