package concurrency;

/**
 * Inheriting directly from the Thread class
 * 
 * @author pfjia
 *
 */
public class SimpleThread extends Thread {
	private int countDown = 5;
	private static int threadCount = 0;

	public SimpleThread() {
		// TODO Auto-generated constructor stub
		super(Integer.toString(++threadCount));
		start();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "#" + getName() + "(" + countDown + "), ";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.print(this);
			if (--countDown == 0) {
				System.out.println();
				return;
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new SimpleThread();
		}
	}

}
