package generics;

abstract class GenericWithCreate<T> {
	final T element;

	public GenericWithCreate() {
		// TODO Auto-generated constructor stub
		element = create();
	}

	abstract T create();
}

class X {

}

class Creator extends GenericWithCreate<X> {

	void f() {
		System.out.println(element.getClass().getSimpleName());
	}

	@Override
	X create() {
		// TODO Auto-generated method stub
		return new X();
	}
}

public class CreatorGeneric {
	public static void main(String[] args) {
		Creator c = new Creator();
		c.f();
	}

}
