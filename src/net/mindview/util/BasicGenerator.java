package net.mindview.util;

import java.lang.reflect.Constructor;

/**
 * automatically create a Generator,given a class with a default (no-arg)
 * constructor
 * 
 * @author pfjia
 *
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;

	public BasicGenerator(Class<T> type) {
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		try {
			// Assumes type is a public class:
			// return type.newInstance();
			// 若不是public可以使用反射
			Constructor<T> c = type.getConstructor();
			c.setAccessible(true);
			return c.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<T>(type);
	}
}
