package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class E09_UpperCase {
	public static String read(String fileName) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		LinkedList<String> strings = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		String s;
		while ((s = in.readLine()) != null) {
			s = s.toUpperCase();
			strings.add(s);
		}
		in.close();
		ListIterator<String> it = strings.listIterator(strings.size());
		while (it.hasPrevious()) {
			sb.append(it.previous() + "\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.println(read("src/io/BufferedInputFile.java"));
	}
}
