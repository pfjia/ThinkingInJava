package concurrency;

// Objects that are expensive to create
public class Fat {
	private volatile double d;// Prevent optimization
	private static int counter = 0;
	private final int id = counter++;

	public Fat() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 1000; i++) {
			d += (Math.PI + Math.E) / (double) i;
		}
	}

	public void operation() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fat id: " + id;
	}

}
