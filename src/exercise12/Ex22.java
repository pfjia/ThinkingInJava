package exercise12;

public class Ex22 {
	public static void main(String[] args) {
		for (boolean b = false;; b = !b) {
			try {
				System.out.println("Constructing...");
				FailingConstructor fc = new FailingConstructor(b);
				try {
					System.out.println("Processing...");
				} finally {
					System.out.println("Cleanup...");
				}
			} catch (Exception e) {
				System.out.println("Construction has failed:" + e);
				break;
			}
		}
	}
}

class FailingConstructor {
	public FailingConstructor(boolean fail) throws Exception {
		// TODO Auto-generated constructor stub
		if (fail) {
			throw new Exception();
		}
	}
}