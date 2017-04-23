package exercise10;

public class SimpleClass {
	private int i = 0;

	private void f() {
		System.out.println("say something");
	}

	public void changeInner() {
		Inner i = new Inner();
		Inner g = new Inner();
		i.s = 20;
		System.out.println(i.s);
	}

	class Inner {
		private int s = 10;

		public void changeOuter() {
			i = 19;

			f();
		}
	}

	public static void main(String[] args) {
		new SimpleClass().changeInner();
	}

}
