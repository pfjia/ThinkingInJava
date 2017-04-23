package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Meal {
	private final int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Meal " + orderNum;
	}
}

class WaitPerson implements Runnable {
	public Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();
	private Restaurant restaurant;

	public WaitPerson(Restaurant restaurant) {
		// TODO Auto-generated constructor stub
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {

				lock.lock();
				try {
					while (restaurant.meal == null) {
						condition.await();
					}
				} finally {
					lock.unlock();
				}

				System.out.println("Waitperson got " + restaurant.meal);

				restaurant.chef.lock.lock();
				try {
					restaurant.meal = null;
					restaurant.chef.condition.signalAll();
				} finally {
					restaurant.chef.lock.unlock();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("WaitPerson interrupted");
		}
	}
}

class Chef implements Runnable {
	public Lock lock = new ReentrantLock();
	public Condition condition = lock.newCondition();
	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant restaurant) {
		// TODO Auto-generated constructor stub
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {

				lock.lock();
				try {
					while (restaurant.meal != null) {
						condition.await();
					}

				} finally {
					lock.unlock();
				}

				// produce an item in nextp
				if (++count == 10) {
					System.out.println("Out of food,closing");
					restaurant.exec.shutdownNow();
					return;
				}
				System.out.println("Order up!");

				restaurant.waitPerson.lock.lock();
				try {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.condition.signalAll();
				} finally {
					restaurant.waitPerson.lock.unlock();
				}

				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}
}

public class Restaurant {
	Meal meal;
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	ExecutorService exec = Executors.newCachedThreadPool();

	public Restaurant() {
		// TODO Auto-generated constructor stub
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
}
