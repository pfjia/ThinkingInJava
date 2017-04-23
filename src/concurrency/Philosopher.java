package concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

// A dining philosopher
public class Philosopher implements Runnable {
	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int ponderFactor;
	private Random rand = new Random(47);

	public Philosopher(Chopstick left, Chopstick right, int id, int ponder) {
		// TODO Auto-generated constructor stub
		this.left = left;
		this.right = right;
		this.id = id;
		this.ponderFactor = ponder;
	}

	private void pause() throws InterruptedException {
		if (ponderFactor == 0) {
			return;
		}
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor) * 250);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Philosopher " + id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (!Thread.interrupted()) {
				System.out.println(this + " thinking");
				pause();

				// Philosopher becomes hungry
				System.out.println(this + " grabbing right");
				right.take();
				Thread.sleep(100);
				System.out.println(this + " grabbing left");
				left.take();
				System.out.println(this + " eating");
				pause();
				right.drop();
				left.drop();
			}
		} catch (InterruptedException e) {
			System.out.println(this + " exiting via interrupt");
		}
	}
}
