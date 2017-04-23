package typeinfo.toys;

import static net.mindview.util.Print.print;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

interface HasBatteries {

}

interface Waterproof {

}

interface Shoots {

}

interface USB {

}

class Toy {
	// public Toy() {
	// // TODO Auto-generated constructor stub
	// }

	public Toy(int i) {

	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, USB {
	public FancyToy() {
		// TODO Auto-generated constructor stub
		super(1);
	}
}

public class ToyTest {
	static void printInfo(Class cc) {
		print("Class name: " + cc.getName() + " is interface?["
				+ cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name: " + cc.getCanonicalName());
		System.out.println("============================");
	}

	public static void main(String[] args) {
		Class c = null;
		try {
			c = Class.forName("typeinfo.toys.FancyToy");
		} catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			System.exit(1);
		}
		printInfo(c);
		System.out.println("我是FancyToy类与其接口的分隔符");
		for (Class face : c.getInterfaces()) {
			printInfo(face);
		}
		System.out.println("我是接口与父类的分隔符");
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			// 通过反射创建有参构造函数的实例
			Constructor ctor = up.getConstructor(int.class);
			obj = ctor.newInstance(5);
			// 只能利用无参构造方法获取实例
			// obj = up.newInstance();
		} catch (InstantiationException e) {
			print("Can't instantiate");
			System.exit(1);
		} catch (IllegalAccessException e) {
			// TODO: handle exception
			print("Can't access");
			System.exit(1);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(obj.getClass());
	}
}
