package typeinfo;

import static net.mindview.util.Print.print;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class MethodSelector implements InvocationHandler {
	private Object proxied;

	public MethodSelector(Object proxied) {
		// TODO Auto-generated constructor stub
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		if (method.getName().equals("interesting")) {
			print("Proxy detected the interesting method");
		}
		return method.invoke(proxied, args);
	}
}

interface SomeMethods {
	void boring1();

	void boring2();

	void interesting(String arg);

	void boring3();
}

class Implementation implements SomeMethods {

	@Override
	public void boring1() {
		// TODO Auto-generated method stub
		print("boring1");
	}

	@Override
	public void boring2() {
		// TODO Auto-generated method stub
		print("boring2");
	}

	@Override
	public void interesting(String arg) {
		// TODO Auto-generated method stub
		print("interesting " + arg);
	}

	@Override
	public void boring3() {
		// TODO Auto-generated method stub
		print("boring3");
	}

}

public class SelectingMethods {
	public static void main(String[] args) {
		SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[] { SomeMethods.class }, new MethodSelector(
						new Implementation()));
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");
		proxy.boring3();

	}
}
