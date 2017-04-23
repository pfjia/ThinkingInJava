package holding;

import java.util.ArrayList;

public class ApplesAndOrangesWithGenerics {
	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple>();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		// The method add(Apple) in the type ArrayList<Apple> is not applicable
		// for the arguments (Orange)
		// ����˱����ڴ���
		// apples.add(new Orange());

		for (int i = 0; i < apples.size(); i++) {
			// ����Ҫǿ������ת��
			System.out.println(apples.get(i).id());
		}

		for (Apple c : apples) {
			System.out.println(c.id());
		}
	}

}
