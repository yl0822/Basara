package thread.pool;

/**
 * @author long.yl.
 * @Date 2016/6/2
 */
public class App {
    public static void main(String[] args) {
        ThreadPool queue = new ThreadPool(3);
        // 提交工作任务。
        for (int i = 0; i < 50; i++) {
            queue.execute(new Task(i));
        }
    }
}
