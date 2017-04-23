package exercise14;

import static net.mindview.util.Print.print;

import java.util.HashSet;

/**
 * 使用反射获取某个类的继承体系
 * 
 * @author pfjia
 *
 */
public class E08_RecursiveClassPrint {
	public static void printClasses(Class<?> c) {
		if (c == null) {
			return;
		}
		print(c.getName());
		for (Class<?> k : c.getInterfaces()) {
			print("Interface: " + k.getName());
			printClasses(k.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}

	public static void main(String[] args) {
		printClasses(HashSet.class);
	}
}
