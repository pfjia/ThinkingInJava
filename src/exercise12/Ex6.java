package exercise12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class Exception61 extends Exception {
	private static Logger logger = Logger.getLogger("LoggerException61");

	public Exception61() {
		// TODO Auto-generated constructor stub
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

class Exception62 extends Exception {
	private static Logger logger = Logger.getLogger("LoggerException62");

	public Exception62() {
		// TODO Auto-generated constructor stub
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class Ex6 {

	public static void main(String[] args) {
		try {
			throw new Exception61();
		} catch (Exception61 e) {
		}
		try {
			throw new Exception62();
		} catch (Exception62 e) {

		}
	}
}
