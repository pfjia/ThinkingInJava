package strings;

import java.util.Scanner;

public class BetterRead {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(SimpleRead.input);

		System.out.println("What is your name?");
		String name = stdin.nextLine();
		System.out.println(name);
		System.out.println("How old ary you?what is your favorite double?");
		System.out.println("(input:<age> <double>)");
		String numbers = stdin.nextLine();
		System.out.println(numbers);
		String[] numArray = numbers.split(" ");
		int age = Integer.parseInt(numArray[0]);
		double favorite = Double.parseDouble(numArray[1]);
		System.out.format("Hi %s.\n", name);
		System.out.format("In 5 years you will be %d.\n", age + 5);
		System.out.format("My favorite double is %f.", favorite / 2);
	}

}
