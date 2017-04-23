package generics;


public class Holder3<T> {
	private T a;

	public Holder3(T a) {
		// TODO Auto-generated constructor stub
		this.a = a;
	}

	public T getA() {
		return a;
	}

	public void setA(T a) {
		this.a = a;
	}

	public static void main(String[] args) {
		Holder3<Automobile> h3 = new Holder3<Automobile>(new Automobile());
		Automobile a = h3.getA();// No cast needed
		// h3.setA("Not an Automobile");// Error
		// h3.setA(1);//Error
	}
}
