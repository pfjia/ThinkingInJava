package exercise12;

class Exception111 extends Exception {

}

public class Ex11 {
	public static void f() throws RuntimeException {
		try {
			g();
		} catch (Exception111 e) {
			System.out.println("��f��catch����в�����111");
			System.out.println("111��ջ��Ϣ");
			e.printStackTrace(System.out);
			System.out.println("��111��װ��һ��RuntimeException");
			throw new RuntimeException(e);

		}
	}

	public static void g() throws Exception111 {
		System.out.println("��g�������׳�111");
		throw new Exception111();
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception111 e) {
			System.out.println("��main������catch111");
			System.out.println("���111ջ��Ϣ");
			e.printStackTrace(System.out);
		}

		try {
			f();
		} catch (RuntimeException e) {
			System.out.println("��main������catchRuntimeExcepiton");
			System.out.println("���RuntimeExceptionջ��Ϣ");
			e.printStackTrace(System.out);
		}
	}

}
