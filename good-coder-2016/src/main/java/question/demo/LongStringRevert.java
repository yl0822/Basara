package question.demo;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author long.yl.
 * @Date 2016/6/22
 */
public class LongStringRevert {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(Arrays.toString(str.toCharArray()));
    }

    public String doRevert(String target) {
        final String[] strings = doSplit(target);
        ExecutorService service = Executors.newCachedThreadPool();
        return null;
    }

    private String[] doSplit(String target) {
        int cpus = Runtime.getRuntime().availableProcessors();
        int length = target.length();
        int segment = length / cpus;
        int left = length % cpus;
        String[] strings = new String[cpus];
        for (int i = 0; i < cpus; i++) {
            if ((i + 1) >= cpus) {
                strings[i] = target.substring(i * segment, (i + 1) * segment - 1 + left);
            } else {
                strings[i] = target.substring(i * segment, (i + 1) * segment - 1);
            }
        }
        return strings;
    }
}
