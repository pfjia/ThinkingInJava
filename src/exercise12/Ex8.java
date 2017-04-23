package exercise12;

class Exception84 extends Exception {
	private String msg;

	Exception84(String msg) {
		super(msg);
		System.out.println("Exception4()");
		this.msg = msg;
	}

	protected void showS() {
		System.out.println("Message from Exception4: " + msg);
	}
}

class Test8 {
	public static void f() throws Exception84 {
		System.out.println("f()");
		throw new Exception84("Ouch from f()");
	}
}

public class Ex8 {
	public static void main(String[] args) {
		try {
			Test8 t = new Test8();
			Test8.f();
		} catch (Exception84 e) {
			System.err.println("Caught Exception4");
			e.printStackTrace();
			e.showS();
		}
	}
}