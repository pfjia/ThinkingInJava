package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
	public static void main(String[] args) {
		List<? extends Fruit> flist = new ArrayList<Fruit>();

		/**
		 * boolean add(E e); add()方法的参数时E，而flist的参数类型是<? extends
		 * Fruit>，表示是某种继承自Fruit特定类型，但是是一个不知道是什么的特定类型，所以向其中增加什么都不行
		 */
		// flist.add(new Apple());
		// flist.add(new Fruit());
	}
}
