package camp.test.gson;

import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class GsonTest {

	@Test
	public void testMultiThread() throws Exception {
		final Gson gson = new Gson();

		for(int requst = 0; requst < 4000; requst++ ) {

			final CountDownLatch startLatch = new CountDownLatch(1);
			final CountDownLatch finishLatch = new CountDownLatch(10);
			final AtomicBoolean failed = new AtomicBoolean(false);

			ExecutorService executor = Executors.newFixedThreadPool(30);

			for (int taskCount = 0; taskCount < 30; taskCount++) {
				executor.execute(new Runnable() {
					public void run() {
						// System.out.println("# " + Thread.currentThread().getName() );

						Hello myObj = new Hello("world");
						try {
							startLatch.await(); // 하나의 Task가 끝날때까지 대기

							for (int i = 0; i < 10; i++) {
								gson.toJson(myObj);
							}
						} catch (Exception e) {
							e.printStackTrace();
							failed.set(true); // 실패
						} finally {
							finishLatch.countDown(); // 처리완료
						}
					}
				});
			}

			startLatch.countDown(); // Task 완료
			finishLatch.await(); // 다른 Thread 처리까지 대기

			assertFalse(failed.get());
			executor.shutdown();
		}
	}

	@SuppressWarnings("unused")
	private class Hello {
		private String message;

		public Hello(String message) {
			this.message = message;
		}
	}
}