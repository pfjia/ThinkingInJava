package concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Creating threads with inner classes
 * 
 * @author pfjia
 *
 */

// Using a named inner class
class InnerThread1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner extends Thread {
		public Inner(String name) {
			// TODO Auto-generated constructor stub
			super(name);
			start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0) {
						return;
					}
					sleep(10);
				}
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return getName() + ": " + countDown;
		}
	}

	public InnerThread1(String name) {
		// TODO Auto-generated constructor stub
		inner = new Inner(name);
	}
}

// Using a anonymous inner class
class InnerThread2 {
	private int countDown = 5;
	private Thread t;

	public InnerThread2(String name) {
		// TODO Auto-generated constructor stub
		t = new Thread(name) {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						System.out.println(this);
						if (--countDown == 0) {
							return;
						}
						sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.println("sleep() interrupted");
				}
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return getName() + ": " + countDown;
			}
		};

		t.start();
	}
}

// Using a named Runnable implementation
class InnerRunnable1 {
	private int countDown = 5;
	private Inner inner;

	private class Inner implements Runnable {
		Thread t;

		public Inner(String name) {
			// TODO Auto-generated constructor stub
			t = new Thread(this, name);
			t.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0) {
						return;
					}
					TimeUnit.MILLISECONDS.sleep(10);
				}
			} catch (InterruptedException e) {
				System.out.println("sleep() interrupted");
			}
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return t.getName() + ": " + countDown;
		}

	}

	public InnerRunnable1(String name) {
		// TODO Auto-generated constructor stub
		inner = new Inner(name);
	}
}

// Using an anonymous Runnable implementation
class InnerRunnable2 {
	private int countDown = 5;
	private Thread t;

	public InnerRunnable2(String name) {
		// TODO Auto-generated constructor stub
		t = new Thread(new Runnable() {

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return Thread.currentThread().getName() + ": " + countDown;
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (true) {
						System.out.println(this);
						if (--countDown == 0) {
							return;
						}
						TimeUnit.MILLISECONDS.sleep(10);
					}
				} catch (InterruptedException e) {
					System.out.println("sleep() interrupted");
				}
			}
		}, name);
		t.start();
	}
}

// A separate method to run some code as a task
class ThreadMethod {
	private int countDown = 5;
	private Thread t;
	private String name;

	public ThreadMethod(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public void runTask() {
		if (t == null) {
			t = new Thread(name) {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						while (true) {
							System.out.println(this);
							if (--countDown == 0) {
								return;
							}
							sleep(10);
						}
					} catch (InterruptedException e) {
						System.out.println("sleep() interrupted");
					}
				}

				@Override
				public String toString() {
					// TODO Auto-generated method stub
					return getName() + ": " + countDown;
				}
			};
			t.start();
		}
	}

}

public class ThreadVariations {
	public static void main(String[] args) {
		new InnerThread1("InnerThread1");
		new InnerThread2("InnerThread2");
		new InnerRunnable1("InnerRunnable1");
		new InnerRunnable2("InnerRunnable2");

		new ThreadMethod("ThreadMethod").runTask();
	}

}
