package exercise14;

import static net.mindview.util.Print.print;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

interface Iface {
	int i = 47;

	void f();
}

class Base implements Iface {
	String s;
	double d;

	@Override
	public void f() {
		// TODO Auto-generated method stub
		System.out.println("Base.f()");
	}
}

class Composed {
	Base b;
}

class Deriver extends Base {
	Composed c;
	String s;
}

public class E09_GetDeclaredFields {
	// 防止循环遍历
	static Set<Class<?>> alreadyDisplayed = new HashSet<Class<?>>();

	static void printClasses(Class<?> c) {
		if (c == null) {
			return;
		}
		print(c.getName());
		Field[] fields = c.getDeclaredFields();
		if (fields.length != 0) {
			print("Fields:");
		}
		// 遍历所有域成员
		for (Field f : fields) {
			print("  " + f);
		}
		// 遍历域成员的继承体系
		for (Field f : fields) {
			Class<?> k = f.getType();
			if (!alreadyDisplayed.contains(k)) {
				printClasses(k);
				alreadyDisplayed.add(k);
			}
		}

		for (Class<?> k : c.getInterfaces()) {
			print("Interface: " + k.getName());
			printClasses(k.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}

	public static void main(String[] args) throws ClassNotFoundException {
		for (int i = 0; i < args.length; i++) {
			print("Displaying " + args[i]);
			printClasses(Class.forName(args[i]));
			if (i < args.length - 1) {
				System.out.println("=========");
			}
		}
		System.out.println("上面的是面对main方法有参数时执行，下面是没参数时如果展示某个类的继承体系:");
		// printClasses(Deriver.class);
		printClasses(String.class);
	}
}
