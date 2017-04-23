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
		// 变成了编译期错误
		// apples.add(new Orange());

		for (int i = 0; i < apples.size(); i++) {
			// 不需要强制类型转换
			System.out.println(apples.get(i).id());
		}

		for (Apple c : apples) {
			System.out.println(c.id());
		}
	}

}
