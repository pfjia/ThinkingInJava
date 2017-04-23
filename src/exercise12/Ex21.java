package exercise12;

class Exception211 extends Exception {
	public Exception211(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
}

class BaseWithException {
	public BaseWithException() throws Exception211 {
		// TODO Auto-generated constructor stub
		throw new Exception211("thrown by BaseWithException");
	}
}

class DerivedWE extends BaseWithException {
	// super() must be the first statement in constructor
	// public DerivedWE() {
	// try {
	// super();
	// } catch (Exception211 e) {
	//
	// }
	// }

	public DerivedWE() throws Exception211 {
		// TODO Auto-generated constructor stub
	}
}

public class Ex21 {
	public static void main(String[] args) {
		try {
			new DerivedWE();
		} catch (Exception211 e) {
			System.out.println("Caught " + e);
		}
	}

}
