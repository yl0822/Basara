package concurrent.future.cache;

import java.util.concurrent.*;

/**
 * @author long.yl.
 * @Date 2016/6/3
 */
public class Cache<K, V> {

	ConcurrentMap map = new ConcurrentHashMap();

	Executor executor = Executors.newFixedThreadPool(8);

	public V get(final K key) {

		FutureTask f = (FutureTask) map.get(key);

		if (f == null) {

			Callable c = new Callable() {

				public V call() {

					// return value associated with key
					return null;

				}

			};

			f = new FutureTask(c);

			FutureTask old = (FutureTask) map.putIfAbsent(key, f);

			if (old == null)

				executor.execute(f);

			else

				f = old;

		}

		try {
			return (V) f.get();
		} catch (Exception e) {

		}
		return null;
	}
}
