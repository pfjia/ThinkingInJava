package containers;

// Framework for performing timed tests of containers
public abstract class Test<C> {
	String name;

	public Test(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	// public Test() {
	// // TODO Auto-generated constructor stub
	// }

	// Override this method for different tests.
	// Returns actual number of repetitions of test
	abstract int test(C container, TestParam tp);
}
