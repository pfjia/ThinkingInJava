package concurrency;

import static net.mindview.util.Print.printnb;

import java.util.concurrent.TimeUnit;

/**
 * Daemon threads spawn other daemon threads
 * 
 * @author pfjia
 *
 */

class Daemon implements Runnable {
	private Thread[] t = new Thread[10];

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			printnb("DaemonSpawn " + i + " started, ");
		}
		for (int i = 0; i < t.length; i++) {
			printnb("t[" + i + "].isDaemon()= " + t[i].isDaemon() + ". ");

		}
		while (true) {
			Thread.yield();
		}
	}
}

class DaemonSpawn implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			Thread.yield();
		}
	}
}

public class Daemons {
	public static void main(String[] args) throws Exception {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		printnb("d.isDaemon() = " + d.isDaemon() + ". ");
		TimeUnit.SECONDS.sleep(100);
	}

}