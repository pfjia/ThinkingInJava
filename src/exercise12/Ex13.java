package exercise12;

public class Ex13 {
	static void f() {
		throw new NullPointerException();
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			System.out.println("this is in finally clause");
		}
	}
}
