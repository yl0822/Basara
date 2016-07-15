package taskqueue;

import java.util.LinkedList;

/**
 * @author long.yl.
 * @Date 2016/6/18
 */
public class EmailTaskProducer implements TaskProducer<TimeKillerTask> {

    private static LinkedList<TimeKillerTask> taskQueue;

    static {
        taskQueue = new LinkedList<>();
    }

    @Override
    public synchronized void addTask(TimeKillerTask task) {
        synchronized (taskQueue) {
            taskQueue.addFirst(task);
            taskQueue.notifyAll();
        }
    }

    @Override
    public TimeKillerTask getTask() {
        return taskQueue.pop();
    }

    @Override
    public boolean hasNext() {
        return !taskQueue.isEmpty();
    }

    @Override
    public int howMany() {
        return taskQueue.size();
    }
}
