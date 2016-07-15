package taskqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author long.yl.
 * @Date 2016/6/18
 */
public class TaskConsumer {

    private static ExecutorService executor;

    static {
        executor = Executors.newCachedThreadPool();
    }

    public void killTask(TaskProducer producer) {
        while (true) {
            if (producer.hasNext()) {
                executor.submit(producer.getTask());
            } else {
                continue;
            }
        }
    }

    public void close() {
        System.out.println("executor 被关闭 ... ");
        executor.shutdown();
    }

}
