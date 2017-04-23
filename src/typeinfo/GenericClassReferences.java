package typeinfo;

public class GenericClassReferences {
	public static void main(String[] args) {
		Class intClass = int.class;
		Class<Integer> genericintClass = int.class;
		genericintClass = Integer.class;
		intClass = double.class;
		// genericintClass = double.class;
	}

}
