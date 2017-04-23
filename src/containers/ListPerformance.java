package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

import net.mindview.util.CountingGenerator;
import net.mindview.util.CountingIntegerList;
import net.mindview.util.Generated;

public class ListPerformance {
	static Random rand = new Random();
	static int reps = 1000;
	static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
	static List<Test<LinkedList<Integer>>> qTests = new ArrayList<Test<LinkedList<Integer>>>();

	static {
		tests.add(new Test<List<Integer>>("add") {

			@Override
			int test(List<Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops = tp.size;
				int listSize = tp.size;
				for (int i = 0; i < loops; i++) {
					container.clear();
					for (int j = 0; j < listSize; j++) {
						container.add(j);
					}
				}
				return loops * listSize;
			}
		});

		tests.add(new Test<List<Integer>>("get") {

			@Override
			int test(List<Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops = tp.size * reps;
				int listSize = tp.size;
				for (int i = 0; i < loops; i++) {
					container.get(rand.nextInt(listSize));
				}
				return loops;
			}
		});

		tests.add(new Test<List<Integer>>("set") {

			@Override
			int test(List<Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops = tp.size * reps;
				int listSize = tp.size;
				for (int i = 0; i < loops; i++) {
					container.set(rand.nextInt(listSize), 47);
				}
				return loops;
			}
		});

		tests.add(new Test<List<Integer>>("iteradd") {

			@Override
			int test(List<Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				final int LOOPS = 1000000;
				int half = container.size() / 2;
				ListIterator<Integer> it = container.listIterator(half);
				for (int i = 0; i < LOOPS; i++) {
					it.add(47);
				}
				return LOOPS;
			}
		});

		tests.add(new Test<List<Integer>>("insert") {

			@Override
			int test(List<Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops = tp.loops;
				for (int i = 0; i < loops; i++) {
					container.add(5, 47);// Minimize random-access cost
				}
				return loops;
			}
		});

		tests.add(new Test<List<Integer>>("remove") {

			@Override
			int test(List<Integer> container, TestParam tp) {
				// TODO Auto-generated method stub
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					container.clear();
					container.addAll(new CountingIntegerList(size));
					while (container.size() > 5) {
						container.remove(5);// Minimize random-access cost
					}
				}
				return loops * size;
			}
		});
		// Tests for queue behavior:
		qTests.add(new Test<LinkedList<Integer>>("addFirst") {
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					for (int j = 0; j < size; j++)
						list.addFirst(47);
				}
				return loops * size;
			}
		});
		qTests.add(new Test<LinkedList<Integer>>("addLast") {
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					for (int j = 0; j < size; j++)
						list.addLast(47);
				}
				return loops * size;
			}
		});
		qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while (list.size() > 0)
						list.removeFirst();
				}
				return loops * size;
			}
		});
		qTests.add(new Test<LinkedList<Integer>>("rmLast") {
			int test(LinkedList<Integer> list, TestParam tp) {
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++) {
					list.clear();
					list.addAll(new CountingIntegerList(size));
					while (list.size() > 0)
						list.removeLast();
				}
				return loops * size;
			}
		});
	}

	static class ListTester extends Tester<List<Integer>> {
		public ListTester(List<Integer> contaier,
				List<Test<List<Integer>>> tests) {
			// TODO Auto-generated constructor stub
			super(contaier, tests);
		}

		// Fill to the appropriate size before each test
		@Override
		protected List<Integer> initialize(int size) {
			// TODO Auto-generated method stub
			container.clear();
			container.addAll(new CountingIntegerList(size));
			return container;
		}

		// Generic methods for convenience
		// 把参数类型确定为List<Integer>
		public static void run(List<Integer> list,
				List<Test<List<Integer>>> tests) {
			new ListTester(list, tests).timedTest();
		}

		public static void main(String[] args) {
			if (args.length > 0) {
				Tester.defaultParams = TestParam.array(args);
			}

			// Can only do these two tests on an array
			Tester<List<Integer>> arrayTest = new Tester<List<Integer>>(null,
					tests.subList(1, 3)) {

				// This will be caller before each test. It produces a
				// non-resizeable array-backed list
				@Override
				protected List<Integer> initialize(int size) {
					// TODO Auto-generated method stub
					Integer[] ia = Generated.array(Integer.class,
							new CountingGenerator.Integer(), size);
					return Arrays.asList(ia);
				}
			};

			arrayTest.setHeadLine("Array as List");
			arrayTest.timedTest();
			Tester.defaultParams = TestParam.array(10, 50, 100, 500, 1000,
					1000, 10000, 200);
			if (args.length > 0) {
				Tester.defaultParams = TestParam.array(args);
			}
			ListTester.run(new ArrayList<Integer>(), tests);
			ListTester.run(new LinkedList<Integer>(), tests);
			ListTester.run(new Vector<Integer>(), tests);
			Tester.fieldWidth = 12;
			/**
			 * ListTester.run(List<Integer> list,List<Test<List<Integer>>>
			 * tests)
			 * 而qTests的类型为List<Test<LinkedList<Integer>>>，不匹配，因而使用的还是Tester中的
			 * public static <C> void run(C container, List<Test<C>>
			 * tests)，效率比较低
			 */
			// ListTester.run(new LinkedList<Integer>(), qTests);
			Tester<LinkedList<Integer>> qTest = new Tester<LinkedList<Integer>>(
					new LinkedList<Integer>(), qTests);
			qTest.setHeadLine("Queue tests");
			qTest.timedTest();
		}

	}
}
