package exceptions;

public class Rethrowing {
	public static void f() throws Exception {
		System.out.println("Originating the exception in f()");
		throw new Exception("thrown from f()");
	}

	public static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("Inside g(),e.printstacktrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}

	public static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			System.out.println("inside h(),e.printstacktrace()");
			e.printStackTrace(System.out);
			throw (Exception) e.fillInStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			System.out.println("main:printstacktrace()");
			e.printStackTrace(System.out);
		}

		try {
			h();
		} catch (Exception e) {
			System.out.println("main:printstacktrace()");
			e.printStackTrace(System.out);
		}
	}

}
