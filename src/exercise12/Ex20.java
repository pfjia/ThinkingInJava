package exercise12;

public class Ex20 {

}

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

	public void f() throws UmpireArgument {

	}
}

class StormyInning extends Inning implements Storm {
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

	@Override
	public void f() throws UmpireArgument {
		// TODO Auto-generated method stub
		super.f();
	}
}

class UmpireArgument extends Exception {

}
