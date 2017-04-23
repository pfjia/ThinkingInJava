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

	// size�ǡ�ĩ���ڱ������������ص�Iterator��ѭ������
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
	 * �ڲ���
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
		// CoffeeGenerator��next����ÿ�ζ��᷵��һ��Coffee��ʵ�����������ʹ���޲ι��캯����sizeΪ0�����ɵ�Iterator����Ϊ0,
		// ��������вι��캯����size�������ɵ�Iterator�ĳ�Ա����ÿ��Iterator����next����ʱ����������CoffeeGenerator��next����
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
		System.out.println("==============================");
		for (Coffee c : new CoffeeGenerator(7)) {
			System.out.println(c);
		}
	}

}
