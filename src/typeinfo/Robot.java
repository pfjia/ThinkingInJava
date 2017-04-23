package typeinfo;

import java.util.List;

import net.mindview.util.Null;

public interface Robot {
	String name();

	String model();

	List<Operation> operations();

	// 测试类，返回Robot的所有信息
	class Test {
		public static void test(Robot r) {
			if (r instanceof Null) {
				System.out.println("[Null Robot]");
			}

			System.out.println("Robot name: " + r.name());
			System.out.println("Robot nodel: " + r.model());
			for (Operation operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		}
	}

}
