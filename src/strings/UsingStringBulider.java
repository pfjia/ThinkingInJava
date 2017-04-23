package strings;

import java.util.Random;

public class UsingStringBulider {
	public static Random rand = new Random(47);

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder("[");
		for (int i = 0; i < 25; i++) {
			result.append(rand.nextInt(100));
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("]");
		return result.toString();
	}

	public static void main(String[] args) {
		UsingStringBulider ub = new UsingStringBulider();
		System.out.println(ub);
	}

}
