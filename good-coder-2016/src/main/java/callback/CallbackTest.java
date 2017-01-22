package callback;

import java.util.Optional;
import java.util.concurrent.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by long.yl on 2017/1/22.
 */
public class CallbackTest {

	private final StringBuilder local = new StringBuilder("yanglong");

	@Before
	public void init() {
		System.out.println(local);
	}

	@Test
	public void testWithResp() {
		FutureTask futureTask = AsyncTask.executeWithResp(new CallBack() {
			@Override
			public void callback() {
				local.append("_callback");
			}
		});
		try {
			if (new FutureTaskEnhance(futureTask).get().isPresent()) {
				System.out.println("main Thread : async task done ");
				System.out.println(local);
			}
		} catch (Exception e) {

		}
	}

	@Test
	public void testWithInitLoop() {
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		AsyncTask.executeWithoutResp(new CallBack() {
			@Override
			public void callback() {
				local.append("_callback");
				countDownLatch.countDown();
			}
		});
		while (1 == 1) {
			if (local.toString().equals("yanglong_callback")) {
				System.out.println("main Thread : async task done ");
				break;
			}
		}
		System.out.println(local);
	}

	@Test
	public void testWithCountDownLantch() {
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		AsyncTask.executeWithoutResp(new CallBack() {
			@Override
			public void callback() {
				local.append("_callback");
				countDownLatch.countDown();
			}
		});
		try {
			countDownLatch.await();
			System.out.println("main Thread : async task done ");
		} catch (Exception e) {

		}
		System.out.println(local);
	}

	interface CallBack {
		void callback();
	}

	static class AsyncTask {

		private static ExecutorService executorService;

		static {
			executorService = Executors.newFixedThreadPool(2);
		}

		public static FutureTask executeWithResp(final CallbackTest.CallBack callBack) {
			FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
				@Override
				public String call() throws Exception {
					try {
						Thread.sleep(3000);
						System.out.println("async Thread : task done ");
					} catch (Exception e) {

					} finally {
						callBack.callback();
					}
					return "yanglong_callback";
				}
			});
			executorService.execute(futureTask);
			return futureTask;
		}

		public static void executeWithoutResp(final CallbackTest.CallBack callBack) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
						System.out.println("async Thread : task done ");
					} catch (Exception e) {

					} finally {
						callBack.callback();
					}
				}
			});
		}
	}

	static class FutureTaskEnhance {
		FutureTask futureTask;

		public FutureTaskEnhance(FutureTask futureTask) {
			this.futureTask = futureTask;
		}

		public Optional<Object> get() throws Exception {
			return Optional.of(futureTask.get());
		}
	}

}
