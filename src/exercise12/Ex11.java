package exercise12;

class Exception111 extends Exception {

}

public class Ex11 {
	public static void f() throws RuntimeException {
		try {
			g();
		} catch (Exception111 e) {
			System.out.println("在f的catch语句中捕获到了111");
			System.out.println("111的栈信息");
			e.printStackTrace(System.out);
			System.out.println("把111包装成一个RuntimeException");
			throw new RuntimeException(e);

		}
	}

	public static void g() throws Exception111 {
		System.out.println("在g（）中抛出111");
		throw new Exception111();
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception111 e) {
			System.out.println("在main方法中catch111");
			System.out.println("输出111栈信息");
			e.printStackTrace(System.out);
		}

		try {
			f();
		} catch (RuntimeException e) {
			System.out.println("在main方法中catchRuntimeExcepiton");
			System.out.println("输出RuntimeException栈信息");
			e.printStackTrace(System.out);
		}
	}

}
