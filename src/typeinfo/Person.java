package typeinfo;

import net.mindview.util.Null;

public class Person {
	public final String first;
	public final String last;
	public final String address;

	public Person(String first, String last, String address) {
		super();
		this.first = first;
		this.last = last;
		this.address = address;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person: " + first + " " + last + " " + address;
	}

	public static class NullPerson extends Person implements Null {
		private NullPerson() {
			// TODO Auto-generated constructor stub
			super("None", "None", "None");
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "NullPerson";
		}
	}

	public static final Person Null = new NullPerson();
}
