package typeinfo;

import static net.mindview.util.Print.print;
import typeinfo.interfacea.A;

class AnonymousA {
	public static A makeA() {
		return new A() {

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
		};
	}
}

public class AnonymousImplementation {
	public static void main(String[] args) throws Exception {
		A a = AnonymousA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}

}
