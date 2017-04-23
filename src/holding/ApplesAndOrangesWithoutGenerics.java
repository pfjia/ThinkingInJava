package holding;

import java.util.ArrayList;

class Apple {
	private static long counter;
	private final long id = counter++;

	public long id() {
		return id;
	}
}

class Orange {

}

public class ApplesAndOrangesWithoutGenerics {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for (int i = 0; i < 3; i++) {
			// Type safety: The method add(Object) belongs to the raw type
			// ArrayList. References to generic type ArrayList<E> should be
			// parameterized
			apples.add(new Apple());
		}

		// Not prevented from adding an Orange to apples:
		apples.add(new Orange());
		// for (int i = 0; i < apples.size(); i++) {
		// // 运行期错误
		// ((Apple) apples.get(i)).id();
		// }

		// 使用foreach是强制类型转换apples为ArrayList<Apple>
		for (Apple o : (ArrayList<Apple>) apples) {
			o.id();
		}
	}
}
