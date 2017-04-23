package exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
	private BufferedReader in;

	public InputFile(String fname) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		try {
			in = new BufferedReader(new FileReader(fname));
		} catch (FileNotFoundException e) {
			System.out.println("Could not open " + fname);
			throw e;
		} catch (Exception e) {
			// TODO: handle exception
			try {
				in.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("in.close() unsuccessful");
			}
			// rethrow
			throw e;
		} finally {

		}
	}

	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			throw new RuntimeException("readline() failed");
		}
		return s;
	}

	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() successful");
		} catch (IOException e) {
			throw new RuntimeException("in.close() failed");
		}
	}
}
