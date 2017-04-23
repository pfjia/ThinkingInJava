package exercise12;

class Exception4 extends Exception {
	private String msg;

	public Exception4(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}

public class Ex4 {
	public static void f() throws Exception4 {
		System.out.println("Throwing Exception4 in f()");
		throw new Exception4("exception4");
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (Exception4 e) {
			System.out.println(e.getMsg());
			e.printStackTrace();
		}
	}
}
