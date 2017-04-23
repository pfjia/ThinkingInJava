package generics;

public class GenericMethods {

	// 类型参数列表必须在返回类型前
	// 在static之后
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}

	// static和void不能换位
	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("  ");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
	}

}
