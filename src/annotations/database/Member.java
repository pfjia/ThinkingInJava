package annotations.database;

@DBTable(name = "MEMBER")
public class Member {
	@SQLString(30)
	String firstName;
	@SQLString(50)
	String lastName;

	@SQLInteger
	Integer age;
	@SQLString(value = 30, constraints = @Constraints(primaryKey = true))
	String handle;
	static int memeberCount;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getHandle() {
		return handle;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return handle;
	}

}
