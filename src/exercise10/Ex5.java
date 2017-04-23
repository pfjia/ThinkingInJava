package exercise10;

import exercise10.Outer.Inner;

public class Ex5 {
	public static void main(String[] args) {
		Outer o = new Outer("╢Сеж");
		Inner i = o.getInnerInstance();
		System.out.println(i);
	}

}
