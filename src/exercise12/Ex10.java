package exercise12;

class Exception101 extends Exception {

}

class Exception102 extends Exception {

}

public class Ex10 {
	public static void f() throws Exception102 {
		try {
			g();
		} catch (Exception101 e) {
			System.out.println("在f的catch语句中捕获到了101");
			System.out.println("101的栈信息");
			e.printStackTrace(System.out);
			System.out.println("抛出一个新的102");
			throw new Exception102();

		}
	}

	public static void g() throws Exception101 {
		System.out.println("在g（）中抛出101");
		throw new Exception101();
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception101 e) {
			System.out.println("在main方法中catch101");
			System.out.println("输出101栈信息");
			e.printStackTrace(System.out);
		}

		try {
			f();
		} catch (Exception102 e) {
			System.out.println("在main方法中catch102");
			System.out.println("输出102栈信息");
			e.printStackTrace(System.out);
		}
	}

}
