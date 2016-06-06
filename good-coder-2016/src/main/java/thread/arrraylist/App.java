package thread.arrraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author long.yl.
 * @Date 2016/6/6
 */
public class App {
    public static void main(String[] args) {
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new Integer(i * 10));
        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (list.get(i) == 100){
                        try {
                            Thread.currentThread().sleep(300);
                        }catch (Exception e){

                        }
                        System.out.println(list.get(i));
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.remove(i);
                }
            }
        });
//        thread1.start();
//        thread2.start();
        int[] ints = new int[10];
        ints[11] = 2;
        System.out.println(ints[10]);
    }
}
