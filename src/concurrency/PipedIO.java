package concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Using pipes for inter-task I/O

class Sender implements Runnable {
	private Random rand = new Random(47);
	private PipedWriter out = new PipedWriter();

	public PipedWriter getPipedWriter() {
		return out;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				for (char c = 'A'; c <= 'z'; c++) {
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				}
			}
		} catch (InterruptedException e) {
			System.out.println(e + " Sender sleep interrupted");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e + " Sender write exception");
		}
	}
}

class Receiver implements Runnable {
	private PipedReader in;

	public Receiver(Sender sender) throws IOException {
		// TODO Auto-generated constructor stub
		in = new PipedReader(sender.getPipedWriter());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				// Blocks until characters are there
				System.out.println("Read: " + (char) in.read() + ", ");
			}
		} catch (IOException e) {
			System.out.println(e + " Receiver read exception");
		}
	}
}

public class PipedIO {
	public static void main(String[] args) throws IOException,
			InterruptedException {
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(sender);
		exec.execute(receiver);
		TimeUnit.SECONDS.sleep(50);
		exec.shutdownNow();
	}

}
