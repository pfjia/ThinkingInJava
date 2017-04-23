package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (countDown-- > 0) {
				System.out.print(status());
				// Old-style
				// Thread.sleep(100);
				// Java 1.5/1.6 style
				TimeUnit.MILLISECONDS.sleep(100);
			}
			System.out.println();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
