package generics;

class GenericBase<T> {
	private T element;

	public void set(T arg) {
		arg = element;
	}

	public T get() {
		return element;
	}
}

class Derived1<T> extends GenericBase<T> {

}

// GenericBase is a raw type. References to generic type GenericBase<T> should
// be parameterized
class Derived2<T> extends GenericBase {

}

// The type Derived3 cannot extend or implement GenericBase<?>. A supertype may
// not specify any wildcard(Í¨Åä·û)
// class Derived3 extends GenericBase<?> {
//
// }

public class ErasureAndInherriatance {

	// @SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Derived2 d2 = new Derived2();
		Object obj = d2.get();
		// warning:Type safety: The method set(Object) belongs to the raw type
		// GenericBase. References to generic type GenericBase<T> should be
		// parameterized
		d2.set(obj);
	}

}
