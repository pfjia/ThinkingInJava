package containers;

import java.util.WeakHashMap;

class Element {
	private String ident;

	public Element(String id) {
		// TODO Auto-generated constructor stub
		ident = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ident;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return ident.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof Element && ident.equals(((Element) obj).ident);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Finalizing " + getClass().getSimpleName() + " "
				+ ident);
	}
}

class Key extends Element {
	public Key(String id) {
		// TODO Auto-generated constructor stub
		super(id);
	}

}

class Value extends Element {
	public Value(String id) {
		// TODO Auto-generated constructor stub
		super(id);
	}
}

public class CanonicalMapping {
	public static void main(String[] args) {
		int size = 1000;
		Key[] keys = new Key[size];
		WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();
		for (int i = 0; i < size; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));
			if (i % 3 == 0) {
				keys[i] = k;
			}
			map.put(k, v);
		}
		System.gc();
	}
}
