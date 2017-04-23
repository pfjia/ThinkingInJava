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
	// ��ֹѭ������
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
		// �����������Ա
		for (Field f : fields) {
			print("  " + f);
		}
		// �������Ա�ļ̳���ϵ
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
		System.out.println("����������main�����в���ʱִ�У�������û����ʱ���չʾĳ����ļ̳���ϵ:");
		// printClasses(Deriver.class);
		printClasses(String.class);
	}
}
