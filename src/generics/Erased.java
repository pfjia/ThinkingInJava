package generics;

public class Erased<T> {
	private final int SIZE = 100;

	public void f(Object arg) {
		// Cannot perform instanceof check against type parameter T. Use its
		// erasure Object instead since further generic type information will be
		// erased at runtime
		// if (arg instanceof T) {
		// }

		// Cannot instantiate the type T
		// T var = new T();

		// Cannot create a generic array of T
		// T[] array = new T[SIZE];

		T[] array = (T[]) new Object[SIZE];
	}
}
