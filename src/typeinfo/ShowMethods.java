package typeinfo;

import static net.mindview.util.Print.print;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Using reflection to show all the methods of a class, even if the methods are
 * defined in the base class
 * 
 * @author pfjia
 *
 */
public class ShowMethods extends Object {
	private static String usage = "usage:\n"
			+ "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n"
			+ "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";
	// ƥ��������"."��β���ַ���
	// ��Ϊmethod�е����Ͷ���ȫ���޶�������"java.lang.String"��Ӱ���Ķ���������replaceAll()ȥ����"."��β���ַ����������Ķ�
	private static Pattern p = Pattern.compile("\\w+\\.|native |final ");

	public static void main(String[] args) {
		args = new String[1];
		args[0] = "typeinfo.ShowMethods";
		if (args.length < 1) {
			print(usage);
			System.exit(0);
		}

		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();// ֻ����public�ķ���
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				System.out.println("����������" + methods.length);
				for (Method method : methods) {
					print(p.matcher(method.toString()).replaceAll(""));
				}
				System.out.println("����method��constructor�ķָ���");
				for (Constructor ctor : ctors) {
					print(p.matcher(ctor.toString()).replaceAll(""));
				}
				lines = methods.length + ctors.length;
			} else {
				for (Method method : methods) {
					if (method.toString().indexOf(args[1]) != -1) {
						print(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				}

				for (Constructor ctor : ctors) {
					if (ctor.toString().indexOf(args[1]) != -1) {
						print(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			print("No such class: " + e);
		}
	}
}
