package typeinfo.packageaccess;

import static net.mindview.util.Print.print;
import typeinfo.interfacea.A;

class C implements A {

	@Override
	public void f() {
		// TODO Auto-generated method stub
		print("public C.f()");
	}

	public void g() {
		print("public C.g()");
	}

	void u() {
		print("package C.u()");
	}

	protected void v() {
		print("protected C.v()");
	}

	private void w() {
		print("private C.w()");
	}

}

public class HiddenC {
	public static A makeA() {
		return new C(); 
	}

}
