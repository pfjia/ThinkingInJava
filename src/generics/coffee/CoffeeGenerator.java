package generics.coffee;

import java.util.Iterator;
import java.util.Random;

import net.mindview.util.Generator;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	private Class[] types = { Latte.class, Mocha.class, Cappuccino.class,
			Americano.class, Breve.class };
	private static Random rand = new Random(47);
	private int size = 0;

	public CoffeeGenerator() {
		// TODO Auto-generated constructor stub
	}

	// size是“末端哨兵”，决定返回的Iterator的循环次数
	public CoffeeGenerator(int size) {
		this.size = size;
	}

	@Override
	public Iterator<Coffee> iterator() {
		// TODO Auto-generated method stub
		return new CoffeeIterator();
	}

	@Override
	public Coffee next() {
		// TODO Auto-generated method stub
		try {
			return (Coffee) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 内部类
	 */
	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return count > 0;
		}

		@Override
		public Coffee next() {
			// TODO Auto-generated method stub
			count--;
			return CoffeeGenerator.this.next();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}

	}

	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		// CoffeeGenerator的next（）每次都会返回一个Coffee的实例，但是如果使用无参构造函数，size为0，生成的Iterator长度为0,
		// 如果是有有参构造函数，size就是生成的Iterator的成员数，每次Iterator调用next（）时，都会请求CoffeeGenerator的next（）
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		System.out.println("==============================");
		for (Coffee c : new CoffeeGenerator(7)) {
			System.out.println(c);
		}
	}

}
