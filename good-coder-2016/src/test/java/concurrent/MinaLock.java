package concurrent;

/**
 * @author long.yl.
 * @Date 2016/3/21
 */
public class MinaLock {
    public long start = 1;

    public static void main(String[] args) {
        MinaLock minaLock = new MinaLock();
        minaLock.doRun();
    }

    public void doRun() {
        new Thread(new Runner()).start();
        new Thread(new Runner()).start();
    }

    class Runner implements Runnable {
        @Override
        public void run() {
            while (start < 10000) {
                start = start + 1;
                System.out.println(Thread.currentThread().getName() + "num: " + start);
            }
        }
    }
}
