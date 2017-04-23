package io;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

import net.mindview.util.ProcessFiles;

public class E06_ProcessFiles3 {

	// Demonstration of how to use it:
	public static void main(String[] args) {
		args = ". 2016.1.20".split(" ");
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
		long tmp = 0;
		try {
			df.setLenient(false);
			tmp = df.parse(args[1]).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		final long modTime = tmp;

		new ProcessFiles(new ProcessFiles.Strategy() {

			@Override
			public void process(File file) {
				// TODO Auto-generated method stub
				if (modTime < file.lastModified())
					System.out.println(file);
			}
		}, "java").start(args);
	}
}
