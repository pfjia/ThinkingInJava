package typeinfo;

public class Position {
	private String title;
	private Person person;

	public Position(String jobTitle, Person employee) {
		title = jobTitle;
		person = employee;
		if (person == null) {
			person = Person.Null;
		}
	}

	public Position(String jobTitle) {
		title = jobTitle;
		person = Person.Null;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		if (person == null) {
			person = Person.Null;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Poistion: " + title + " " + person + "\n";
	}
}
