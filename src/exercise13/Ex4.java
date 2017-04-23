package exercise13;

import java.util.Formatter;

public class Ex4 {
	private double total = 0;
	private Formatter f = new Formatter(System.out);

	/**
	 * 格式控制所用的字符串也是普通的字符串，自己代码自动将其中的“%s”等解释为特定的类型
	 */
	private final static int ITEM_WIDTH = 15;
	private final static int QTY_WIDTH = 5;
	private final static int PRICE_WIDTH = 10;
	private final static int PRICE_PRECISION = 2;
	private final static String TITLE_FORM = "%-" + ITEM_WIDTH + "s %"
			+ QTY_WIDTH + "s %" + PRICE_WIDTH + "s\n";
	private final static String ITEM_FORM = "%-" + ITEM_WIDTH + "."
			+ ITEM_WIDTH + "s %" + QTY_WIDTH + "d %" + PRICE_WIDTH + "."
			+ PRICE_PRECISION + "f\n";
	private final static String TOTAL_FORM = "%-" + ITEM_WIDTH + "s %"
			+ QTY_WIDTH + "s %" + PRICE_WIDTH + "." + PRICE_PRECISION + "f\n";

	/**
	 * %-15s中 “-”表示由右对齐改为左对齐
	 */
	public void printTitle() {
		f.format(TITLE_FORM, "Item", "Qty", "Price");
		f.format(TITLE_FORM, "----", "---", "-----");
	}

	public void print(String name, int qty, double price) {
		// TODO Auto-generated method stub
		f.format(ITEM_FORM, name, qty, price);
		total += price;
	}

	public void printTotal() {
		// TODO Auto-generated method stub
		f.format(TOTAL_FORM, "Tax", "", total * 0.06);
		f.format(TITLE_FORM, "", "", "-----");
		f.format(TOTAL_FORM, "Total", "", total * 1.06);
	}

	public static void main(String[] args) {
		Ex4 receipt = new Ex4();
		receipt.printTitle();
		receipt.print("Jack's Magic Beans", 4, 4.25);
		receipt.print("Princess Peas", 3, 5.1);
		receipt.print("Three Bears Porridge", 1, 14.29);
		receipt.printTotal();
	}
}
