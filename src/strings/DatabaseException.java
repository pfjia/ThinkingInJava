package strings;

public class DatabaseException extends Exception {
	public DatabaseException(int transactionID, int queryID, String message) {
		// TODO Auto-generated constructor stub
		super(String.format("(t%d,q%d) %s", transactionID, queryID, message));
	}

	public static void main(String[] args) {
		try {
			throw new DatabaseException(3, 7, "was failed");
		} catch (DatabaseException e) {
			System.out.println(e.toString());
		}
	}
}
