package taskqueue;

/**
 * @author long.yl.
 * @Date 2016/6/18
 */
public interface TaskProducer<T extends Runnable> {

    int howMany();

    boolean hasNext();

    void addTask(T t);

    T getTask();
}
