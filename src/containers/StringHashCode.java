package containers;

public class StringHashCode {
	public static void main(String[] args) {
		String[] hello = "Hello Hello".split(" ");
		System.out.println(hello[0].hashCode());
		System.out.println(hello[1].hashCode());
	}
}
