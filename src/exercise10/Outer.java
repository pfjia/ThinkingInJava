package exercise10;

public class Outer {
	private String name;

	public Outer(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	class Inner {

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "我是内部类，我的外部类的名字是：" + name;
		}

	}

	public Inner getInnerInstance() {
		return new Inner();
	}

	public static void main(String[] args) {
		Outer o = new Outer("小胖");
		// 内部类对象不能用new生成，只能由外部类实例调用方法生成
		// 上面是错的，内部类对象可以用new生成，语法如下:(此时内部类不是static类)
		// Inner i = o.new Inner();
		Inner i = o.getInnerInstance();
		System.out.println(i);
	}

}
