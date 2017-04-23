package concurrency;

import static net.mindview.util.Print.print;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			print("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			print("Exiting via InterruptedException");
		} finally {
			print("This is should always run?");
		}
	}
}

public class DaemonsDontRunFinally {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new ADaemon());
		// t.setDaemon(true);
		t.start();
		TimeUnit.MILLISECONDS.sleep(100);
	}
}
