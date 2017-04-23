package concurrency;

import java.io.IOException;

class UnresponsiveUI {
	private volatile double d = 1;

	public UnresponsiveUI() throws Exception {
		// TODO Auto-generated constructor stub
		while (d > 0) {
			d = d + (Math.PI + Math.E) / d;
		}
		System.in.read();// Never gets here
	}
}

public class ResponsiveUI extends Thread {
	private static volatile double d = 1;

	public ResponsiveUI() {
		// TODO Auto-generated constructor stub
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			d = d + (Math.PI + Math.E) / d;
		}
	}

	public static void main(String[] args) throws IOException {
		new ResponsiveUI();
		while (true) {
			System.in.read();
			System.out.println(d);
		}
	}

}
