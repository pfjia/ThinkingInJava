package containers;

import java.util.List;

public class Tester<C> {
	public static TestParam[] defaultParams = TestParam.array(10, 5000, 100,
			5000, 1000, 5000, 10000, 5000);

	public static int fieldWidth = 8;

	// string格式化字符串
	private static String stringField() {
		return "%" + fieldWidth + "s";
	}

	// int格式化字符串
	private static String numberField() {
		return "%" + fieldWidth + "d";
	}

	private static int sizeWidth = 5;
	private static String sizeField = "%" + sizeWidth + "s";

	// Override this to modify pre-test initialization
	protected C initialize(int size) {
		return container;
	}

	protected C container;

	private String headline = "";
	private List<Test<C>> tests;

	private TestParam[] paramList = defaultParams;

	public Tester(C container, List<Test<C>> tests) {
		// TODO Auto-generated constructor stub
		this.container = container;
		this.tests = tests;
		if (container != null) {
			headline = container.getClass().getSimpleName();
		}
	}

	public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
		// TODO Auto-generated constructor stub
		this(container, tests);
		this.paramList = paramList;
	}

	public void setHeadLine(String newHeadLine) {
		headline = newHeadLine;
	}

	// Generic methods for convenience
	public static <C> void run(C container, List<Test<C>> tests) {
		new Tester<C>(container, tests).timedTest();
	}

	public static <C> void run(C container, List<Test<C>> tests,
			TestParam[] paramList) {
		new Tester<C>(container, tests, paramList).timedTest();
	}

	private void displayHeader() {
		// Calculate width and pad with '-'
		int width = fieldWidth * tests.size() + sizeWidth;
		int dashLength = width - headline.length() - 1;
		StringBuilder head = new StringBuilder(width);
		for (int i = 0; i < dashLength / 2; i++) {
			head.append("-");
		}
		head.append(" ");
		head.append(headline);
		head.append(" ");
		for (int i = 0; i < dashLength / 2; i++) {
			head.append("-");
		}
		System.out.println(head);
		// Print column headers
		System.out.format(sizeField, "size");
		for (Test test : tests) {
			System.out.format(stringField(), test.name);
		}
		System.out.println();
	}

	// Run the tests for this container
	public void timedTest() {
		displayHeader();
		for (TestParam param : paramList) {
			System.out.format(sizeField, param.size);
			for (Test<C> test : tests) {
				C kontainer = initialize(param.size);
				long start = System.nanoTime();

				// Call the overriden method
				int reps = test.test(kontainer, param);
				long duration = System.nanoTime() - start;
				long timePerRep = duration / reps; // Nanoseconds
				System.out.format(numberField(), timePerRep);
			}
			System.out.println();
		}
	}
}
