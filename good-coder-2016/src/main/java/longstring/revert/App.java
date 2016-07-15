package longstring.revert;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author long.yl.
 * @Date 2016/6/3
 */
public class App {
    public static void execute(final Task task, int group, String str) throws InterruptedException {
        final String[] strings = new String[group];
        for (int i = 0; i < group; i++) {
            strings[i] = str.substring(i * (str.length() / group), (i + 1) * ((str.length() / group)));
        }
        System.out.println(Arrays.toString(strings));
        final StringBuilder result = new StringBuilder();

        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(group);
        final ExecutorService service = Executors.newFixedThreadPool(group);

        for (final AtomicInteger i = new AtomicInteger(0); i.get() < group; i.incrementAndGet()) {
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        result.append(task.execute(strings[i.get()]));
                    } catch (Exception e) {

                    } finally {
                        end.countDown();
                    }
                }
            };
            service.submit(runner);
        }

        begin.countDown();
        end.await();
        service.shutdown();
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        final String str = "abcdefghijklmnopqrstuvwxyz";
        int group = 6;
        Task task = new StringRevertTask();
        App.execute(task, group, str);
    }
}
