package generics;

public class ArrayOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;

	public static void main(String[] args) {
		// java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to
		// [Lgenerics.Generic;
		// gia = (Generic<Integer>[]) new Object[SIZE];

		gia = new Generic[SIZE];
		System.out.println(gia.getClass().getSimpleName());

		gia[0] = new Generic<Integer>();

		// Type mismatch: cannot convert from Object to Generic<Integer>
		// gia[1] = new Object();

		// Type mismatch: cannot convert from Generic<Double> to
		// Generic<Integer>
		// gia[2] = new Generic<Double>();

	}
}
