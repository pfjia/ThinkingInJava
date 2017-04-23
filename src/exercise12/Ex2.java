package exercise12;

class Person {
	public void speak() {
		System.out.println("speak something");
	}

}

public class Ex2 {
	public static void main(String[] args) {
		Person p = null;
		try {
			p.speak();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
