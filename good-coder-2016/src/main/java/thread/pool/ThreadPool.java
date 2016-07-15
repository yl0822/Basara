package thread.pool;

import java.util.LinkedList;

/**
 * @author long.yl.
 * @Date 2016/6/2
 */
public class ThreadPool {
    // 线程池大小
    private final int nThreads;

    // 线程池工作者(具体线程)
    private final PoolWorker[] threads;

    // 任务队列
    private final LinkedList queue;

    public ThreadPool(int nThreads) {
        // 初始线程池，并启动线程池里面的线程
        this.nThreads = nThreads;
        queue = new LinkedList();
        threads = new PoolWorker[nThreads];
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    // 提交工作任务，实际将任务放入队列，并通知线程进行消费
    public void execute(Runnable r) {
        synchronized (queue) {
            queue.addLast(r);
            queue.notify();
        }
    }

    /**
     * 伪代码:
     * while (true) {
     * <p/>
     * if (no tasks)
     * <p/>
     * wait for a task;
     * <p/>
     * execute the task;
     * <p/>
     * }
     */
    private class PoolWorker extends Thread {
        public void run() {
            Runnable r;
            // 循环取出任务队列里的任务进行消费，如果没有任务，就等待任务到来。
            while (true) {
                //只有被synchronized修饰的方法里面才能调用wait()；wait()之后，对象锁就释放了
                //这一点和sleep()不同，sleep()是不释放的。wait()之后必须要notify()来叫醒。
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException ignored) {
                        }
                    }
                    r = (Runnable) queue.removeFirst();
                }
                try {
                    r.run();
                } catch (RuntimeException e) {
                }
            }
        }
    }
}
