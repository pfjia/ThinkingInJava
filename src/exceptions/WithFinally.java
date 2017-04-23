package exceptions;

public class WithFinally {
	static Switch sw = new Switch();

	public static void main(String[] args) {
		try {
			sw.on();
			OnOffSwitch.f();
		} catch (OnOffException1 e) {
			e.printStackTrace();
		} catch (OnOffException2 e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sw.off();
		}
	}

}
