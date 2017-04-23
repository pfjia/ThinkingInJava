package exceptions;

public class RethrowNew {
	public static void f() throws OneException {
		System.out.println("originating the exception in f()");
		throw new OneException("throw form f()");
	}

	public static void main(String[] args) {
		try {
			try {
				f();
			} catch (OneException e) {
				System.out.println("Caught in inner try,e.printstacktrace()");
				e.printStackTrace(System.out);
				throw new TwoException("from inner try");
			}
		} catch (TwoException e) {
			System.out.println("Caught in outer try,e.printstacktrace()");
			e.printStackTrace(System.out);
		}
	}
}

class OneException extends Exception {
	public OneException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}

class TwoException extends Exception {
	public TwoException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}