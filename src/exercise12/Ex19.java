package exercise12;

public class Ex19 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	public static void main(String[] args) {
		try {
			Ex19 lm = new Ex19();
			try {
				lm.f();
			} finally {
				try {
					lm.dispose();
					// �Ȱ�С�쳣��catch��ʣ�µĴ��쳣������һ��catch
				} catch (HoHumException e) {
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
