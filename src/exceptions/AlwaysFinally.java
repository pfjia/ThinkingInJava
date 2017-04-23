package exceptions;

class FourException extends Exception {

}

public class AlwaysFinally {
	public static void main(String[] args) {
		try {
			System.out.println("Entering first try block");
			try {
				throw new FourException();
			} finally {
				System.out.println("finally in 2nd try block");
			}
		} catch (FourException e) {
			System.out.println("Caught FourException in 1st try block");
		} finally {
			System.out.println("finallly in 1st try block");
		}
	}
}
