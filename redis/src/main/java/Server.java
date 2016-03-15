/**
 * @author long.yl.
 * @Date 2016/3/14
 */
public interface Server<T> {
	boolean set(String key, T value);

	T get(String key);
}
