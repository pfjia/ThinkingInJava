package generics;

public class CountedObject {
	private static long counter = 0;
	private final long id = counter++;

	public long id() {
		return id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CountedObject " + id;
	}

}
