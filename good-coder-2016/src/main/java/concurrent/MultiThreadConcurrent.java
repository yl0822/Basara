package concurrent;

/**
 * Created by long.yl on 2016/7/9.
 */
public class MultiThreadConcurrent {
    Thread[] threads;

    int size;

    volatile boolean start = false;

    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public MultiThreadConcurrent(int size) {
        this.size = size;
        threads = new MyThread[size];
    }

    public void concurrentDo(){
        while (start){
            for (Thread thread : threads) {
                thread.start();
            }
        }
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public static void main(String[] args) throws Exception {
        MultiThreadConcurrent concurrent = new MultiThreadConcurrent(10);
        concurrent.concurrentDo();
        System.out.println("main thread sleep 3s");
        Thread.currentThread().sleep(3000);
        concurrent.setStart(true);
    }
}
