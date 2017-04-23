package generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
	private Class<T> kind;
	private T t;

	public ArrayMaker(Class<T> kind) {
		this.kind = kind;
		// if (kind instanceof T) {
		//
		// }

		// Cannot instantiate the type T
		// T t = new T();
		// Illegal class literal for the type parameter T
		// System.out.println(T.class);
	}

	// Type safety: Unchecked cast from Object to T[]
	T[] create(int size) {
		return (T[]) Array.newInstance(kind, size);
	}

	public static void main(String[] args) {
		ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
		String[] stringArray = stringMaker.create(9);
		System.out.println(Arrays.toString(stringArray));
	}

}
