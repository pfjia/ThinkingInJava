package typeinfo;

import java.lang.reflect.Method;

import typeinfo.interfacea.A;
import typeinfo.packageaccess.HiddenC;

public class HiddenImplementation {
	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());

		// compile error: C cannot be resolved to a type
		/*
		 * if (a instanceof C) { C c = (C) a; c.g(); }
		 */

		// �������ǵ���Ȩ�޿�����ӵ�з��似���ĳ���Ա��ǰ�ͺ����ô�
		callHiddenMethod(a, "g");

		// �����ǰ�Ȩ�ޡ�protected��private�����Է���
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");

	}

	static void callHiddenMethod(Object a, String methodName) throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}

}
