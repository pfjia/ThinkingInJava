package holding;

import java.util.Collection;
import java.util.TreeSet;

public class E02_SimpleCollection2 {
	public static void main(String[] args) {
		Collection<Integer> c = new TreeSet<Integer>();
		for (int i = 0; i < 10; i++) {
			c.add(i);
		}

		for (Integer i : c) {
			System.out.print(i + ", ");
		}
	}
}
