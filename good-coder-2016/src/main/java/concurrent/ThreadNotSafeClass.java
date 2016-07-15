package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author long.yl.
 * @Date 2016/6/18
 */
public class ThreadNotSafeClass {
    private int view;

    public ThreadNotSafeClass(int view) {
        this.view = view;
    }

    public static void main(String[] args) {
        final ThreadNotSafeClass threadNotSafeClass1 = new ThreadNotSafeClass(0);
        threadNotSafeClass1.addView();
        System.out.println("----------------------------------");
        final ThreadNotSafeClass threadNotSafeClass2 = new ThreadNotSafeClass(0);
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (int i = 0; i < 9; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    threadNotSafeClass2.addView();
                }
            });
        }
        executorService.shutdown();
    }

    public synchronized void addView() {
        for (int i = 0; i < 10; i++) {
            view += i;
        }
        System.out.println(view);
    }
}
