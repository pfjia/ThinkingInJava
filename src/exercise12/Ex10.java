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
			System.out.println("��f��catch����в�����101");
			System.out.println("101��ջ��Ϣ");
			e.printStackTrace(System.out);
			System.out.println("�׳�һ���µ�102");
			throw new Exception102();

		}
	}

	public static void g() throws Exception101 {
		System.out.println("��g�������׳�101");
		throw new Exception101();
	}

	public static void main(String[] args) {
		try {
			g();
		} catch (Exception101 e) {
			System.out.println("��main������catch101");
			System.out.println("���101ջ��Ϣ");
			e.printStackTrace(System.out);
		}

		try {
			f();
		} catch (Exception102 e) {
			System.out.println("��main������catch102");
			System.out.println("���102ջ��Ϣ");
			e.printStackTrace(System.out);
		}
	}

}
