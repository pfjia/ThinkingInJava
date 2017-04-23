package exceptions;

class BaseballException extends Exception {

}

class Foul extends BaseballException {

}

class PopFoul extends Foul {

}

class Strike extends BaseballException {

}

class StormException extends Exception {

}

class RainedOut extends StormException {

}

interface Storm {
	void event() throws RainedOut;

	void rainHard() throws RainedOut;

}

abstract class Inning {
	public Inning() throws BaseballException {

	}

	public Inning(String s) {

	}

	public void event() throws BaseballException {

	}

	public abstract void atBat() throws Strike, Foul;

	public void walk() {

	}
}

public class StormyInning extends Inning implements Storm {
	public StormyInning() throws BaseballException, RainedOut {
		// TODO Auto-generated constructor stub
	}

	public StormyInning(String s) throws BaseballException {

	}

	public StormyInning(int i) {
		super("");
	}

	@Override
	public void rainHard() throws RainedOut {
		// TODO Auto-generated method stub

	}

	@Override
	public void atBat() throws PopFoul {
		// TODO Auto-generated method stub

	}

	@Override
	public void event() {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		try {
			StormyInning si = new StormyInning();
			si.atBat();
		} catch (RainedOut e) {
			// TODO: handle exception
			System.out.println("Rained out");
		} catch (BaseballException e) {
			// TODO: handle exception
			System.out.println("Generic baseball exception");
		}

		try {
			Inning i = new StormyInning();
		} catch (RainedOut e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BaseballException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
