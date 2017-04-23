package generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
	private int n;// 哨兵，决定返回的Itertor的元素个数

	public IterableFibonacci(int count) {
		// TODO Auto-generated constructor stub
		n = count;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				n--;
				return IterableFibonacci.this.next();
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return n > 0;
			}
		};
	}

	public static void main(String[] args) {
		for (int i : new IterableFibonacci(18)) {
			System.out.print(i + "  ");
		}
	}

}
