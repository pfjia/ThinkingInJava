package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// A task to check a resource out of a pool
class CheckoutTask<T> implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private Pool<T> pool;

	public CheckoutTask(Pool<T> pool) {
		// TODO Auto-generated constructor stub
		this.pool = pool;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			T item = pool.checkOut();
			System.out.println(this + " checked out " + item);
			TimeUnit.SECONDS.sleep(1);
			System.out.println(this + " checking in " + item);
			pool.checkIn(item);
		} catch (InterruptedException e) {

		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CheckoutTask " + id + " ";
	}
}

public class SemaphoreDemo {
	final static int SIZE = 25;

	public static void main(String[] args) throws InterruptedException {
		final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < SIZE; i++) {
			exec.execute(new CheckoutTask<Fat>(pool));
		}
		System.out.println("All CheckoutTasks created");
		List<Fat> list = new ArrayList<Fat>();
		for (int i = 0; i < SIZE; i++) {
			Fat f = pool.checkOut();
			System.out.println(i + ": main() thread checked out");
			f.operation();
			list.add(f);
		}

		Future<?> blocked = exec.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					// Semaphore prevents additional checkout,so call it blocked
					pool.checkOut();
				} catch (InterruptedException e) {
					System.out.println("checkOut() Interrupted");
				}
			}
		});
		TimeUnit.SECONDS.sleep(2);
		blocked.cancel(true);// Break out of blocked call
		System.out.println("Checking in objects int " + list);
		for (Fat f : list) {
			pool.checkIn(f);
		}
		for (Fat f : list) {
			pool.checkIn(f);// Second checkIn ignored
		}
		exec.shutdown();
	}
}
