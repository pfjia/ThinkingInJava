package net.mindview.util;

import java.util.LinkedHashMap;

/**
 * A map filled with data using a generator object;
 * 
 * @author pfjia
 *
 * @param <K>
 * @param <V>
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {
	// A single Pair Generaotr
	public MapData(Generator<Pair<K, V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair<K, V> p = gen.next();
			put(p.key, p.value);
		}
	}

	// Two separate Generators
	public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), genV.next());
		}
	}

	// A key Generator and a single value
	public MapData(Generator<K> genK, V value, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), value);
		}
	}

	// An Iterable and a value Generator
	public MapData(Iterable<K> genK, Generator<V> genV) {
		for (K key : genK) {
			put(key, genV.next());
		}
	}

	// An Iterable and a single value
	public MapData(Iterable<K> genK, V value) {
		for (K key : genK) {
			put(key, value);
		}
	}

	// Generic convenience methods

	// һ��Pair��Generator��Ԫ�ظ���
	public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen,
			int quantity) {
		return new MapData<K, V>(gen, quantity);
	}

	// һ��key��Generator ��һ��value��Generator ��Ԫ�ظ���
	public static <K, V> MapData<K, V> map(Generator<K> genK,
			Generator<V> genV, int quantity) {
		return new MapData<K, V>(genK, genV, quantity);
	}

	// һ��key��Generator ��һ��value ��Ԫ�ظ���
	public static <K, V> MapData<K, V> map(Generator<K> genK, V value,
			int quantity) {
		return new MapData<K, V>(genK, value, quantity);
	}

	// һ��key��Iterable ��һ��value��Generator
	public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
		return new MapData<K, V>(genK, genV);
	}

	// һ��key��Iterable ��һ��value
	public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
		return new MapData<K, V>(genK, value);
	}

}
