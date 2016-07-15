package question.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author long.yl.
 * @Date 2016/6/22
 */
public class ListThreadQuestion {
    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        final ListThreadQuestion question = new ListThreadQuestion();

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future ret1 = service.submit(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100; j++) {
                    question.add(j);
                }
            }
        });

        Future ret2 = service.submit(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 100; j++) {
                    question.add(j);
                }
            }
        });

        service.shutdown();

        // 在线程池已被关闭的情况下继续添加任务，会抛出RejectedExecutionException
        // 线程池队列已满继续添加任务也会抛出上述异常
//        Future ret3 = service.submit(new Runnable() {
//            @Override
//            public void run() {
//                for (int j = 0; j < 100; j++) {
//                    question.add(j);
//                }
//            }
//        });
        ret1.get();
        ret2.get();
        while (ret1.isDone() && ret2.isDone()) {
            System.out.println("-----------");
            System.out.println(Arrays.toString(question.list.toArray()));
            break;
        }
    }

    public void add(int i) {
        if (!list.contains(i)) {
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (Exception e) {

            }
            list.add(i);
        }
    }
}
