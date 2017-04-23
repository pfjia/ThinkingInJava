package exceptions;

public class Cleanup {
	public static void main(String[] args) {
		try {
			// 文件相对位置是相对于项目根目录，且不需要“/”
			InputFile in = new InputFile("src/exceptions/Cleanup.java");
			try {
				String s;
				int i = 1;
				while ((s = in.getLine()) != null) {
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println("Caught Exception in main");
				e.printStackTrace();
			} finally {
				in.dispose();
			}
		} catch (Exception e) {
			System.out.println("Inputfile construction failed");
		}
	}
}
