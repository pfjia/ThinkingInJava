package net.mindview.util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ������ģʽ����Generator���䵽Collection�Ĺ�������
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
