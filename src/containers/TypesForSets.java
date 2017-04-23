package containers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class SetType {
	int i;

	public SetType(int n) {
		i = n;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof SetType && (i == ((SetType) obj).i);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(i);
	}
}

class HashType extends SetType {
	public HashType(int n) {
		// TODO Auto-generated constructor stub
		super(n);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return i;
	}
}

class TreeType extends SetType implements Comparable<TreeType> {

	public TreeType(int n) {
		// TODO Auto-generated constructor stub
		super(n);
	}

	@Override
	public int compareTo(TreeType o) {
		// TODO Auto-generated method stub
		return (o.i < i ? -1 : (o.i == i ? 0 : 1));
	}

}

public class TypesForSets {

	static <T> Set<T> fill(Set<T> set, Class<T> type) {
		try {
			for (int i = 0; i < 10; i++) {
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return set;
	}

	static <T> void test(Set<T> set, Class<T> type) {
		fill(set, type);
		fill(set, type);// Try to add dulicates
		fill(set, type);
		System.out.println(set);
	}

	public static void main(String[] args) {
		test(new HashSet<HashType>(), HashType.class);

		test(new LinkedHashSet<HashType>(), HashType.class);
		test(new TreeSet<TreeType>(), TreeType.class);

		// Things that don't work
		test(new HashSet<SetType>(), SetType.class);
		test(new HashSet<TreeType>(), TreeType.class);
		test(new LinkedHashSet<SetType>(), SetType.class);
		test(new LinkedHashSet<TreeType>(), TreeType.class);

		try {
			test(new TreeSet<SetType>(), SetType.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			test(new TreeSet<HashType>(), HashType.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
