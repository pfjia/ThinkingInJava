package net.mindview.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 适配器模式，将Generator适配到Collection的构造器上
 * 
 * @author pfjia
 *
 * @param <T>
 */
public class CollectionData<T> extends ArrayList<T> {
	public CollectionData(Generator<T> gen, int quantity) {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < quantity; i++) {
			add(gen.next());
		}
	}

	// A generic convenience method
	public static <T> Collection<T> list(Generator<T> gen, int quantity) {
		return new CollectionData<T>(gen, quantity);
	}
}
