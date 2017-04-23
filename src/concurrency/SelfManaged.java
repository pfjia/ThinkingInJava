package concurrency;

public class SelfManaged implements Runnable {
	private int countDown = 5;
	private Thread t = new Thread(this);

	public SelfManaged() {
		// TODO Auto-generated constructor stub
		t.start();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Thread.currentThread().getName() + "(" + countDown + ")";
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
			new SelfManaged();
		}
	}

}
