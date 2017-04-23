package io;

import static net.mindview.util.Print.print;

import java.io.File;

import net.mindview.util.Directory;
import net.mindview.util.PPrint;

//Sample use of Directory utilities
public class DirectoryDemo {
	public static void main(String[] args) {
		// All directories
		PPrint.pprint(Directory.walk(".").dirs);
		System.out.println("**************************");

		// All files beginning with 'T'
		for (File file : Directory.local(".", "T.*")) {
			print(file);
		}
		print("----------------------------");
		// All java files beginning with 'T'
		for (File file : Directory.walk(".", "T.*\\.java")) {
			print(file);
		}
		print("===========================");

		// Class files containing "Z" or "z"
		for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
			print(file);
		}
	}
}
