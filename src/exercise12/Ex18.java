package exercise12;

class VeryImportantException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "A very important exception!";
	}

}

class HoHumException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "A trivial exception";
	}
}

class MostImportantException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "The most important exception";
	}
}

public class Ex18 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	void g() throws MostImportantException {
		throw new MostImportantException();
	}

	public static void main(String[] args) {
		try {
			Ex18 lm = new Ex18();
			try {
				try {
					lm.g();
				} finally {
					lm.f();
				}
			} finally {
				lm.dispose();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}