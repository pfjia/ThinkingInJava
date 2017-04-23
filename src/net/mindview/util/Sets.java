package net.mindview.util;

import java.util.HashSet;
import java.util.Set;

public class Sets {

	// ����
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.addAll(b);
		return result;
	}

	// ����
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<T>(a);
		result.retainAll(b);
		return result;
	}

	// superset�в�����subset��Ԫ��
	public static <T> Set<T> difference(Set<T> superSet, Set<T> subSet) {
		Set<T> result = new HashSet<T>(superSet);
		result.removeAll(subSet);
		return result;
	}

	// a��b�в�ͬ��Ԫ��
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}

}
