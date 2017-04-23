package generics;

public class Holder<T> {
	private T value;

	public Holder() {
		// TODO Auto-generated constructor stub
	}

	public Holder(T val) {
		value = val;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return value.equals(obj);
	}

	public static void main(String[] args) {
		Holder<Apple> apple = new Holder<Apple>(new Apple());
		Apple val = apple.getValue();
		apple.setValue(val);
		// compile error
		// Holder<Fruit> fruit = apple;

		Holder<? extends Fruit> fruit = apple;

		Fruit p = fruit.getValue();
		val = (Apple) fruit.getValue();

		try {
			Orange c = (Orange) fruit.getValue();
		} catch (Exception e) {
			// fruit.setValue(new Apple());
			// fruit.set(new Fruit());
			System.out.println(e);
		}
		System.out.println(fruit.equals(val));

	}

}
