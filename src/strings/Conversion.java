package strings;

import java.util.Formatter;

public class Conversion {
	public static void main(String[] args) {
		Formatter f = new Formatter(System.out);

		char u = 'a';
		System.out.println("u='a'");

		// 不能把char转换为int
		// f.format("d:%d\n", u);
		f.format("c:%c\n", u);
		f.format("b:%b\n", u);
		f.format("s:%s\n", u);
		// f.format("f:%f\n", u);
		// f.format("e:%e\n", u);
		// f.format("x:%x\n", u);
		f.format("h:%h\n", u);
		System.out.println("==============================");
		int v = 121;
		System.out.println("v=121");
		f.format("d:%d\n", v);
		f.format("c:%c\n", v);
		f.format("b:%b\n", v);
		f.format("s:%s\n", v);
		// f.format("f:%f\n", v);
		// f.format("e:%e\n", v);
		f.format("x:%x\n", v);
		f.format("h:%h\n", v);

	}
}
