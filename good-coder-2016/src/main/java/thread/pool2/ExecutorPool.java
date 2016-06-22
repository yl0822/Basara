package thread.pool2;

import thread.pool.Task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author long.yl.
 * @Date 2016/6/6
 */
public class ExecutorPool {
    //虽然被修饰为final，且没有设置初始值却没有报错，是因为在类加载过程除了准备阶段，还可以在初始化阶段完成赋值（调用构造器），所以可以在构造器中初始化。
    private final int count;

    private final ExecutorService service;

    private final Queue queue;

    public ExecutorPool(int count){
        this.count = count;
        service = Executors.newFixedThreadPool(count);
        // Queue的实现都是用LinkedList
        queue = new LinkedList<>();
    }

    public void execute(Runnable runnable){
        synchronized (queue){
            queue.add(runnable);
            queue.notify();
        }
    }

    // 首先外层while true循环等待task的到来
    // synchronized修饰保证queue的非空判断和gettask操作是同一个线程执行
    // 内层while判断是否有task到来，如果没有将queue设为wait状态，等待queue被notify之后继续下一次判空
    // 如果没有到来则将queue设为wait状态，由于wait状态不会释放锁，所以其他几个线程一直等在synchronized块外面，
    class TaskExecutor implements Runnable {
        @Override
        public void run() {
            Runnable r;
            //保证线程等待中...
            while (true){
                synchronized (queue){
                    while (queue.isEmpty()){
                        try {
                            queue.wait();
                        }catch (Exception e){

                        }
                    }
                    //如果将task.run写在synchronized里面，则会阻塞其他线程继续执行
                    //如果完全放在synchronized外面，则会出现线程安全问题（线程A执行poll之前，线程B进入了非空判断，之后poll被执行导致线程安全问题）
                    //所以这里最好做法是拆分成两部分:在synchronized中将task拿到，放到synchronized外面去执行（poll = remove + run）
                    r = (Runnable)queue.poll();
                }
                try {
                    r.run();
                }catch (Exception e){

                }
            }
        }
    }
}
