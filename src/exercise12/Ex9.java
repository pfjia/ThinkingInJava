package exercise12;

public class Ex9 {
	static void f() {
		int a = 10 / 0;
		throw new ArrayIndexOutOfBoundsException();
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println(e.getStackTrace());
		} catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
