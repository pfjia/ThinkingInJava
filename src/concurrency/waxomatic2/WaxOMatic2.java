package concurrency.waxomatic2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Using Lock and Condition objects

class Car {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	// true:已经上蜡
	// false:还未上蜡
	private boolean waxOn = false;

	public void waxed() {
		lock.lock();
		try {
			waxOn = true;// Ready to buff
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void buffed() {
		lock.lock();
		try {
			waxOn = false;
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public void waitForWaxing() throws InterruptedException {
		lock.lock();
		try {
			while (waxOn == false) {
				condition.await();
			}

		} finally {
			lock.unlock();
		}
	}

	public void waitForBuffing() throws InterruptedException {
		lock.lock();
		try {
			while (waxOn == true) {
				condition.await();
			}
		} finally {
			lock.unlock();
		}
	}
}

class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car car) {
		// TODO Auto-generated constructor stub
		this.car = car;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				System.out.println("car正在上蜡");
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println("car上蜡完毕");
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("WaxOn interrupted");
		}
	}
}

class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car car) {
		// TODO Auto-generated constructor stub
		this.car = car;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				System.out.println("car正在打光");
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println("car打光完毕");
				car.buffed();

			}
		} catch (InterruptedException e) {
			System.out.println("WaxOff interrupted");
		}
	}
}

public class WaxOMatic2 {
	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOn(car));
		exec.execute(new WaxOff(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
