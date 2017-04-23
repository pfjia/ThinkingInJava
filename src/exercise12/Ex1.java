package exercise12;

class Exception1 extends Exception {
	public Exception1(String msg) {
		super(msg);
	}
}

public class Ex1 {
	public static void f() throws Exception1 {
		System.out.println("Throwing Exception1 in f()");
		throw new Exception1("from f()");
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (Exception1 e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally");
		}
	}

}
