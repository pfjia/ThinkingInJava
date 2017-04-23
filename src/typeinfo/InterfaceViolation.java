package typeinfo;

import typeinfo.interfacea.A;

class B implements A {

	public void g() {

	}

	@Override
	public void f() {
		// TODO Auto-generated method stub

	}

}

public class InterfaceViolation {
	public static void main(String[] args) {
		A a = new B();
		a.f();

		// a.g();//compile error
		System.out.println(a.getClass().getName());
		if (a instanceof B) {
			B b = (B) a;
			b.g();
		}
	}
}
