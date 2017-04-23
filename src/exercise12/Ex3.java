package exercise12;

public class Ex3 {
	public static void main(String[] args) {
		int[] a = new int[5];
		try {
			System.out.println(a[10]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
