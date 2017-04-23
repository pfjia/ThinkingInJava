package concurrency;

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue = 0;

	@Override
	public int next() {
		// TODO Auto-generated method stub
		++currentEvenValue;// Danger point here
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args) {
		// 多个进程共享一个EvenGenerator
		EvenChecker.test(new EvenGenerator());
	}

}
