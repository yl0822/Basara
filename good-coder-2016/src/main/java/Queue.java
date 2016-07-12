import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by long.yl on 2016/7/11.
 */
public class Queue<T> {
    private LinkedList<T> queue;

    private int capcity;

    private int size;

    public Queue(int capcity){
        this.capcity = capcity;
        size = 0;
        queue = new LinkedList<>();
    }

    public void put(T t){
        if (queue.size() > 100){
            return;
        }
        queue.add(t);
    }

    public T get(){
        if (queue.size() <= 0){
            return null;
        }
        return queue.pop();
    }
}
