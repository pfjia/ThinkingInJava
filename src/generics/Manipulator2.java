package generics;

public class Manipulator2<T extends HasF> {
	private T obj;

	public Manipulator2(T x) {
		// TODO Auto-generated constructor stub
		obj = x;
	}

	public void manipulate() {
		obj.f();
	}
}
