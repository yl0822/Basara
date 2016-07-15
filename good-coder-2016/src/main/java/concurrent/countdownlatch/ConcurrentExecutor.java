package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author long.yl.
 * @Date 2016/6/2
 */
public class ConcurrentExecutor {

    /**
     * 多次并发执行任务
     *
     * @param task  任务对象
     * @param count 执行次数
     */
    public static void execute(final Task task, int count) throws InterruptedException {
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(count);
        final ExecutorService service = Executors.newFixedThreadPool(count);

        for (int i = 0; i < count; i++) {
            Runnable runner = new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        task.execute();
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
    }

    public static void main(String[] args) throws Exception {
        Task task = new Task() {
            int i = 0;

            @Override
            public void execute() {
                while (i < 100) {
                    try {
                        Thread.currentThread().sleep(300);
                    } catch (Exception e) {

                    }
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                }
            }
        };
        ConcurrentExecutor.execute(task, 10);
    }
}
