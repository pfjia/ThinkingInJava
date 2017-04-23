package exercise12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class Exception71 extends Exception {
	private static Logger logger = Logger.getLogger("LoggerException71");

	void logException() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}

public class Ex7 {
	public static void main(String[] args) {
		try {
			throw new Exception71();
		} catch (Exception71 e) {
			e.logException();
		}
	}
}
