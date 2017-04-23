package exercise14;

public class E10_PrimitiveOrTrue {
	public static void main(String[] args) {
		char[] c = "12345".toCharArray();
		System.out.println(c.getClass());
		if (c instanceof Object) {
			System.out.println("char数组是个对象");
		} else {
			System.out.println("char数组是个基本类型");
		}
	}
}
