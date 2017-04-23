package generics;

class Manipulator<T> {
	private T obj;

	public Manipulator(T x) {
		obj = x;
	}

	public void manipulate() {
		// The method f() is undefined for the type T
		// obj.f();
	}
}

public class Manipulation {
	public static void main(String[] args) {
		HasF hf = new HasF();
		Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
		manipulator.manipulate();
	}
}
